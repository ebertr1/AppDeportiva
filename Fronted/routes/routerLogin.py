from flask import Flask, json, flash,Blueprint, url_for, jsonify, make_response, request, render_template, redirect, abort
import requests
routerLogin = Blueprint('routerLogin', __name__)

#Login 
@routerLogin.route('/index')
def login():
    return render_template('fragmento/inicial/login.html')


@routerLogin.route('/admin/dirigente/register')
def view_register_dirigente():
    r = requests.get("http://localhost:8078/myapp/dirigente/listType")
    r2 = requests.get("http://localhost:8078/myapp/dirigente/listTypeGenero")
    data = r.json()
    data2 = r2.json()
    print(r.json())
    return render_template('fragmento/dirigente/registroDirigente.html', lista = data["data"], lista2 = data2["data"])

    #guardar dirigente
@routerLogin.route('/admin/dirigente/save', methods=["POST"])
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
@routerLogin.route('/admin/dirigente/edit/<int:id>')
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
@routerLogin.route('/admin/dirigente/update', methods=["POST"])
def update_dirigente():
    headers = {'Content-type': 'application/json'}
    form = request.form
    dataF = {
    "id": form["id"],   
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
@routerLogin.route('/admin/dirigente/delete/<int:id>', methods=["POST"])
def delete_dirigente(id):
    # Realiza una solicitud DELETE a la API
    r = requests.delete(f"http://localhost:8078/myapp/dirigente/delete/{id}")
    
    # Verifica la respuesta de la API
    if r.status_code == 200:
        flash("Cliente eliminado exitosamente.", category='info')
    else:
        flash("No se pudo eliminar el cliente.", category='error')
    
    return redirect(url_for('routerLogin.list'))