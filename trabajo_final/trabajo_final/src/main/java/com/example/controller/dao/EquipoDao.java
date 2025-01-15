package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Equipo;

public class EquipoDao extends AdapterDao<Equipo> {
    private Equipo equipo;
    private LinkedList<Equipo> listAll;

    public EquipoDao() {
        super(Equipo.class);
        this.listAll = new LinkedList<>();
    }

    public Equipo getEquipo() {
        if (equipo == null) {
            equipo = new Equipo();
        }
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public LinkedList<Equipo> getlistAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        equipo.setId(id);
        this.persist(this.equipo);
        this.listAll = getlistAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getEquipo(), getEquipo().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	public Boolean deleteEquipo(Integer id) throws Exception {
    	try {
			this.delete(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
    }
}
