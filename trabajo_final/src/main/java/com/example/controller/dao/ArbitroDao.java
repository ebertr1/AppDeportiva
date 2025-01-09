package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Arbitro;



public class ArbitroDao extends AdapterDao<Arbitro> {

    private Arbitro arbitro;
    private LinkedList listAll;

   public ArbitroDao() {
        super(Arbitro.class);
    }

    public Arbitro getArbitro() {
        if (arbitro == null) {
            arbitro = new Arbitro();
        }
        return arbitro;
    }

    public void setArbitro(Arbitro Arbitro) {
        this.arbitro = arbitro;
    }

    public LinkedList<Arbitro> getlistAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        arbitro.setId(id);
        this.persist(this.arbitro);
        this.listAll = getlistAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getArbitro(), getArbitro().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	public boolean deleteArbitr(Integer id) throws Exception {
		try {
			this.delete(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
    }




}
