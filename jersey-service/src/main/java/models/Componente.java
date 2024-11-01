package models;

public class Componente {
    private int idComponente;
    private String nombre;
    private String marca;

    public Componente(int idComponente, String nombre, String marca) {
        this.idComponente = 0;
        this.nombre = "";
        this.marca = "";
    }

    // Getters and Setters
    public int getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(int idComponente) {
        this.idComponente = idComponente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
