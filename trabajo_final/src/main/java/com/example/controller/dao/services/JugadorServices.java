package com.example.controller.dao.services;

import com.example.controller.dao.JugadorDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Jugador;

public class JugadorServices {
    private JugadorDao obj;

    public JugadorServices() {
        obj = new JugadorDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList listAll() {
        return obj.getListAll();
    }

    public Jugador getJugador() {
        return obj.getJugador();
    }

    public void setJugador(Jugador jugador) {
        obj.setJugador(jugador);
    }
}
