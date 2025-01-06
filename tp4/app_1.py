from flask import Flask, render_template, request
import mysql.connector
import re

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

@app.route("/monFormulaire")
def monForm():
	return render_template("form.html")

@app.route('/newuser', methods = ['POST', 'GET'])
def newuser():
    if request.method == 'POST':
        res = request.form.get("regex")

        reg1 = ".{6,}"
        reg2= ".*\d+.*"
        reg3= ".*[a-z]+.*"
        reg4= ".*[A-Z]+.*"
        reg5= ".*((#)|(%)|(\{)|(\})|(@)).*"

        if re.fullmatch(reg1, res) == None:
            return("Mot de passe incorect, il faut au moins 6 caractères")
        if re.fullmatch(reg2, res) == None:
            return("Mot de passe incorect, il faut au moins un chiffre")
        if re.fullmatch(reg3, res) == None:
            return("Mot de passe incorect, il faut au moins une minuscule")
        if re.fullmatch(reg4, res) == None:
            return("Mot de passe incorect, il faut une majuscule")
        if re.fullmatch(reg5, res) == None:
            return("Mot de passe incorect, il faut au moins un de ces caractères #%{}@")
        else:
            return res
        

if __name__ == '__main__':
    app.run(debug=True)
    

