package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Campeonato;

public class CampeonatoDao extends AdapterDao<Campeonato> {

    private Campeonato campeonato;
    private LinkedList<Campeonato> listAll;  

    public CampeonatoDao() {
        super(Campeonato.class);
    }

    public Campeonato getCampeonato() {
        if (campeonato == null) {
            campeonato = new Campeonato();
        }
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public LinkedList<Campeonato> getlistAll() {
        if (listAll == null) { // Inicializa listAll si es null
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        LinkedList<Campeonato> currentList = getlistAll(); // Obtén la lista actual
        Integer id = currentList.getSize() + 1; // Calcula el ID
        campeonato.setId(id); // Establece el ID de la inscripción
        this.persist(this.campeonato); // Persiste la inscripción
        this.listAll = currentList; // Actualiza la lista
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getCampeonato(), getCampeonato().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Campeonato> list = getlistAll();
        Campeonato campeonato = get(id);
        if (campeonato != null) {
            list.remove(campeonato);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Inscripción con id " + id + " no encontrada.");
            return false;
        }
    }
}
