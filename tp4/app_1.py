from flask import Flask, render_template, request
import mysql.connector

app = Flask(__name__)
 
# MySQL configuration
db_config = {
    'host': 'tp4-sql',
    'user': 'root',
    'password': 'foo',
    'database': 'demosql',
	'port': '3306'
}


@app.route('/')
def index():
    # Initialize MySQL connection
    conn = mysql.connector.connect(**db_config)
    cursor = conn.cursor() 

    # Sample query
    query = "SELECT * FROM myTable"
    cursor.execute(query)
    data = cursor.fetchall()
    
    # Close the cursor and connection
    cursor.close()
    conn.close()
    
    return render_template('index.html', data=data)

@app.route('/newuser', methods = ['POST', 'GET'])
def saisie():
    if request.method == 'POST':
        res = request.form.get("regex")
        return res.text()

if __name__ == '__main__':
    app.run(debug=True)
    

