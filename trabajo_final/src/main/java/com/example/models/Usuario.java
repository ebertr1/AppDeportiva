package com.example.models;

public class Usuario {
	// Id Usuario
    private Integer id;
    private String correo;
    private String contrasenia;
    private Boolean estado;
<<<<<<< HEAD
=======

>>>>>>> origin/rama_Matailo
    private Integer idPersona;

    public Usuario() {
    }

    public Usuario(Integer id, String correo, String contrasenia, Boolean estado) {
        this.id = id;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
<<<<<<< HEAD
=======

    public Rol getRole() {
		return role;
	}
>>>>>>> origin/rama_Matailo

    // hashear contrasenia

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

}
