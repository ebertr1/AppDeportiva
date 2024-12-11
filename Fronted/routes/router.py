
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


#CRUD DE CAMPEONATO
    #listar campeonatos
@router.route('/admin/campeonato/list')
def listCampeonato():
    r= request.get("http://localhost:8078/myapp/campeonato/list")
    print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/campeonato/listaCampeonato.html', list = data["data"])

    #registrar campeonato
@router.route('/admin/campeonato/register')
def view_register_campeonato():
    r = requests.get("http://localhost:8078/myapp/campeonato/listType")
    r2 = requests.get("http://localhost:8078/myapp/campeonato/listTypeCategoria")
    data = r.json()
    data2 = r2.json()
    print(r.json())
    return render_template('fragmento/campeonato/registroCampeonato.html', lista = data["data"], lista2 = data2["data"])

    #guardar campeonato
@router.route('/admin/campeonato/save', methods=["POST"])
def save_campeonato():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "nombre": form["nom"],
        "fechaInicio": form["fechaInic"],
        "fechaFin": form["fechaFin"],
        "categoria": form["categoria"],
    }
    r = requests.post("http://localhost:8078/myapp/campeonato/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/campeonato/list")

    #editar campeonato
@router.route('/admin/campeonato/edit/<int:id>')
def view_edit_campeonato(id): 
    r = requests.get("http://localhost:8078/myapp/campeonato/listType")
    r1 = requests.get(f"http://localhost:8078/myapp/campeonato/get/{id}") 
    r2 = requests.get("http://localhost:8078/myapp/campeonato/listTypeCategoria")
    data = r.json()
    data1 = r1.json()
    data2 = r2.json()
    
    if r1.status_code == 200:
        return render_template('fragmento/campeonato/editarCampeonato.html', list=data["data"], list2=data2["data"], person=data1["data"]) 
    else:
        flash(data1["data"], category='error')
        return redirect("/admin/campeonato/list")
    

    #actualizar campeonato
@router.route('/admin/campeonato/update', methods=["POST"])
def update_campeonato():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
    "nombre": form["nom"],
    "categoria": form["categoria"] if "categoria" in form else "",
    "fechaInicio": form["fechaInic"],
    "fechaFin": form["fechaFin"],
    
    }
    r = requests.post("http://localhost:8078/myapp/campeonato/update", data=json.dumps(dataF), headers=headers)
    print(r)
    dat = r.json()
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/campeonato/list")
    
    
    #eliminar campeonato
@router.route('/admin/campeonato/delete/<int:id>', methods=["POST"])
def delete_campeonato(id):
    # Realiza una solicitud DELETE a la API
    r = requests.delete(f"http://localhost:8078/myapp/campeonato/delete/{id}")
    
    # Verifica la respuesta de la API
    if r.status_code == 200:
        flash("Campeonato eliminado exitosamente.", category='info')
    else:
        flash("No se pudo eliminar el campeonato.", category='error')
    
    return redirect(url_for('router.list'))

#CRUD DE REGLAMENTO
    #listar reglamentos
@router.route('/admin/reglamento/list')
def listReglamento():
    r= request.get("http://localhost:8078/myapp/reglamento/list")
    print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/reglamento/listaReglamento.html', list = data["data"])

    #registrar reglamento
@router.route('/admin/reglamento/register')
def view_register_reglamento():
    r = requests.get("http://localhost:8078/myapp/reglamento/listType")
    r2 = requests.get("http://localhost:8078/myapp/reglamento/listTypeFormato")
    data = r.json()
    data2 = r2.json()
    print(r.json())
    return render_template('fragmento/reglamento/registroReglamento.html', lista = data["data"], lista2 = data2["data"])

    #guardar reglamento
@router.route('/admin/reglamento/save', methods=["POST"])
def save_equipo():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "nombre": form["nom"],
        "descripcion": form["descrip"],
        "formato": form["form"]
    }
    r = requests.post("http://localhost:8078/myapp/reglamento/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/reglamento/list")

    #editar reglamento
