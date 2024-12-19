package com.example.controller.dao.services;


import com.example.controller.dao.UsuarioDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Administrador;
import com.example.models.Usuario;

public class UsuarioService {
    
    private UsuarioDao userDao;

    public UsuarioService(){
        userDao = new UsuarioDao();
    }
    public Boolean save() throws Exception{
        return userDao.save();
    }
    public Boolean update() throws Exception{
        return userDao.update();
    }
    public Boolean delete(Integer id) throws Exception {
        return userDao.delete(id); 
    }
    

    public LinkedList listAll(){
        return userDao.getListAll();

    }

    public Usuario getUsuario(){
        return userDao.getUsuario();
    }

    public void setUsuario( Usuario user){
        userDao.setUsuario(user);
    }

    public Usuario get(Integer id) throws Exception {
        return userDao.get(id);
    }
    
    public Usuario findUserbyEmail(String email) throws Exception{
    	return userDao.getUsuariobyEmail(email);
    }
    
    public Administrador findPersonabyEmail(String text_email) throws Exception{
    	return userDao.getPersonabyEmail(text_email);
    }
    
    public void asignarUsuario(int persona) throws Exception{
    	userDao.asignarUsuario(persona);
    }

}
