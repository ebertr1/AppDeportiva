package com.example.models;
import java.util.Date;

import com.example.models.enumerador.TipoCategoria;

public class Campeonato {
    private Integer id;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private TipoCategoria categoria;

    public Campeonato() {
    }

    public Campeonato(Integer id, String nombre, String fechaInicio, String fechaFin, TipoCategoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public TipoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(TipoCategoria categoria) {
        this.categoria = categoria;
    }
}
