package com.example.models;

import java.util.Date;

import com.example.models.enumerador.Genero;
import com.example.models.enumerador.TipoIdentificacion;

public class Dirigente extends Persona {
    private Integer aniosExperiencia;
<<<<<<< HEAD


    public Dirigente(Integer id, boolean activo, String nombre, String apellido, TipoIdentificacion tipo, String identificacion,
            Date fechaNacimiento, String celular, Genero genero, Integer aniosExperiencia) {
        super(id, activo, nombre, apellido, tipo, identificacion, fechaNacimiento, celular, genero);
        this.aniosExperiencia = aniosExperiencia;
    }
=======
    private Integer idEquipo;
>>>>>>> main

    public Dirigente() {
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Integer getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(Integer aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
}
