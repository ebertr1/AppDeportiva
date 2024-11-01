package com.example.models;

public class Dirigente extends Persona {
    private Integer aniosExperiencia;

    public Dirigente() {
    }

    public Dirigente(Integer id, String nombre, String apellido, String genero, String tipoIdentificacion, String numeroIdentificacion, Integer aniosExperiencia) {
        super(id, nombre, apellido, genero, tipoIdentificacion, numeroIdentificacion);
        this.aniosExperiencia = aniosExperiencia;
    }

    public Integer getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(Integer aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
}
