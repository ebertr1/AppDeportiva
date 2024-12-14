package com.example.controller.dao;

<<<<<<< HEAD
import  com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Campeonato;

public class CampeonatoDao extends AdapterDao<Campeonato>{
=======
import com.example.controller.dao.implement.AdapterDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Campeonato;
import com.example.models.enumerador.TipoCategoria;

public class CampeonatoDao extends AdapterDao<Campeonato> {
>>>>>>> main
    private Campeonato campeonato;
    private LinkedList listAll;

    public CampeonatoDao() {
        super(Campeonato.class);
    }

    public Campeonato getCampeonato() {
<<<<<<< HEAD
        if (campeonato == null){
=======
        if (campeonato == null) {
>>>>>>> main
            campeonato = new Campeonato();
        }
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
<<<<<<< HEAD
    
    public LinkedList getListAll() {
        if(listAll == null){
=======

    public LinkedList getListAll() {
        if (listAll == null) {
>>>>>>> main
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
<<<<<<< HEAD
        Integer id = getListAll().getSize()+1;
=======
        Integer id = getListAll().getSize() + 1;
>>>>>>> main
        campeonato.setId(id);
        this.persist(this.campeonato);
        this.listAll = listAll();
        return true;
    }

<<<<<<< HEAD

    public Boolean update() throws Exception {
        this.merge(getCampeonato(), getCampeonato().getId()-1);
        this.listAll = listAll();
        return true;
    }
=======
    public Boolean update() throws Exception {
        this.merge(getCampeonato(), getCampeonato().getId() - 1);
        this.listAll = listAll();
        return true;
    }

    public TipoCategoria getTipoCategoria(String tipo) {
        return TipoCategoria.valueOf(tipo);
    }

    public TipoCategoria[] getTipos() {
        return TipoCategoria.values();
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Campeonato> list = getListAll();
        Campeonato campeonato = get(id);
        if (campeonato != null) {
            list.remove(campeonato);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            return false;
        }
    }
>>>>>>> main
}
