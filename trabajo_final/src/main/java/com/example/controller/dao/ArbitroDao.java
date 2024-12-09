package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Arbitro;



public class ArbitroDao extends AdapterDao<Arbitro> {
   
    private Arbitro arbitro;
    private LinkedList listAll;    
     
   public ArbitroDao() {
        super(Arbitro.class);
    }

    public Arbitro getArbitro() {
        if (arbitro == null) {
            arbitro = new Arbitro();
        }
        return arbitro;
    }

    public void setArbitro(Arbitro Arbitro) {
        this.arbitro = arbitro;
    }

    public LinkedList<Arbitro> getlistAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        arbitro.setId(id);
        this.persist(this.arbitro);
        this.listAll = getlistAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getArbitro(), getArbitro().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Arbitro> list = getlistAll();
        Arbitro arbitro = get(id);
        if (arbitro != null) {
            list.remove(arbitro);
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