@router.route('/admin/reglamento/edit/<int:id>')
def view_edit_reglamento(id): 
    r = requests.get("http://localhost:8078/myapp/reglamento/listType")
    r1 = requests.get(f"http://localhost:8078/myapp/reglamento/get/{id}") 
    r2 = requests.get("http://localhost:8078/myapp/reglamento/listTypeFormato")
    data = r.json()
    data1 = r1.json()
    data2 = r2.json()
    
    if r1.status_code == 200:
        return render_template('fragmento/reglamento/editarReglamento.html', list=data["data"], list2=data2["data"], person=data1["data"]) 
    else:
        flash(data1["data"], category='error')
        return redirect("/admin/reglamento/list")
    

    #actualizar reglamento
@router.route('/admin/reglamento/update', methods=["POST"])
def update_reglamento():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
    "nombre": form["nom"],
    "formato": form["formato"] if "formato" in form else "",
    "descripcion": form["descripcion"]
    
    }
    r = requests.post("http://localhost:8078/myapp/reglamento/update", data=json.dumps(dataF), headers=headers)
    print(r)
    dat = r.json()
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/reglamento/list")
    
    
    #eliminar reglamento
@router.route('/admin/reglamento/delete/<int:id>', methods=["POST"])
def delete_reglamento(id):
    # Realiza una solicitud DELETE a la API
    r = requests.delete(f"http://localhost:8078/myapp/reglamento/delete/{id}")
    
    # Verifica la respuesta de la API
    if r.status_code == 200:
        flash("reglamento eliminado exitosamente.", category='info')
    else:
        flash("No se pudo eliminar el reglamento.", category='error')
    
    return redirect(url_for('router.list'))


#CRUD DE CALENDARIO   
    #listar calendarios
@router.route('/admin/calendario/list')
def listCalendario():
    r = requests.get("http://localhost:8078/myapp/calendario/list")
    print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/calendario/listaCalendario.html', list = data["data"])

    #registrar calendario
@router.route('/admin/calendario/register')
def view_register_calendario():
    r = requests.get("http://localhost:8078/myapp/calendario/listType")
    data = r.json()
    print(r.json())
    return render_template('fragmento/calendario/registroCalendario.html', lista = data["data"])

    #guardar calendario
@router.route('/admin/calendario/save', methods=["POST"])
def save_calendario():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "fechaJornada": form["fecha"],
        "nroEncuentros": form["nroEnc"],
    }
    r = requests.post("http://localhost:8078/myapp/calendario/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/calendario/list")


#CRUD DE ENCUENTRO   
    #listar encuentros
@router.route('/admin/encuentro/list')
def listEncuentro():
    r = requests.get("http://localhost:8078/myapp/encuentro/list")
    print(type(r.json()))
    print(r.json())
    data = r.json()
    return render_template('fragmento/encuentro/listaEncuentro.html', list = data["data"])

    #registrar encuentro
@router.route('/admin/encuentro/register')
def view_register_encuentro():
    r = requests.get("http://localhost:8078/myapp/encuentro/listType")
    r2 = requests.get("http://localhost:8078/myapp/encuentro/listTypeGenero")
    data = r.json()
    data2 = r2.json()
    print(r.json())
    return render_template('fragmento/encuentro/registroEncuentro.html', lista = data["data"], lista2 = data2["data"])

    #guardar encuentro
@router.route('/admin/encuentro/save', methods=["POST"])
def save_encuentro():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idEquipo1": form["equip1"],
        "idEquipo2": form["equip2"],
        "ubicacion": form["ubic"],
        "fono": form["ubic"],
        "estado": form["esatdo"],
        "horaInicio": form["horaInic"],
    }
    r = requests.post("http://localhost:8078/myapp/encuentro/save", data=json.dumps(dataF), headers=headers)
    dat = r.json()

    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/encuentro/list")













