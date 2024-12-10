package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Reglamento;
import com.example.models.enumerador.Formato;

public class ReglamentoDao extends AdapterDao<Reglamento>{
    private Reglamento reglamento;
    private LinkedList<Reglamento> listAll;

    public ReglamentoDao() {
        super(Reglamento.class);
        this.listAll = new LinkedList<>();

    }

    public Reglamento getReglamento() {
        if (reglamento == null){
            reglamento = new Reglamento();
        }
        return reglamento;
    }

    public void setReglamento(Reglamento reglamento) {
        this.reglamento = reglamento;
    }
    
    public LinkedList<Reglamento> getListAll() {
        if(listAll == null){
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        reglamento.setId(id);
        this.persist(this.reglamento);
        this.listAll = getListAll();
        return true;
    }


    public Boolean update() throws Exception {
        try {
            this.merge(getReglamento(), getReglamento().getId() - 1);
            this.listAll = getListAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Reglamento> list = getListAll();
        Reglamento reglamento = get(id);
        if (reglamento != null) {
            list.remove(reglamento);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Reglamento con id " + id + " no encontrada.");
            return false;
        }
    }

    public Formato getTipoFormato(String formato) {
        return Formato.valueOf(formato);
    }

    public Formato[] getTipoFormato() {
        return Formato.values();
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> origin/rama_Isauro
