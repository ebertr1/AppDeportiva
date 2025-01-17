package com.example.controller.dao.services;

import com.example.controller.tda.list.LinkedList;
import com.example.models.Campeonato;
import com.example.controller.dao.CampeonatoDao;


public class CampeonatoService {
    private CampeonatoDao obj;

    public CampeonatoService() {
        obj = new CampeonatoDao();
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

    public LinkedList<Campeonato> listAll() {
        return obj.getlistAll();
    }

    public Campeonato getCampeonato() {
        return obj.getCampeonato();
    }

    public void setCampeonato(Campeonato campeonato) {
        obj.setCampeonato(campeonato);
    }

    public Campeonato get(Integer id) throws Exception {
        return obj.get(id);
    }
}
