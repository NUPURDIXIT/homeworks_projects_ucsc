import os
import sqlite3
import logging,re
from flask import Flask, request, session, g, redirect, url_for, abort, render_template, flash
from datetime import datetime
from ValidateForm import ValidateEmail
from ValidateForm import ValidatePhoneNumber
from ValidateForm import ValidateAll
from ValidateForm import ValidateMethod

app = Flask(__name__)
app.config.from_object(__name__)

# Load default config and override config from an environment variable
app.config.update(dict(
    DATABASE=os.path.join(app.root_path, 'flaskr.db'),
    SECRET_KEY='development key',
    USERNAME='admin',
    PASSWORD='default',
    LOGGING_FORMAT = '%(asctime)s - %(name)s - %(levelname)s - %(message)s',
    LOGGING_LOCATION = 'app.log',
    LOGGING_LEVEL = logging.DEBUG    
))

app.config.from_envvar('FLASKR_SETTINGS', silent=True)
# Configure logging
handler = logging.FileHandler(app.config['LOGGING_LOCATION'])
handler.setLevel(app.config['LOGGING_LEVEL'])
formatter = logging.Formatter(app.config['LOGGING_FORMAT'])
handler.setFormatter(formatter)
app.logger.addHandler(handler)

'''
#function to validate the email id
def is_email_address_valid(email):
	"""Validate the email address using a regex."""
	if not re.match(r'^[a-zA-Z0-9._]+@([a-zA-Z])+\.([a-zA-Z]+)$', email):
		return False
	return True

#function to validate the phone number
def is_phone_number_valid(phone_number):
	"""Validate the phonr number using a regex."""
	
	if not re.match(r'(\+[0-9]+\s*)?(\([0-9]+\))?[\s0-9\-]+[0-9]+', phone_number):
		return False
	return True
'''

#@app.route is a decorator used to match URLs to view functions in flask apps
#This is to show the register page for the users to enter the required fields
@app.route("/")
@app.route("/register")
def registerform():
	return render_template('register.html')


#This method perfoms the validations and if all ok, adds the row to the database
@app.route("/add",methods=['POST'])
def add():
	app.logger.info(str(request.form))
	db = get_db()

	now = datetime.now()
	name=request.form.get('PersonVisiting')
	email=request.form.get('Email')
	phone_number=request.form.get('Contact')
	employee_name=request.form.get('PersonToVisit')

	dict={'PersonVisiting':name,'Email':email,'Contact':phone_number,'PersonToVisit':employee_name}
	errors=''
	try:
		ValidateMethod(name,email,phone_number,employee_name)
	except ValidateAll:
		errors="<p>Please enter all the fields.</p>"
	except ValidateEmail:
		errors=errors+" <p>Please enter a valid email address</p>"
	except ValidatePhoneNumber:
		errors=errors+" <p>Please enter a valid phone number</p>"
	
	if errors:
		return render_template('register.html', dict=dict,errors=errors)

	        
	db.execute('insert into visitors (visitor_name, email, phone_number, employee_name, visit_date) values (?, ?, ?, ?, ?)',
	[name,email,phone_number,employee_name,now])
	db.commit()
	
	flash('New entry was successfully posted')

	return redirect("/")
	

   	
#This method deals with the functionality to show the complete list of visitors or based on from and to date
@app.route("/history")
def history():
	db=get_db()
	
	fromdate=request.args.get('fromdate')
	todate=request.args.get('todate')
	print 'from date is',fromdate
	print 'todate is',todate
	if fromdate==None:
		fromdate=''
	if todate==None:
		todate=''

	#Build the query to be executed in 2 cases: 1. Complete list is to be retrieved and 2.Filetered list on 
	# the basis of from and to date
	query = 'select * from visitors where 1 = 1' 

	if fromdate!='':
		query += " and visit_date >= '"+str(fromdate)+"'"

	if todate !='':
		query += " and visit_date <= '"+str(todate)+" 23:59:59'"

	cursor=db.execute(query)

	items=cursor.fetchall()

	#message gets displayed on the screen with the file name to which the data has been exported to excel file
	message=''
	if request.args.get('flag') =="Export to excel":
		print "Query is ",query
		message=export(items)

	return render_template('history.html',message=message,fromdate=fromdate,todate=todate,items=items)
	


#This method is responsible for saving the data to an excel file
def export(items):
	import xlwt
	file="Visitor_Log"
	now=datetime.now()

	#set the name of file by appending date-monthname-year_hourminutesecond.xls
	#This way each time a new file is generated
	file=now.strftime('%d-%b-%Y_%H%M%S')+'.xls'
	
	workbook=xlwt.Workbook()
	sheet=workbook.add_sheet("Visitors List")

	#to set the column width
	first_col=sheet.col(0);
	second_col=sheet.col(1);
	third_col=sheet.col(2);
	fourth_col=sheet.col(3);
	fifth_col=sheet.col(4);
	sixth_col=sheet.col(5);
	#xlwt by default sets the width to 11 characters. Width value of an integer is 1/256 of the width of the 
	#character '0' 

	#set the width of the columns to 256*w where w is the length of the characters required
	first_col.width=256*4       
	second_col.width=256*40
	third_col.width=256*40
	fourth_col.width=256*20
	fifth_col.width=256*40
	sixth_col.width=256*40
		
	#To set the styles in excel
	BG = xlwt.Pattern() 
	BG.pattern = BG.SOLID_PATTERN 
	BG.pattern_fore_colour = 3 

	FontStyle = xlwt.XFStyle() 
	FontStyle.pattern = BG 

	
	#implementing the cell style in the headers of the excel file
	sheet.write(0,1,'Visitor Name',FontStyle)
	sheet.write(0,2,'Email',FontStyle)
	sheet.write(0,3,'Phone number',FontStyle)
	sheet.write(0,4,'Employee Name',FontStyle)
	sheet.write(0,5,'Visit date',FontStyle)
	for i,v in enumerate(items):
		sheet.write(i+1,0,v[0])
		sheet.write(i+1,1,v[1])
		sheet.write(i+1,2,v[2])
		sheet.write(i+1,3,v[3])
		sheet.write(i+1,4,v[4])
	  	sheet.write(i+1,5,v[5])
	workbook.save(file)
	message="File has been saved to "+file
	return message
	

def connect_db():
    """Connects to the specific database."""
    rv = sqlite3.connect(app.config['DATABASE'])
    rv.row_factory = sqlite3.Row
    return rv

def get_db():
    """Opens a new database connection if there is none yet for the
    current application context.
    """
    if not hasattr(g, 'sqlite_db'):
        g.sqlite_db = connect_db()
    return g.sqlite_db

@app.teardown_appcontext
def close_db(error):
    """Closes the database again at the end of the request."""
    if hasattr(g, 'sqlite_db'):
        g.sqlite_db.close()



def init_db():
    db = get_db()
    with app.open_resource('schema.sql', mode='r') as f:
        db.cursor().executescript(f.read())
    db.commit()

@app.cli.command('initdb')
def initdb_command():
    """Initializes the database."""
    init_db()
    print 'Initialized the database.'





if __name__ == "__main__":
	app.run()