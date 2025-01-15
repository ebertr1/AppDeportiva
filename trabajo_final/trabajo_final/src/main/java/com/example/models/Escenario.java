package com.example.models;

/**
 * Clase Escenario
 * Contiene la informacion sobre los escenarios donde se celebran los
 * partidos, incluyendo ubicacion y nombre de Lugar
 */
public class Escenario {

	private Integer idEscenario;
	private String direccionEscenario;
	// Referencia de la direccion o lugar
	private String referenciadireccionEscenario;
	// Nombre del complejo deportivo o escenario deportivo
	private String nombreEscenario;

//	Gestores GETTERS AND SETTERS
	public Integer getIdEscenario() {
		return idEscenario;
	}
	public void setIdEscenario(Integer idEscenario) {
		this.idEscenario = idEscenario;
	}
	public String getDireccionEscenario() {
		return direccionEscenario;
	}
	public void setDireccionEscenario(String direccionEscenario) {
		this.direccionEscenario = direccionEscenario;
	}
	public String getReferenciadireccionEscenario() {
		return referenciadireccionEscenario;
	}
	public void setReferenciadireccionEscenario(String referenciadireccionEscenario) {
		this.referenciadireccionEscenario = referenciadireccionEscenario;
	}
	public String getNombreEscenario() {
		return nombreEscenario;
	}
	public void setNombreEscenario(String nombreEscenario) {
		this.nombreEscenario = nombreEscenario;
	}


	//	Constructores
	public Escenario() {

	}
	public Escenario(Integer idEscenario, String direccionEscenario, String referenciadireccionEscenario,
			String nombreEscenario) {
		this.idEscenario = idEscenario;
		this.direccionEscenario = direccionEscenario;
		this.referenciadireccionEscenario = referenciadireccionEscenario;
		this.nombreEscenario = nombreEscenario;
	}




}
