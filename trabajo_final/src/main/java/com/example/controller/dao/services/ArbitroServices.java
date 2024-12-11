package com.example.controller.dao.services;

import com.example.controller.dao.ArbitroDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Arbitro;

public class ArbitroServices {
    private ArbitroDao arbitroDao;
    private Arbitro arbitro;

    public ArbitroServices() {
        this.arbitroDao = new ArbitroDao();
    }

    public Arbitro getArbitro() {
        if (arbitro == null) {
            arbitro = new Arbitro();
        }
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public LinkedList<Arbitro> listAll() {
        return arbitroDao.getListAll();
    }

    public String getTipoIdentificacion(String tipo) {
        return arbitroDao.getTipoIdentificacion();
    }

    public String getTipoGenero(String genero) {
        return arbitroDao.getGenero();
    }

    public Arbitro get(Integer id) throws Exception {
        return arbitroDao.get(id);
    }

    public Boolean save() throws Exception {
        return arbitroDao.save();
    }

    public Boolean update() throws Exception {
        return arbitroDao.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return arbitroDao.delete(id);
    }
}