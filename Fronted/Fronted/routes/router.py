
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



@router.route('/admin/person/edit/<int:id>')  
def view_edit_person(id):  
    r = requests.get("http://localhost:8078/api/person/list")
    data = r.json()
    
   
    r1 = requests.get(f"http://localhost:8078/api/person/get/{id}")  
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

# CRUD DE ARBITRO
@router.route('/admin/arbitro/list')
def list_arbitros():
    # Realizar solicitud GET a la API
    r = requests.get("http://localhost:8078/api/arbitro/list")
    data = r.json()
        
    if r.status_code == 200:
        return render_template('listaArbitro.html', list=data["data"])
    else:
        flash("Error al obtener la lista de árbitros", category='error')
        return redirect(url_for('router.index'))

@router.route('/admin/arbitro/register')
def register_arbitro():
    return render_template('registroArbitro.html')

@router.route('/admin/arbitro/edit/<int:id>')
def edit_arbitro(id):
    # Realizar solicitud GET a la API
    r = requests.get(f"http://localhost:8078/api/arbitro/get/{id}")
    data = r.json()
    
    if r.status_code == 200:
        return render_template('editarArbitro.html', arbitro=data["data"])
    else:
        flash("Error al obtener el árbitro", category='error')
        return redirect(url_for('router.list_arbitros'))

@router.route('/admin/arbitro/save', methods=["POST"])
def save_arbitro():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "nombre": form["nom"],
        "apellido": form["ape"],
        "identificacion": form["ident"],
        "celular": form["fono"],
        "genero": form["genero"],
        "asociacion": form["asociacion"]
    }
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/arbitro/save", 
                     data=json.dumps(dataF), 
                     headers=headers)
    dat = r.json()
    
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/arbitro/list")

@router.route('/admin/arbitro/update', methods=["POST"])
def update_arbitro():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idArbitro": form["id"],
        "nombre": form["nom"],
        "apellido": form["ape"],
        "identificacion": form["ident"],
        "celular": form["fono"],
        "genero": form["genero"],
        "asociacion": form["asociacion"]
    }
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/arbitro/update", 
                     data=json.dumps(dataF), 
                     headers=headers)
    dat = r.json()
    
    if r.status_code == 200:
        flash("Se ha actualizado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/arbitro/list")

@router.route('/admin/arbitro/delete/<int:id>', methods=["POST"])
def delete_arbitro(id):
    headers = {'Content-type': 'application/json'}
    dataF = {"idArbitro": id}
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/arbitro/delete", 
                     data=json.dumps(dataF), 
                     headers=headers)
    
    if r.status_code == 200:
        flash("Árbitro eliminado exitosamente", category='info')
    else:
        flash("No se pudo eliminar el árbitro", category='error')
    
    return redirect(url_for('router.list_arbitros'))

# CRUD DE ENCUENTROS
@router.route('/admin/encuentro/list')
def list_encuentros():
    # Realizar solicitud GET a la API
    r = requests.get("http://localhost:8078/api/encuentro/list")
    data = r.json()
    
    if r.status_code == 200:
        return render_template('listaEncuentro.html', list=data["data"])
    else:
        flash("Error al obtener la lista de encuentros", category='error')
        return redirect(url_for('router.index'))

@router.route('/admin/encuentro/register')
def register_encuentro():
    return render_template('registroEncuentro.html')

@router.route('/admin/encuentro/edit/<int:id>')
def edit_encuentro(id):
    # Realizar solicitud GET a la API
    r = requests.get(f"http://localhost:8078/api/encuentro/get/{id}")
    data = r.json()
    
    if r.status_code == 200:
        return render_template('editarEncuentro.html', encuentro=data["data"])
    else:
        flash("Error al obtener el encuentro", category='error')
        return redirect(url_for('router.list_encuentros'))

@router.route('/admin/encuentro/save', methods=["POST"])
def save_encuentro():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idInscrito1": form["idInscrito1"],
        "idInscrito2": form["idInscrito2"],
        "ubicacion": form["ubicacion"],
        "identificacion": form["identificacion"],
        "estado": form["estado"],
        "horaInicio": form["horaInicio"]
    }
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/encuentro/save", 
                     data=json.dumps(dataF), 
                     headers=headers)
    dat = r.json()
    
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/encuentro/list")

@router.route('/admin/encuentro/update', methods=["POST"])
def update_encuentro():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idEncuentro": form["idEncuentro"],
        "idInscrito1": form["idInscrito1"],
        "idInscrito2": form["idInscrito2"],
        "ubicacion": form["ubicacion"],
        "identificacion": form["identificacion"],
        "estado": form["estado"],
        "horaInicio": form["horaInicio"]
    }
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/encuentro/update", 
                     data=json.dumps(dataF), 
                     headers=headers)
    dat = r.json()
    
    if r.status_code == 200:
        flash("Se ha actualizado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/encuentro/list")

@router.route('/admin/encuentro/delete/<int:id>', methods=["POST"])
def delete_encuentro(id):
    headers = {'Content-type': 'application/json'}
    dataF = {"idEncuentro": id}
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/encuentro/delete", 
                     data=json.dumps(dataF), 
                     headers=headers)
    
    if r.status_code == 200:
        flash("Encuentro eliminado exitosamente", category='info')
    else:
        flash("No se pudo eliminar el encuentro", category='error')
    
    return redirect(url_for('router.list_encuentros'))

