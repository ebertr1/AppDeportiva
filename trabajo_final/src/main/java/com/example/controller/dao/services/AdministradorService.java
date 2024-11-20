package com.example.controller.dao.services;

import com.example.controller.dao.AdministradorDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Administrador;

public class AdministradorService {
	private AdministradorDao obj;
    
    public AdministradorService() {
        obj = new AdministradorDao();
    }

    public Boolean save() throws Exception{
        return obj.save();
    }
    
    public Boolean update() throws Exception{
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id);
    }
    
    public LinkedList listAll(){
        return obj.getlistAll();
    }

    public Administrador getAdministrador() {
        return obj.getAdministrador();
    }

    public void setAdministrador(Administrador administrador) {
        obj.setAdministrador(administrador);
    }

    public Administrador get(Integer id) throws Exception {
        return obj.get(id);
    }
}
