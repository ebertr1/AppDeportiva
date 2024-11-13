package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Resultado;

public class ResultadoDao extends AdapterDao<Resultado>{
    private Resultado resultado;
<<<<<<< HEAD
    private LinkedList<Resultado> listAll;
    
    public ResultadoDao(){
        super(Resultado.class);
        this.listAll = new LinkedList<>();
=======
    
    private LinkedList listAll;
    
    public ResultadoDao(){
        super(Resultado.class);
>>>>>>> main
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

<<<<<<< HEAD
    public LinkedList<Resultado> getlistAll() {
        if (listAll.isEmpty()) {
=======
    public LinkedList getListAll() {
        if(listAll == null){
>>>>>>> main
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
<<<<<<< HEAD
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

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Resultado> list = getlistAll();
        Resultado resultado = get(id);
        if (resultado != null) {
            list.remove(resultado);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Persona con id " + id + " no encontrada.");
            return false;
        }
=======
        Integer id = getListAll().getSize()+1;
        resultado.setId(id);
        this.persist(this.resultado);
        this.listAll = listAll();
        return true;
    }


    public Boolean update() throws Exception {
        this.merge(getResultado(), getResultado().getId()-1);
        this.listAll = listAll();
        return true;
>>>>>>> main
    }
}
