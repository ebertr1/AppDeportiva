package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Administrador;

public class AdministradorDao extends AdapterDao<Administrador> {

	private Administrador administrador;
	private LinkedList listAll;

	public AdministradorDao() {
		super(Administrador.class);
	}

	public Administrador getAdministrador() {
		if (administrador == null) {
			administrador = new Administrador();
		}
		return administrador;
	}

	public void setAdministrador(Administrador Arbitro) {
		this.administrador = administrador;
	}

	public LinkedList<Administrador> getlistAll() {
		if (listAll.isEmpty()) {
			this.listAll = listAll();
		}
		return listAll;
	}

	public Boolean save() throws Exception {
		Integer id = getlistAll().getSize() + 1;
		administrador.setId(id);
		this.persist(this.administrador);
		this.listAll = getlistAll();
		return true;
	}

	public Boolean update() throws Exception {
		try {
			this.merge(getAdministrador(), getAdministrador().getId() - 1);
			this.listAll = getlistAll();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean delete(Integer id) throws Exception {
		LinkedList<Administrador> list = getlistAll();
		Administrador arbitro = get(id);
		if (arbitro != null) {
			list.remove(arbitro);
			String info = g.toJson(list.toArray());
			saveFile(info);
			this.listAll = list;
			return true;
		} else {
			System.out.println("Persona con id " + id + " no encontrada.");
			return false;
		}
	}

	// Metodo que devuelva el administrador al buscar por correo
}