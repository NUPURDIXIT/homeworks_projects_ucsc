import os
import sqlite3
import logging
from flask import Flask, request, session, g, redirect, url_for, abort, render_template, flash
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

@app.route("/")
@app.route("/register")
def registerform():
    return render_template('register.html', name='Nupur Nupur')

@app.route("/add",methods=['POST'])
def add():
    app.logger.info(str(request.form))
    db = get_db()

    now = datetime.now()
    #flag=validations()
    flag=True

    # name=request.form['PersonVisiting']
    # email=request.form['Email']
    # contact=request.form['Contact']
    # employeename=request.form['PersonToVisit']

    if flag==True:
    	db.execute('insert into visitors (visitor_name, email, phone_number, employee_name, visit_date) values (?, ?, ?, ?, ?)',
    	[request.form['PersonVisiting'], request.form['Email'],request.form['Contact'],request.form['PersonToVisit'],now])
    	db.commit()
    	flash('New entry was successfully posted')
    return redirect("/")

@app.route("/history")
def history():
	db=get_db()
	#formData = new FormData();
	#dict = {'fromDate':request.args['fromdate'],'todate':request.args['todate']}
	#fromdate= ''
	fromdate=request.args.get('fromdate')
	todate=request.args.get('todate')


	#if request.args.has_key('fromdate'):
	#	fromdate = request.args['fromdate']

	#todate = ''
	#if request.args.has_key('todate'):
	#	todate = request.args['todate']
	print "from date is",fromdate
	print "todate is",todate
	#dict = {'fromdate':request.form['FromDate'],'todate':request.form['ToDate']}
	query = 'select * from visitors where 1 = 1' 
	if fromdate != None:
		query += " and visit_date >= '"+str(fromdate)+"'"

	if todate !=None :
		query += " and visit_date <= '"+str(todate)+" 23:59:59'"
	print "Query is ",query
	cursor=db.execute(query)
	
	return render_template('history.html',items=cursor.fetchall())
	

def export():
	import xlwt
    return "Export to Excel"

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


#def validations():
#	match = re.match(r'^[a-zA-Z0-9._]+@([a-zA-Z])+\.([a-zA-Z]+)$', request.form[email])
#	if len(request.form[name])==0:
#		flag=False
#	elif not(match):






if __name__ == "__main__":
    app.run()