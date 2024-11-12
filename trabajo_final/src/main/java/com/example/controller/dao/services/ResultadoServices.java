package com.example.controller.dao.services;

import com.example.controller.dao.ResultadoDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Resultado;

public class ResultadoServices {
    private ResultadoDao obj;

    public ResultadoServices() {
        obj = new ResultadoDao();
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

    public Resultado getResultado() {
        return obj.getResultado();
    }

    public void setResultado(Resultado resultado) {
        obj.setResultado(resultado);
    }
}
