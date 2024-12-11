
from flask import Flask, json, flash,Blueprint, url_for, jsonify, make_response, request, render_template, redirect, abort
import requests
router = Blueprint('router', __name__)

@router.route('/')
def home():
    return render_template('template.html')


@router.route('/admin')
def admin():
    return render_template('fragmento/inicial/login.html')


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


#CRUD DE EQUIPO   
    #listar equipos
@router.route('/admin/equipo/list')
def listEquipo():
    r = requests.get("http://localhost:8078/myapp/equipo/list")
    print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/equipo/listaEquipo.html', list = data["data"])

    #registrar equipo
@router.route('/admin/equipo/register')
def view_register_equipo():
    r = requests.get("http://localhost:8078/myapp/dirigente/listType")
    r2 = requests.get("http://localhost:8078/myapp/dirigente/listTypeGenero")
    data = r.json()
    data2 = r2.json()
    print(r.json())
    return render_template('fragmento/equipo/registroEquipo.html', lista = data["data"], lista2 = data2["data"])

    #guardar equipo
@router.route('/admin/equipo/save', methods=["POST"])
def save_equipo():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "apellido": form["ape"],
        "nombre": form["nom"],
        "tipo": form["tipo"],
        "ident": form["ident"],
        "fono": form["fono"],
        "exp": form["exp"],
        "fecha": form["fecha"],
    }
    r = requests.post("http://localhost:8078/myapp/dirigente/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/equipo/list")


#CRUD DE DIRIGENTE  
    #listar dirigentes
@router.route('/admin/dirigente/list')
def listDirigente():
    r = requests.get("http://localhost:8078/myapp/dirigente/list")
    print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/dirigente/listaDirigente.html', list = data["data"])

    #registrar dirigente
@router.route('/admin/dirigente/register')
def view_register_dirigente():
    r = requests.get("http://localhost:8078/myapp/dirigente/listType")
    r2 = requests.get("http://localhost:8078/myapp/dirigente/listTypeGenero")
    data = r.json()
    data2 = r2.json()
    print(r.json())
    return render_template('fragmento/dirigente/registroDirigente.html', lista = data["data"], lista2 = data2["data"])

    #guardar dirigente
@router.route('/admin/dirigente/save', methods=["POST"])
def save_dirigente():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "apellido": form["ape"],
        "nombre": form["nom"],
        "tipo": form["tipo"],
        "identificacion": int(form["ident"]) if form["ident"].isdigit() else None,
        "celular": form["fono"],
        "genero": form["genero"],
        "aniosExperiencia": int(form["exp"]) if form["exp"].isdigit() else 0,  
        "fechaNacimiento": form["fecha"]
    }
    r = requests.post("http://localhost:8078/myapp/dirigente/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/dirigente/list")    

    #editar dirigente
@router.route('/admin/dirigente/edit/<int:id>')
def view_edit_dirigente(id): 
    r = requests.get("http://localhost:8078/myapp/dirigente/listType")
    r1 = requests.get(f"http://localhost:8078/myapp/dirigente/get/{id}") 
    r2 = requests.get("http://localhost:8078/myapp/dirigente/listTypeGenero")
    data = r.json()
    data1 = r1.json()
    data2 = r2.json()
    
    if r1.status_code == 200:
        return render_template('fragmento/dirigente/editarDirigente.html', list=data["data"], list2=data2["data"], person=data1["data"]) 
    else:
        flash(data1["data"], category='error')
        return redirect("/admin/dirigente/list")
    
    
    #actualizar dirigente
@router.route('/admin/dirigente/update', methods=["POST"])
def update_dirigente():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
    "apellido": form["ape"],
    "nombre": form["nom"],
    "tipo": form["tipo"] if "tipo" in form else "",
    "identificacion": int(form["ident"]) if form["ident"].isdigit() else 0,
    "celular": form["fono"],
    "genero": form["genero"],
    "aniosExperiencia": int(form["exp"]) if form["exp"].isdigit() else 0,  

    }
    r = requests.post("http://localhost:8078/myapp/dirigente/update", data=json.dumps(dataF), headers=headers)
    print(r)
    dat = r.json()
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/dirigente/list")
    
    
    #eliminar dirigente
@router.route('/admin/dirigente/delete/<int:id>', methods=["POST"])
def delete_dirigente(id):
    # Realiza una solicitud DELETE a la API
    r = requests.delete(f"http://localhost:8078/myapp/dirigente/delete/{id}")
    
    # Verifica la respuesta de la API
    if r.status_code == 200:
        flash("Cliente eliminado exitosamente.", category='info')
    else:
        flash("No se pudo eliminar el cliente.", category='error')
    
    return redirect(url_for('router.list'))

#CRUD DE JUGADOR
    #listar jugadores
@router.route('/admin/jugador/list')
def listJugador():
    r = requests.get("http://localhost:8078/myapp/jugador/list")
    print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/jugador/listaJugador.html', list = data["data"])


    #registrar jugador
@router.route('/admin/jugador/register')
def view_register_jugador():
    r = requests.get("http://localhost:8078/myapp/jugador/listType")
    r2 = requests.get("http://localhost:8078/myapp/jugador/listTypeGenero")
    data = r.json()
    data2 = r2.json()
    print(r.json())
    return render_template('fragmento/jugador/registroJugador.html', lista = data["data"], lista2 = data2["data"])
    
    #guardar jugador
@router.route('/admin/jugador/save', methods=["POST"])
def save_jugador():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "apellido": form["ape"],
        "nombre": form["nom"],
        "tipo": form["tipo"],
        "identificacion": int(form["ident"]) if form["ident"].isdigit() else None,
        "celular": form["fono"],
        "genero": form["genero"],
        "numCamiseta": int(form["nCam"]) if form["nCam"].isdigit() else 0,  
        "fechaNacimiento": form["fecha"]
    }
    r = requests.post("http://localhost:8078/myapp/jugador/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/dirigente/list")    

    #editar jugador
    
    #eliminar jugador