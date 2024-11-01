package com.example.models;

public class Arbitro extends Persona {
    private String asociacion;

    public Arbitro() {
    }

    public Arbitro(Integer id, String nombre, String apellido, String genero, String tipoIdentificacion, String numeroIdentificacion, String asociacion) {
        super(id, nombre, apellido, genero, tipoIdentificacion, numeroIdentificacion);
        this.asociacion = asociacion;
    }


    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }
    
}
