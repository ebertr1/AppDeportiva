package com.example.controller;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Resultado;

public class ResultadoDao extends AdapterDao<Resultado> {
    private Resultado resultado;
    private LinkedList<Resultado> listAll;

    public ResultadoDao() {
        super(Resultado.class);
    }

    public Resultado getResultado() {
        if (resultado == null) {
            resultado = new Resultado();
        }
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public LinkedList<Resultado> getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        resultado.setId(id);
        this.persist(this.resultado);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {
        this.merge(getResultado(), getResultado().getId() - 1);
        this.listAll = listAll();
        return true;
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Resultado> list = getListAll();
        Resultado resultado = get(id);
        if (resultado != null) {
            list.remove(resultado);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Resultado con id " + id + " no encontrado.");
            return false;
        }
    }
}