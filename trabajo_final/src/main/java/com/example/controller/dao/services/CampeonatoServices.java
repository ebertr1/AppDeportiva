package com.example.controller.dao.services;

import com.example.controller.dao.CampeonatoDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Campeonato;
import com.example.models.Equipo;
import com.example.models.enumerador.TipoCategoria;

public class CampeonatoServices {
    private CampeonatoDao obj;

    public CampeonatoServices() {
        obj = new CampeonatoDao();
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

    public TipoCategoria getTipoCategoria(String tipo) {
        return obj.getTipoCategoria(tipo);
    }

    public TipoCategoria[] getTipos() {
        return obj.getTipos();
    }

    public void setCampeonato(Campeonato campeonato){
        obj.setCampeonato(campeonato);
    }

    public Campeonato get(Integer id) throws Exception {
        return obj.get(id);
    }

    public Campeonato getCampeonato() {
        return obj.getCampeonato();
    }
}
