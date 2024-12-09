package com.example.models;

import java.util.Date;

import com.example.models.enumerador.Genero;
import com.example.models.enumerador.TipoIdentificacion;

public class Administrador extends Persona{
	
	private String email;
	
	public Administrador() {
		super(); // el constructor de la clase Padre o clase superior
	}
	
	public Administrador(Integer id, boolean activo, String nombre, String apellido, TipoIdentificacion tipo, String identificacion,
            Date fechaNacimiento, String celular, Genero genero, String email) {
        super(id, activo, nombre, apellido, tipo, identificacion, fechaNacimiento, celular, genero);
        this.email = email;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
