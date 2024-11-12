package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Jugador;

public class JugadorDao extends AdapterDao<Jugador>{
    private Jugador jugador;
    private LinkedList listAll;

    public JugadorDao() {
        super(Jugador.class);
    }

    public Jugador getJugador() {
        if (jugador == null){
            jugador = new Jugador();
        }
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public LinkedList<Jugador> getlistAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        jugador.setId(id);
        this.persist(this.jugador);
        this.listAll = getlistAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getJugador(), getJugador().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Jugador> list = getlistAll();
        Jugador jugador = get(id);
        if (jugador != null) {
            list.remove(jugador);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Persona con id " + id + " no encontrada.");
            return false;
        }
    }

}
