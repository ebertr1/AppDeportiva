package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.JugadorEquipo;

public class JugadorEquipoDao extends AdapterDao<JugadorEquipo>{
    private JugadorEquipo jugadorEquipo;
<<<<<<< HEAD
    private LinkedList<JugadorEquipo> listAll;

    public JugadorEquipoDao(){
        super(JugadorEquipo.class);
        this.listAll = new LinkedList<>();
=======
    private LinkedList listAll;

    public JugadorEquipoDao(){
        super(JugadorEquipo.class);
>>>>>>> main
    }

    public JugadorEquipo getJugadorEquipo() {
        if (jugadorEquipo == null) {
            jugadorEquipo = new JugadorEquipo();
        }
        return jugadorEquipo;
    }

    public void setJugadorEquipo(JugadorEquipo jugadorEquipo) {
        this.jugadorEquipo = jugadorEquipo;
    }

<<<<<<< HEAD
    public LinkedList<JugadorEquipo> getlistAll() {
        if (listAll.isEmpty()) {
=======
    public LinkedList getListAll() {
        if(listAll == null){
>>>>>>> main
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
<<<<<<< HEAD
        Integer id = getlistAll().getSize() + 1;
        jugadorEquipo.setId(id);
        this.persist(this.jugadorEquipo);
        this.listAll = getlistAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getJugadorEquipo(), getJugadorEquipo().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<JugadorEquipo> list = getlistAll();
        JugadorEquipo jugadorEquipo = get(id);
        if (jugadorEquipo != null) {
            list.remove(jugadorEquipo);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Persona con id " + id + " no encontrada.");
            return false;
        }
=======
        Integer id = getListAll().getSize()+1;
        jugadorEquipo.setId(id);
        this.persist(this.jugadorEquipo);
        this.listAll = listAll();
        return true;
    }


    public Boolean update() throws Exception {
        this.merge(getJugadorEquipo(), getJugadorEquipo().getId()-1);
        this.listAll = listAll();
        return true;
>>>>>>> main
    }
}
