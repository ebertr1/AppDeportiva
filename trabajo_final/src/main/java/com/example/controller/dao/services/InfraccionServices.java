package com.example.controller.dao.services;

import com.example.controller.dao.InfraccionDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Infraccion;

public class InfraccionServices {
<<<<<<< HEAD
    private InfraccionDao infraccionDao;
    private Infraccion infraccion;

    public InfraccionServices() {
        this.infraccionDao = new InfraccionDao();
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

    public LinkedList<Infraccion> listAll() {
        return infraccionDao.getListAll();
    }

    public Infraccion get(Integer id) throws Exception {
        return infraccionDao.get(id);
    }

    public Boolean save() throws Exception {
        return infraccionDao.save();
    }

    public Boolean update() throws Exception {
        return infraccionDao.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return infraccionDao.delete(id);
    }

    public LinkedList<Infraccion> ordenarPorNumTarjeta(boolean ascendente) throws Exception {
        return infraccionDao.ordenarPorNumTarjeta(ascendente);
    }

    public LinkedList<Infraccion> ordenarPorIdentificacionJugador(boolean ascendente) throws Exception {
        return infraccionDao.ordenarPorIdentificacionJugador(ascendente);
    }

    
    public LinkedList<Infraccion> ordenarPorColorTarjeta(boolean ascendente) throws Exception {
        return infraccionDao.ordenarPorColorTarjeta(ascendente);
    }

    public LinkedList<Infraccion> buscarPorNumTarjeta(Integer numTarjeta) {
        return infraccionDao.buscarPorNumTarjeta(numTarjeta);
    }

    public LinkedList<Infraccion> buscarPorIdentificacionJugador(String identificacionJugador) {
        return infraccionDao.buscarPorIdentificacionJugador(identificacionJugador);
    }

    public LinkedList<Infraccion> buscarPorColorTarjeta(String colorTarjeta) {
        return infraccionDao.buscarPorColorTarjeta(colorTarjeta);
=======
    
    private InfraccionDao obj;

    public InfraccionServices() {
        obj = new InfraccionDao();
    }

    public Boolean save() throws Exception{
        return obj.save();
    }
    
    public Boolean update() throws Exception{
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id);
    }
    
    public LinkedList listAll(){
        return obj.getlistAll();
    }

    public Infraccion getInfraccion() {
        return obj.getInfraccion();
    }

    public void setInfraccion(Infraccion infraccion) {
        obj.setInfraccion(infraccion);
    }

    public Infraccion get(Integer id) throws Exception {
        return obj.get(id);
>>>>>>> main
    }



<<<<<<< HEAD




}
=======
}
>>>>>>> main
