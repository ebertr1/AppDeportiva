package models;

public class EquipoTecnologico {
    private int idEquipo;
    private String marca;
    private String tipo; 
    private String analisis;
    private String componente;
    private float peso;
    private int idPersona;

    public EquipoTecnologico(int idEquipo, String marca, String tipo, String analisis, String componente, float peso,
            int idPersona) {
        this.idEquipo = 0;
        this.marca = "";
        this.tipo = "";
        this.analisis = "";
        this.componente = "";
        this.peso = 0;
        this.idPersona = 0;
    }

    // Getters and Setters
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAnalisis() {
        return analisis;
    }

    public void setAnalisis(String analisis) {
        this.analisis = analisis;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
}
