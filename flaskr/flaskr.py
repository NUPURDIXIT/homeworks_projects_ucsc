import os
import sqlite3
import logging,re
from flask import Flask, request, session, g, redirect, url_for, abort, render_template, flash
#from wtforms import Form, TextField, TextAreaField, validators, StringField, SubmitField
from datetime import datetime
#from datetime import 

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


def is_email_address_valid(email):
	"""Validate the email address using a regex."""
	if not re.match(r'^[a-zA-Z0-9._]+@([a-zA-Z])+\.([a-zA-Z]+)$', email):
		return False
	return True

def is_phone_number_valid(phone_number):
	"""Validate the phonr number using a regex."""
	
	if not re.match(r'(\+[0-9]+\s*)?(\([0-9]+\))?[\s0-9\-]+[0-9]+', phone_number):
		return False
	return True




@app.route("/")
@app.route("/register")
def registerform():
	return render_template('register.html')


@app.route("/add",methods=['POST'])
def add():
	app.logger.info(str(request.form))
	db = get_db()

	now = datetime.now()

	errors=''
	name=request.form.get('PersonVisiting')
	print "name is: ",name
	# The request is POST with some data, get POST data and validate it.
    # The form data is available in request.form dictionary. Stripping it to remove
    # leading and trailing whitespaces

    #name=request.form['PersonVisiting'].strip()
	email=request.form.get('Email')
	phone_number=request.form.get('Contact')
	employee_name=request.form.get('PersonToVisit')

	dict={'PersonVisiting':name,'Email':email,'Contact':phone_number,'PersonToVisit':employee_name}
	# Check if all the fields are non-empty and raise an error otherwise
	if not name or not email or not phone_number or not employee_name:
		errors="<p>Please enter all the fields.</p>"
		print "error is",errors
	elif not errors:
		if not is_email_address_valid(email):
			errors=errors+" <p>Please enter a valid email address</p>"
	# Validate the email address and raise an error if it is invalid
		if not is_phone_number_valid(phone_number):
			errors=errors+" <p>Please enter a valid phone number</p>"

# If there are no errors, then insert the row in database
	if errors:
		return render_template('register.html', dict=dict,errors=errors)
        
	db.execute('insert into visitors (visitor_name, email, phone_number, employee_name, visit_date) values (?, ?, ?, ?, ?)',
	[name,email,phone_number,employee_name,now])
	db.commit()
	#[request.form['PersonVisiting'], request.form['Email'],request.form['Contact'],request.form['PersonToVisit'],now])
    
	
	flash('New entry was successfully posted')

	
	return redirect("/")
	

   	

@app.route("/history")
def history():
	db=get_db()
	
	fromdate=request.args.get('fromdate')
	todate=request.args.get('todate')
	query = 'select * from visitors where 1 = 1' 
	if fromdate != None:
		query += " and visit_date >= '"+str(fromdate)+"'"

	if todate !=None :
		query += " and visit_date <= '"+str(todate)+" 23:59:59'"

	cursor=db.execute(query)

	print "valueof flag is:",request.args.get('flag')

	items=cursor.fetchall()

	if request.args.get('flag') =="Export to excel":
		print "Query is ",query

		export(items)
		return render_template('history.html',items=items)
	else:
		print "Query is ",query
		return render_template('history.html',items=items)



def export(items):
	import xlwt
	
	workbook=xlwt.Workbook()
	sheet=workbook.add_sheet("Visitors List")
	sheet.write(0,1,'Visitor Name')
	sheet.write(0,2,'Email')
	sheet.write(0,3,'Phone number')
	sheet.write(0,4,'Employee Name')
	sheet.write(0,5,'Visit date')
	for i,v in enumerate(items):
		sheet.write(i+1,0,v[0])
		sheet.write(i+1,1,v[1])
		sheet.write(i+1,2,v[2])
		sheet.write(i+1,3,v[3])
		sheet.write(i+1,4,v[4])
	  	sheet.write(i+1,5,v[5])
		
		
	workbook.save("visitorlog2.xls")
	

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