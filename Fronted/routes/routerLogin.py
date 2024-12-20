from flask import Flask, json, flash,Blueprint, url_for, jsonify, make_response, request, render_template, redirect, abort
import requests
routerLogin = Blueprint('routerLogin', __name__)

# Login 
@routerLogin.route('/index')
def view_login():
    return render_template('fragmento/inicial/login.html')


# Iniciar Sesion
@routerLogin.route('/index', methods=["POST"])
def iniciarSesion():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "correo": form["email"],
        "contrasenia": form["password"]
    }

    r = requests.post("http://localhost:8078/myapp/login/auth", data=json.dumps(dataF), headers=headers)
    
    # Validacion si se obtuvo acceso, o se obtuvo un token
    # Validar si el token es valido (No recomendable validar en front), luego 

    data = r.json()

    if data["msg"] == "OK":
        return render_template('fragmento/template.html')
    else: flash("Credenciales incorrectas", category='info')


# Logica para cerrar Sesion
# Debe eliminarse el token de la bdd
# Debe actualizarse la aplicacion cuando no tiene token en el header
# Debe actualizarse la aplicacion cuando tiene token invalido o caduco en el header

# Logica para recuperacion de contrasenia