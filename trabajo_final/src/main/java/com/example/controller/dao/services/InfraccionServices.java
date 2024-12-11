package com.example.controller.dao.services;

import com.example.controller.dao.InfraccionDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Infraccion;

public class InfraccionServices {
    private InfraccionDao infraccionDao;
    private Infraccion infraccion;

    public InfraccionServices() {
        this.infraccionDao = new InfraccionDao();
    }

    public Infraccion getInfraccion() {
        if (infraccion == null) {
            infraccion = new Infraccion();
        }
        return infraccion;
    }

    public void setInfraccion(Infraccion infraccion) {
        this.infraccion = infraccion;
    }

    public LinkedList<Infraccion> listAll() {
        return infraccionDao.getListAll();
    }

    public Infraccion get(Integer id) throws Exception {
        return infraccionDao.get(id);
    }

    public Boolean save() throws Exception {
        return infraccionDao.save();
    }

    public Boolean update() throws Exception {
        return infraccionDao.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return infraccionDao.delete(id);
    }
}