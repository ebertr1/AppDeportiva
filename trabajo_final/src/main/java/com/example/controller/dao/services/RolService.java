package com.example.controller.dao.services;

import com.example.controller.dao.RolDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Rol;

public class RolService {

    private RolDao rolDao;

    public RolService(){
        rolDao = new RolDao();
    }
    public Boolean save() throws Exception{
        return rolDao.save();
    }
    public Boolean update() throws Exception{
        return rolDao.update();
    }
    public Boolean delete(Integer id) throws Exception {
        try {
        	rolDao.delete(id);
        	return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
    }


    public LinkedList listAll(){
        return rolDao.getListAll();

    }

    public Rol getRol(){
        return rolDao.getRol();
    }

    public void setRol( Rol rol){
        rolDao.setRol(rol);
    }

    public Rol get(Integer id) throws Exception {
        return rolDao.get(id);
    }

}
