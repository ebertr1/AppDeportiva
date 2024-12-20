package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Infraccion;

<<<<<<< HEAD
public class InfraccionDao extends AdapterDao<Infraccion> {
    private Infraccion infraccion;
    private LinkedList<Infraccion> listAll;
=======

public class InfraccionDao extends AdapterDao<Infraccion> {
 
    
    private Infraccion infraccion;
    private LinkedList listAll;  
>>>>>>> main

    public InfraccionDao() {
        super(Infraccion.class);
    }

    public Infraccion getInfraccion() {
        if (infraccion == null) {
            infraccion = new Infraccion();
        }
        return infraccion;
    }

    public void setInfraccion(Infraccion infraccion) {
        this.infraccion = infraccion;
    }

<<<<<<< HEAD
    public LinkedList<Infraccion> getListAll() {
        if (listAll == null) {
=======
    public LinkedList<Infraccion> getlistAll() {
        if (listAll.isEmpty()) {
>>>>>>> main
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
<<<<<<< HEAD
        Integer id = getListAll().getSize() + 1;
        infraccion.setId(id);
        this.persist(this.infraccion);
        this.listAll = listAll();
=======
        Integer id = getlistAll().getSize() + 1;
        infraccion.setId(id);
        this.persist(this.infraccion);
        this.listAll = getlistAll();
>>>>>>> main
        return true;
    }

    public Boolean update() throws Exception {
<<<<<<< HEAD
        this.merge(getInfraccion(), getInfraccion().getId() - 1);
        this.listAll = listAll();
        return true;
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Infraccion> list = getListAll();
=======
        try {
            this.merge(getInfraccion(), getInfraccion().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Infraccion> list = getlistAll();
>>>>>>> main
        Infraccion infraccion = get(id);
        if (infraccion != null) {
            list.remove(infraccion);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
<<<<<<< HEAD
            System.out.println("Infraccion con id " + id + " no encontrada.");
=======
            System.out.println("Persona con id " + id + " no encontrada.");
>>>>>>> main
            return false;
        }
    }

<<<<<<< HEAD
    public LinkedList<Infraccion> ordenarPorNumTarjeta(boolean ascendente) throws Exception {
        LinkedList<Infraccion> infracciones = getListAll();
        infracciones.quicksort("numTarjeta", ascendente ? 1 : -1);
        return infracciones;
    }

    public LinkedList<Infraccion> ordenarPorIdentificacionJugador(boolean ascendente) throws Exception {
        LinkedList<Infraccion> infracciones = getListAll();
        infracciones.quicksort("identificacionJugador", ascendente ? 1 : -1);
        return infracciones;
    }

    public LinkedList<Infraccion> ordenarPorColorTarjeta(boolean ascendente) throws Exception {
        LinkedList<Infraccion> infracciones = getListAll();
        infracciones.quicksort("colorTarjeta", ascendente ? 1 : -1);
        return infracciones;
    }

    public LinkedList<Infraccion> buscarPorNumTarjeta(Integer numTarjeta) {
        LinkedList<Infraccion> resultados = new LinkedList<>();
        for (Infraccion infraccion : getListAll().toArray()) {
            if (infraccion.getNumTarjeta().equals(numTarjeta)) {
                resultados.add(infraccion);
            }
        }
        return resultados;
    }

    public LinkedList<Infraccion> buscarPorIdentificacionJugador(String identificacionJugador) {
        LinkedList<Infraccion> resultados = new LinkedList<>();
        for (Infraccion infraccion : getListAll().toArray()) {
            if (infraccion.getIdentificacionJugador().equalsIgnoreCase(identificacionJugador)) {
                resultados.add(infraccion);
            }
        }
        return resultados;
    }

    public LinkedList<Infraccion> buscarPorColorTarjeta(String colorTarjeta) {
        LinkedList<Infraccion> resultados = new LinkedList<>();
        for (Infraccion infraccion : getListAll().toArray()) {
            if (infraccion.getColorTarjeta().toString().equalsIgnoreCase(colorTarjeta)) {
                resultados.add(infraccion);
            }
        }
        return resultados;
    }


}
=======



}
>>>>>>> main
