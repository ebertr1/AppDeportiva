package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Encuentro;

public class EncuentroDao extends AdapterDao<Encuentro>{
    private Encuentro encuentro;
    private LinkedList<Encuentro> listAll;

    public EncuentroDao() {
        super(Encuentro.class);
        this.listAll = new LinkedList<>();
    }

    public Encuentro getEncuentro() {
        if (encuentro == null){
            encuentro = new Encuentro();
        }
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }
    
    public LinkedList<Encuentro> getListAll() {
        if(listAll == null){
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize()+1;
        encuentro.setId(id);
        this.persist(this.encuentro);
        this.listAll = listAll();
        return true;
    }


    public Boolean update() throws Exception {
        try {
            this.merge(getEncuentro(), getEncuentro().getId() - 1);
            this.listAll = getListAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public Boolean delete(Integer id) throws Exception {
        LinkedList<Encuentro> list = getListAll();
        Encuentro encuentro = get(id);
        if (encuentro != null) {
            list.remove(encuentro);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Encuentro con id " + id + " no encontrada.");
            return false;
        }
    }

}
