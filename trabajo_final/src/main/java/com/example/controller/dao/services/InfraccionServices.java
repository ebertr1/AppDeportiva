package com.example.controller.dao.services;

import com.example.controller.dao.InfraccionDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Infraccion;

public class InfraccionServices {
    
    private InfraccionDao obj;

    public InfraccionServices() {
        obj = new InfraccionDao();
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

    public Infraccion getInfraccion() {
        return obj.getInfraccion();
    }

    public void setInfraccion(Infraccion infraccion) {
        obj.setInfraccion(infraccion);
    }

    public Infraccion get(Integer id) throws Exception {
        return obj.get(id);
    }



}
