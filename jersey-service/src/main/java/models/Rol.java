package models;

public class Rol {
    private int idRol;
    private String nombre;

    public Rol(int idRol, String nombre) {
        this.idRol = 0;
        this.nombre = "";
    }

    // Getters and Setters
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
