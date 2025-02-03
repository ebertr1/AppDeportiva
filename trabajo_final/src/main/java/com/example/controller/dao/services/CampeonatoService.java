package com.example.controller.dao.services;

import com.example.controller.tda.list.LinkedList;
import com.example.models.Campeonato;
import com.example.controller.dao.CampeonatoDao;
import com.example.controller.dao.ReglamentoDao;
import com.example.models.Reglamento;

public class CampeonatoService {
    private CampeonatoDao objCampeonatoDao;
    private ReglamentoDao objReglamentoDao;

    public CampeonatoService() {
        objCampeonatoDao = new CampeonatoDao();
        objReglamentoDao = new ReglamentoDao();
    }

    public Boolean save() throws Exception {
        return objCampeonatoDao.save();
    }

    public Boolean update() throws Exception {
        return objCampeonatoDao.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return objCampeonatoDao.delete(id); // Elimina el campeonato
    }

    public LinkedList<Campeonato> listAll() {
        return objCampeonatoDao.getlistAll();  // Devuelve todos los campeonatos
    }

    public Campeonato getCampeonato() {
        return objCampeonatoDao.getCampeonato();  // Obtiene el campeonato actual
    }

    public void setCampeonato(Campeonato campeonato) {
        objCampeonatoDao.setCampeonato(campeonato);  // Establece el campeonato actual
    }

    public Campeonato get(Integer id) throws Exception {
        return objCampeonatoDao.get(id);  // Obtiene un campeonato por ID
    }

    // Método para agregar un reglamento a un campeonato
    public Boolean addReglamentoToCampeonato(Integer campeonatoId, Integer reglamentoId) throws Exception {
        Campeonato campeonato = objCampeonatoDao.get(campeonatoId);  // Obtiene el campeonato
        if (campeonato != null) {
            Reglamento reglamento = objReglamentoDao.get(reglamentoId);  // Obtiene el reglamento
            if (reglamento != null) {
                // Agrega el reglamento al campeonato
                return objCampeonatoDao.addReglamentoToCampeonato(campeonatoId, reglamento);
            }
        }
        return false;  // Si el campeonato o el reglamento no existen, retorna false
    }

    // Método para obtener los reglamentos de un campeonato
    public LinkedList<Reglamento> getReglamentosDeCampeonato(Integer campeonatoId) throws Exception {
        return objCampeonatoDao.getReglamentosDeCampeonato(campeonatoId);  // Devuelve los reglamentos asociados al campeonato
    }
}
