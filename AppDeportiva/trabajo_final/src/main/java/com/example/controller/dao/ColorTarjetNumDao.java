package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.enumerador.ColorTarjeta;


public class ColorTarjetNumDao extends AdapterDao<ColorTarjeta>{

    private ColorTarjeta colorTarjeta;
    private LinkedList<ColorTarjeta> listAll;
    // private LinkedList<Persona> listAll;

    public ColorTarjetNumDao() {
    super(ColorTarjeta.class);
        this.listAll = new LinkedList<>();
    }

    public ColorTarjeta getColorTarjeta() {
        if (colorTarjeta == null) {
           colorTarjeta = ColorTarjeta.AMARILLO;
        }
        return colorTarjeta;
    }


    public LinkedList<ColorTarjeta> getlistAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public ColorTarjeta getColorTarjeta(String name) {
        return ColorTarjeta.valueOf(name);
    }

    public ColorTarjeta[] getTipos() {
        return ColorTarjeta.values();
    }



    public Boolean update() throws Exception {
        try {
            this.merge(getColorTarjeta(), getColorTarjeta().ordinal());
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteColorTarjeta(Integer id) throws Exception {
        try {
			this.delete(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
    }


}
