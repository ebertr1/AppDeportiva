package com.example.controller.dao.services;

import com.example.controller.dao.EncuentroDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Encuentro;

public class EncuentroServices {
    private EncuentroDao obj;

    public EncuentroServices() {
        obj = new EncuentroDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id);
    }

    public LinkedList listAll() {
        return obj.getListAll();
    }

    public Encuentro getEncuentro() {
        return obj.getEncuentro();
    }

    public void setEncuentro(Encuentro encuentro) {
        obj.setEncuentro(encuentro);
    }

    public Encuentro get(Integer id) throws Exception {
        return obj.get(id);
    }
    
}
