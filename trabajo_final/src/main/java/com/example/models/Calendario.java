package com.example.models;
import java.util.Date;

public class Calendario {
    private Integer id;
    private Date fechaJornada;
    private Integer nroEncuentros;
    private Integer id_Campeonato;

    public Calendario() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(Date fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    public Integer getNroEncuentros() {
        return nroEncuentros;
    }

    public void setNroEncuentros(Integer nroEncuentros) {
        this.nroEncuentros = nroEncuentros;
    }

    public Integer getId_Campeonato(){
        return id_Campeonato;
    }

    public void setId_Campeonato(Integer id_Campeonato){
        this.id_Campeonato = id_Campeonato;
    }

}
