package com.example.controller.dao;

import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Resultado;

public class ResultadoDao extends AdapterDao<Resultado>{
    private Resultado resultado;
    
    private LinkedList listAll;
    
    public ResultadoDao(){
        super(Resultado.class);
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

    public LinkedList getListAll() {
        if(listAll == null){
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
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
    }
}
