package com.example.controller.dao.services;

import com.example.controller.dao.EncuentroDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Encuentro;

public class EncuentroServices {

    private EncuentroDao encuentroDao;
    private Encuentro encuentro;

    public EncuentroServices() {
        this.encuentroDao = new EncuentroDao();
    }

    public Encuentro getEncuentro() {
        if (encuentro == null) {
            encuentro = new Encuentro();
        }
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public LinkedList<Encuentro> listAll() {
        return encuentroDao.getListAll();
    }

    public Encuentro get(Integer id) throws Exception {
        return encuentroDao.get(id);
    }

    public Boolean save() throws Exception {
        return encuentroDao.save();
    }

    public Boolean update() throws Exception {
        return encuentroDao.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return encuentroDao.delete(id);
    }
}