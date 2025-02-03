package com.example.models;
import java.util.Date;

public class Calendario {
    private Integer id;
    private String fechaJornada;
    private Integer nroEncuentros;

    public Calendario() {
    }

    public Calendario(Integer id, String fechaJornada, Integer nroEncuentros) {
        this.id = id;
        this.fechaJornada = fechaJornada;
        this.nroEncuentros = nroEncuentros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaJornada() {
        return fechaJornada;
    }

    public void setFechaJornada(String fechaJornada) {
        this.fechaJornada = fechaJornada;
    }

    public Integer getNroEncuentros() {
        return nroEncuentros;
    }

    public void setNroEncuentros(Integer nroEncuentros) {
        this.nroEncuentros = nroEncuentros;
    }

}
