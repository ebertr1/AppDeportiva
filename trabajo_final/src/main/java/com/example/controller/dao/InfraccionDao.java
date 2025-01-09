package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Infraccion;


public class InfraccionDao extends AdapterDao<Infraccion> {


    private Infraccion infraccion;
    private LinkedList listAll;

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

    public LinkedList<Infraccion> getlistAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        infraccion.setId(id);
        this.persist(this.infraccion);
        this.listAll = getlistAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getInfraccion(), getInfraccion().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	public Boolean deleteInfraccion(Integer id) throws Exception {
    	try {
			this.delete(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
    }




}
