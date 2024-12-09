package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Calendario;

public class CalendarioDao extends AdapterDao<Calendario>{
    private Calendario calendario;
    private LinkedList<Calendario> listAll;

    public CalendarioDao() {
        super(Calendario.class);
        this.listAll = new LinkedList<>();

    }

    public Calendario getCalendario() {
        if (calendario == null){
            calendario = new Calendario();
        }
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }
    
    public LinkedList<Calendario> getListAll() {
        if(listAll == null){
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        calendario.setId(id);
        this.persist(this.calendario);
        this.listAll = getListAll();
        return true;
    }


    public Boolean update() throws Exception {
        try {
            this.merge(getCalendario(), getCalendario().getId() - 1);
            this.listAll = getListAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Calendario> list = getListAll();
        Calendario calendario = get(id);
        if (calendario != null) {
            list.remove(calendario);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Calendario con id " + id + " no encontrada.");
            return false;
        }
    }
}