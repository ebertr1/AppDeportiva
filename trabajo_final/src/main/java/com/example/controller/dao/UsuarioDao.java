package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Persona;
import com.example.models.Rol;
import com.example.models.Usuario;

public class UsuarioDao extends AdapterDao<Usuario> {
     // Atributos
    private Usuario user;
    private LinkedList listUsr;

    public UsuarioDao(){
        super(Usuario.class);
    }

    public Usuario getUsuario(){
        if(user == null){
            user = new Usuario();
        }
        return user;
    }

    public void setUsuario(Usuario r){
        this.user = r;
    }

    public LinkedList getListAll() {
        if(listUsr == null){
            this.listUsr = listAll();
        }
        return listUsr;
    }

    // CRUD
    public Boolean save() throws Exception {
        Integer id = getListAll().getSize()+1;
        user.setId(id);
        this.persist(this.user);
        this.listUsr = listAll();
        return true;
    }


    public Boolean update() throws Exception {
        this.merge(getUsuario(), getUsuario().getId()-1);
        this.listUsr = listAll();
        return true;
    }

    public Boolean delete(int id) throws Exception{
        LinkedList<Usuario> list = getListAll(); 
        Usuario persona = get(id); 
        if (persona != null) {
            list.delete(id); 
            // String info = g.toJson(list.toArray());
            // saveFile(info); 
            this.listUsr = getListAll();
            return true;
        } else {
            System.out.println("Usuario con id " + id + " no encontrada.");
            return false;
        }
    }
<<<<<<< HEAD
    
    // Metodo que me permite hasear contrasenia
    private String hashPasswd(String pwd) {
    	
    	String salt_pwd = BCrypt.gensalt(5); // genSalt -> establece el nivel de seguridad, entre mas grande el numero, mas seguro mas lento de procesar
    	return BCrypt.hashpw(pwd, salt_pwd); // Devuelve el hash
    }
    
    // Metodo que me permite verificar si dos contrasenias son iguales
    // Necesitaremos la contrasenia que envia el user, y la contrasenia almacenada en bdd para comparar
    public boolean verifyPwd(String pwd_usr, String pwd_hash_usr) {    	
    	return BCrypt.checkpw(pwd_usr, pwd_hash_usr);
    }
    
    public Usuario getUsuariobyEmail(String email) throws Exception{
    	// Metodos de ordenacion 
    	// Metodo de Busqueda
    	Usuario persona = null;
    	LinkedList listita = listAll();
    	if(!listAll().isEmpty()) {
    		Usuario[] aux = (Usuario[]) listita.toArray();
    		
    		for (int i = 0; i < aux.length; i++) {
    			// Si el apellido empieza con las letras del texto que tiene como parametro
				if (aux[i].getCorreo().equals(email)) {
					persona = aux[i];
				}
			}
    	}
    	
    	return persona;
    }
    
    public Administrador getPersonabyEmail(String email) throws Exception{
    	Administrador person = null;
    	LinkedList listPersona = personaDao.getlistAll();
    	
    	if(!personaDao.getlistAll().isEmpty()) {
    		Administrador[] aux = (Administrador[]) listPersona.toArray();
    		
    		for (int i = 0; i < aux.length; i++) {
    			// Si el apellido empieza con las letras del texto que tiene como parametro
				if (aux[i].getEmail().equals(email)) {
					person = aux[i];
					break;
				}
			}
    	}
    	
    	return person;
    }
    
=======
>>>>>>> main
}