#CRUD DE INFRACCIONES

@router.route('/admin/infraccion/list')
def list_infracciones():
    # Realizar solicitud GET a la API
    r = requests.get("http://localhost:8078/api/infraccion/list")
    data = r.json()
    
    if r.status_code == 200:
        return render_template('listaInfracciones.html', list=data["data"])
    else:
        flash("Error al obtener la lista de infracciones", category='error')
        return redirect(url_for('router.index'))

@router.route('/admin/infraccion/register')
def register_infraccion():
    return render_template('registroInfracciones.html')

@router.route('/admin/infraccion/edit/<int:id>')
def edit_infraccion(id):
    # Realizar solicitud GET a la API
    r = requests.get(f"http://localhost:8078/api/infraccion/get/{id}")
    data = r.json()
    
    if r.status_code == 200:
        return render_template('editarInfracciones.html', infraccion=data["data"])
    else:
        flash("Error al obtener la infracción", category='error')
        return redirect(url_for('router.list_infracciones'))

@router.route('/admin/infraccion/save', methods=["POST"])
def save_infraccion():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "numTarjeta": form["numTarjeta"],
        "identificacionJugador": form["identificacionJugador"],
        "colorTarjeta": form["colorTarjeta"]
    }
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/infraccion/save", 
                     data=json.dumps(dataF), 
                     headers=headers)
    dat = r.json()
    
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/infraccion/list")

@router.route('/admin/infraccion/update', methods=["POST"])
def update_infraccion():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idInfraccion": form["idInfraccion"],
        "numTarjeta": form["numTarjeta"],
        "identificacionJugador": form["identificacionJugador"],
        "colorTarjeta": form["colorTarjeta"]
    }
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/infraccion/update", 
                     data=json.dumps(dataF), 
                     headers=headers)
    dat = r.json()
    
    if r.status_code == 200:
        flash("Se ha actualizado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/infraccion/list")

@router.route('/admin/infraccion/delete/<int:id>', methods=["POST"])
def delete_infraccion(id):
    headers = {'Content-type': 'application/json'}
    dataF = {"idInfraccion": id}
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/infraccion/delete", 
                     data=json.dumps(dataF), 
                     headers=headers)
    
    if r.status_code == 200:
        flash("Infracción eliminada exitosamente", category='info')
    else:
        flash("No se pudo eliminar la infracción", category='error')
    
    return redirect(url_for('router.list_infracciones'))
    
# CRUD DE RESULTADOS
@router.route('/admin/resultado/list')
def list_resultados():
    # Realizar solicitud GET a la API
    r = requests.get("http://localhost:8078/api/resultado/list")
    data = r.json()
    
    if r.status_code == 200:
        return render_template('listaResultado.html', list=data["data"])
    else:
        flash("Error al obtener la lista de resultados", category='error')
        return redirect(url_for('router.index'))

@router.route('/admin/resultado/register')
def register_resultado():
    return render_template('registroResultado.html')

@router.route('/admin/resultado/edit/<int:id>')
def edit_resultado(id):
    # Realizar solicitud GET a la API
    r = requests.get(f"http://localhost:8078/api/resultado/get/{id}")
    data = r.json()
    
    if r.status_code == 200:
        return render_template('editarResultado.html', resultado=data["data"])
    else:
        flash("Error al obtener el resultado", category='error')
        return redirect(url_for('router.list_resultados'))

@router.route('/admin/resultado/save', methods=["POST"])
def save_resultado():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "equipoGanador": form["equipoGanador"],
        "equipoPerdedor": form["equipoPerdedor"],
        "golesEquipo1": form["golesEquipo1"],
        "golesEquipo2": form["golesEquipo2"],
        "empate": form["empate"],
        "puntosEncuentro": form["puntosEncuentro"]
    }
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/resultado/save", 
                     data=json.dumps(dataF), 
                     headers=headers)
    dat = r.json()
    
    if r.status_code == 200:
        flash("Se ha guardado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/resultado/list")

@router.route('/admin/resultado/update', methods=["POST"])
def update_resultado():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
        "idResultado": form["idResultado"],
        "equipoGanador": form["equipoGanador"],
        "equipoPerdedor": form["equipoPerdedor"],
        "golesEquipo1": form["golesEquipo1"],
        "golesEquipo2": form["golesEquipo2"],
        "empate": form["empate"],
        "puntosEncuentro": form["puntosEncuentro"]
    }
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/resultado/update", 
                     data=json.dumps(dataF), 
                     headers=headers)
    dat = r.json()
    
    if r.status_code == 200:
        flash("Se ha actualizado correctamente", category='info')
    else:
        flash(str(dat["data"]), category='error')
    return redirect("/admin/resultado/list")

@router.route('/admin/resultado/delete/<int:id>', methods=["POST"])
def delete_resultado(id):
    headers = {'Content-type': 'application/json'}
    dataF = {"idResultado": id}
    
    # Realizar la solicitud POST a la API
    r = requests.post("http://localhost:8078/api/resultado/delete", 
                     data=json.dumps(dataF), 
                     headers=headers)
    
    if r.status_code == 200:
        flash("Resultado eliminado exitosamente", category='info')
    else:
        flash("No se pudo eliminar el resultado", category='error')
    
    return redirect(url_for('router.list_resultados'))












