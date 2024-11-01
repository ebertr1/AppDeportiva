package models;

public class DetalleOrden {
    private int idDetalle;
    private String descripcion;
    private int idOrden;

    public DetalleOrden(int idDetalle, String descripcion, int idOrden) {
        this.idDetalle = 0;
        this.descripcion = "";
        this.idOrden = 0;
    }

    // Getters and Setters
    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }
}
