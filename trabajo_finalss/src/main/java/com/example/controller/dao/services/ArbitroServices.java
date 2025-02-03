package com.example.controller.dao.services;

import com.example.controller.dao.ArbitroDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Arbitro;

public class ArbitroServices {
    private ArbitroDao obj;
    
    public ArbitroServices() {
        obj = new ArbitroDao();
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

    public Arbitro getArbitro() {
        return obj.getArbitro();
    }

    public void setArbitro(Arbitro arbitro) {
        obj.setArbitro(arbitro);
    }

    public Arbitro get(Integer id) throws Exception {
        return obj.get(id);
    }
}
