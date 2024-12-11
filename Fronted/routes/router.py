
from flask import Flask, json, flash,Blueprint, url_for, jsonify, make_response, request, render_template, redirect, abort
import requests
router = Blueprint('router', __name__)

@router.route('/')
def home():
    return render_template('template.html')


@router.route('/admin')
def admin():
    return render_template('fragmento/inicial/admin.html')


@router.route('/admin/person/list')
def list():
    r = requests.get("http://localhost:8078/api/person/list")
    print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/persona/lista.html', list = data["data"])



@router.route('/admin/person/edit/<int:id>')  # Asegúrate de que 'id' se define como entero
def view_edit_person(id):  # Agrega 'id' como parámetro de la función
    r = requests.get("http://localhost:8078/api/person/list")
    data = r.json()
    
    # Usa el 'id' que se pasa a la función
    r1 = requests.get(f"http://localhost:8078/api/person/get/{id}")  # Usar f-string para interpolar el id
    data1 = r1.json()
    
    if r1.status_code == 200:
        return render_template('fragmento/persona/editar.html', list=data["data"], person=data1["data"]) 
    else:
        flash(data1["data"], category='error')
        return redirect("/admin/person/list")


@router.route('/admin/person/register')
def view_register_person():
    r = requests.get("http://localhost:8078/api/person/list")
    data = r.json()
    print(r.json())
    return render_template('fragmento/persona/registro.html', list = data["data"])

@router.route('/admin/person/save', methods=["POST"])
def save_person():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "apellido": form["ape"],
        "nombre": form["nom"],
        "dni": form["dni"],
        "celular": form["fono"],
    }
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/person/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()
    
    # Manejo de la respuesta
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    
    # Redirigir después de guardar
    return redirect("/admin/person/list")


@router.route('/admin/person/delete/<int:id>', methods=["POST"])
def delete_person(id):
    # Realiza una solicitud DELETE a la API
    r = requests.delete(f"http://localhost:8078/api/person/delete/{id}")
    
    # Verifica la respuesta de la API
    if r.status_code == 200:
        flash("Cliente eliminado exitosamente.", category='info')
    else:
        flash("No se pudo eliminar el cliente.", category='error')
    
    return redirect(url_for('router.list'))

@router.route('/admin/person/update', methods=["POST"])
def update_person():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idPersona": form["id"],
        "apellido": form["ape"],
        "nombre": form["nom"],
        "dni": form["dni"],
        "celular": form["fono"],
    }
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/person/update", data=json.dumps(dataF), headers=headers)
    print(r)
    dat = r.json()
    # Manejo de la respuesta
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/person/list")


    
    













