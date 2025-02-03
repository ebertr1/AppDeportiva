package com.example.controller.dao.services;

import com.example.controller.tda.list.LinkedList;
import com.example.models.Calendario;

import com.example.controller.dao.CalendarioDao;


public class CalendarioService {
    private CalendarioDao obj;

    public CalendarioService() {
        obj = new CalendarioDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id); // Llamar al método delete de PersonaDao
    }

    public LinkedList<Calendario> listAll() {
        return obj.getlistAll();
    }

    public Calendario getCalendario() {
        return obj.getCalendario();
    }

    public void setCalendario(Calendario calendario) {
        obj.setCalendario(calendario);
    }

    public Calendario get(Integer id) throws Exception {
        return obj.get(id);
    }
}
