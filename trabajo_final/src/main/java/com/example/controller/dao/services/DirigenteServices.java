package com.example.controller.dao.services;

import java.util.Date;
import java.util.HashMap;

import com.example.controller.dao.DirigenteDao;
import com.example.controller.tda.list.LinkedList;
import com.example.models.Dirigente;
import com.example.models.Equipo;
import com.example.models.enumerador.Genero;
import com.example.models.enumerador.TipoIdentificacion;

public class DirigenteServices {
    private DirigenteDao obj;

        public Object[] listShowAll() throws Exception {
        if(!obj.getlistAll().isEmpty()) {
            Dirigente[] lista = (Dirigente[]) obj.getlistAll().toArray();
            Object[] respuesta = new Object[lista.length];
            for(int i = 0; i < lista.length; i++) {
                Equipo e = new EquipoServices().get(lista[i].getIdEquipo());
                HashMap mapa = new HashMap<>();
                mapa.put("id", lista[i].getId());
                mapa.put("nombre", lista[i].getNombre());
                mapa.put("apellido", lista[i].getApellido());
                mapa.put("tipo", lista[i].getTipo());
                mapa.put("identificacion", lista[i].getIdentificacion());
                mapa.put("fechaNacimiento", lista[i].getFechaNacimiento());
                mapa.put("celular", lista[i].getCelular());
                mapa.put("genero", lista[i].getGenero());
                mapa.put("activo", lista[i].getisActivo());
                mapa.put("equipo", e);
                respuesta[i] = mapa;
            }
            return respuesta;
        }
        return new Object[]{};
    }

    public DirigenteServices() {
        obj = new DirigenteDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.deleteDirigente(id);
    }

    public LinkedList listAll() {
        return obj.getlistAll();
    }

    public Dirigente getDirigente() {
        return obj.getDirigente();
    }

    public void setDirigente(Dirigente dirigente) {
        obj.setDirigente(dirigente);
    }

    public Dirigente get(Integer id) throws Exception {
        return obj.get(id);
    }

    public TipoIdentificacion getTipoIdentificacion(String tipo) {
        return obj.getTipoIdentificacion(tipo);
    }

    public TipoIdentificacion[] getTipos() {
        return obj.getTipos();
    }

    public Genero getTipoGenero(String genero) {
        return obj.getTipoGenero(genero);
    }

    public Genero[] getGenero() {
        return obj.getGenero();
    }
}
