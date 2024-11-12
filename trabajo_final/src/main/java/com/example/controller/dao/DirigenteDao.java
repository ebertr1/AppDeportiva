package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Dirigente;

public class DirigenteDao extends AdapterDao<Dirigente> {
    private Dirigente dirigente;
    private LinkedList listAll;

    public DirigenteDao() {
        super(Dirigente.class);
    }

    public Dirigente getDirigente() {
        if (dirigente == null) {
            dirigente = new Dirigente();
        }
        return dirigente;
    }

    public void setDirigente(Dirigente dirigente) {
        this.dirigente = dirigente;
    }

    public LinkedList<Dirigente> getlistAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        dirigente.setId(id);
        this.persist(this.dirigente);
        this.listAll = getlistAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getDirigente(), getDirigente().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Dirigente> list = getlistAll();
        Dirigente dirigente = get(id);
        if (dirigente != null) {
            list.remove(dirigente);
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
