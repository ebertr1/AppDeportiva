package com.example.controller.services;

import com.example.controller.dao.ResultadoDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Resultado;

public class ResultadoServices {
    private ResultadoDao resultadoDao;
    private Resultado resultado;

    public ResultadoServices() {
        this.resultadoDao = new ResultadoDao();
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

    public LinkedList<Resultado> listAll() {
        return resultadoDao.getListAll();
    }

    public Resultado get(Integer id) throws Exception {
        return resultadoDao.get(id);
    }

    public Boolean save() throws Exception {
        return resultadoDao.save();
    }

    public Boolean update() throws Exception {
        return resultadoDao.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return resultadoDao.delete(id);
    }
}