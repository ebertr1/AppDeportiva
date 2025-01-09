package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Resultado;

public class ResultadoDao extends AdapterDao<Resultado>{
    private Resultado resultado;
    private LinkedList<Resultado> listAll;

    public ResultadoDao(){
        super(Resultado.class);
        this.listAll = new LinkedList<>();
    }

    public Resultado getResultado() {
        if (resultado == null) {
            resultado = new Resultado();
        }
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public LinkedList<Resultado> getlistAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getlistAll().getSize() + 1;
        resultado.setId(id);
        this.persist(this.resultado);
        this.listAll = getlistAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getResultado(), getResultado().getId() - 1);
            this.listAll = getlistAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	public Boolean deleteResultad(Integer id) throws Exception {
//        LinkedList<Resultado> list = getlistAll();
//        Resultado resultado = get(id);
//        if (resultado != null) {
//            list.remove(resultado);
//            String info = g.toJson(list.toArray());
//            saveFile(info);
//            this.listAll = list;
//            return true;
//        } else {
//            System.out.println("Persona con id " + id + " no encontrada.");
//            return false;
//        }
		try {
			this.delete(id);
			this.getlistAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
    }
}
