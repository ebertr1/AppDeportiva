package com.example.controller.dao.services;

import com.example.controller.tda.list.LinkedList;
import com.example.models.Reglamento;
import com.example.controller.dao.ReglamentoDao;
import com.example.controller.dao.CampeonatoDao;
import com.example.models.Campeonato;

public class ReglamentoService {
    private ReglamentoDao objReglamentoDao;
    private CampeonatoDao objCampeonatoDao;

    public ReglamentoService() {
        objReglamentoDao = new ReglamentoDao();
        objCampeonatoDao = new CampeonatoDao();
    }

    public Boolean save() throws Exception {
        return objReglamentoDao.save();  // Guarda el reglamento
    }

    public Boolean update() throws Exception {
        return objReglamentoDao.update();  // Actualiza el reglamento
    }

    public Boolean delete(Integer id) throws Exception {
        return objReglamentoDao.delete(id);  // Elimina el reglamento
    }

    public LinkedList<Reglamento> listAll() {
        return objReglamentoDao.getlistAll();  // Devuelve todos los reglamentos
    }

    public Reglamento getReglamento() {
        return objReglamentoDao.getReglamento();  // Obtiene el reglamento actual
    }

    public void setReglamento(Reglamento reglamento) {
        objReglamentoDao.setReglamento(reglamento);  // Establece el reglamento
    }

    public Reglamento get(Integer id) throws Exception {
        return objReglamentoDao.get(id);  // Obtiene un reglamento por ID
    }

    // Método para asociar un reglamento a un campeonato
    public Boolean associateReglamentoWithCampeonato(Integer reglamentoId, Integer campeonatoId) throws Exception {
        // Primero, obtenemos el campeonato desde el DAO
        Campeonato campeonato = objCampeonatoDao.get(campeonatoId);
        if (campeonato != null) {
            // Si el campeonato existe, asociamos el reglamento
            Reglamento reglamento = objReglamentoDao.get(reglamentoId);
            if (reglamento != null) {
                // Asociamos el reglamento con el campeonato
                return objReglamentoDao.associateWithCampeonato(reglamentoId, campeonatoId);
            }
        }
        return false;
    }

    // Método para obtener los reglamentos de un campeonato
    public LinkedList<Reglamento> getReglamentosDeCampeonato(Integer campeonatoId) throws Exception {
        return objCampeonatoDao.getReglamentosDeCampeonato(campeonatoId);  // Devuelve los reglamentos asociados a un campeonato
    }
}
