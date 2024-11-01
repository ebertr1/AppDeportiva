package models;

public class Servicio {
    private int idServicio;
    private String tipo; 

    public Servicio(int idServicio, String tipo) {
        this.idServicio = 0;
        this.tipo = "";
    }

    // Getters and Setters
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
