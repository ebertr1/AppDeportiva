package com.example.models;

public class Jugador extends Persona {
    private Integer numCamiseta;

    public Jugador() {
    }

    public Jugador(Integer id, String nombre, String apellido, String genero, String tipoIdentificacion, String numeroIdentificacion, Integer numCamiseta) {
        super(id, nombre, apellido, genero, tipoIdentificacion, numeroIdentificacion);
        this.numCamiseta = numCamiseta;
    }

    public Integer getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(Integer numCamiseta) {
        this.numCamiseta = numCamiseta;
    }

}
