package com.example.models;

/**
 * Clase que describe atributos esenciales para brindar seguridad a la aplicacion
 * 
 */
public class Token {
	
	private int idToken, idUsr;
	
	private String token;
	private String fecha_creacion;
	// variable de refresh token	
	private String expiracion_token;
	private boolean isValid;
	
	public Token() {
		
	}
	
	public Token(String token, String fecha_creacion, String fecha_expiracion) {
		this.expiracion_token = fecha_expiracion;
		this.fecha_creacion = fecha_creacion;
		this.token = token;
		isValid = true; //Ojo Aqui
	}
	
	public int getIdUsr() {
		return idUsr;
	}

	public void setIdUsr(int idUsr) {
		this.idUsr = idUsr;
	}
	
	public int getIdToken() {
		return idToken;
	}
	public void setIdToken(int idToken) {
		this.idToken = idToken;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getExpiracion_token() {
		return expiracion_token;
	}
	public void setExpiracion_token(String expiracion_token) {
		this.expiracion_token = expiracion_token;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}
