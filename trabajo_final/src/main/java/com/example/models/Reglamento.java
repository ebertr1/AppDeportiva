package com.example.models;

import com.example.models.enumerador.Formato;

public class Reglamento {
    private Integer id;
    private String nombreReglamento;
    private String descripcion;
    private Formato formato;

    public Reglamento() {
    }

    public Reglamento(Integer id, String nombreReglamento, String descripcion, Formato formato) {
        this.id = id;
        this.nombreReglamento = nombreReglamento;
        this.descripcion = descripcion;
        this.formato = formato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreReglamento() {
        return nombreReglamento;
    }

    public void setNombreReglamento(String nombreReglamento) {
        this.nombreReglamento = nombreReglamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }
    
}
