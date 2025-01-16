package com.example.controller.dao.services;

import com.example.controller.tda.list.LinkedList;
import com.example.models.Reglamento;
import com.example.controller.dao.ReglamentoDao;


public class ReglamentoService {
    private ReglamentoDao obj;

    public ReglamentoService() {
        obj = new ReglamentoDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id); // Llamar al método delete de PersonaDao
    }

    public LinkedList<Reglamento> listAll() {
        return obj.getlistAll();
    }

    public Reglamento getReglamento() {
        return obj.getReglamento();
    }

    public void setReglamento(Reglamento reglamento) {
        obj.setReglamento(reglamento);
    }

    public Reglamento get(Integer id) throws Exception {
        return obj.get(id);
    }
}
