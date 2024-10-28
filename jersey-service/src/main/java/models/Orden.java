package models;

public class Orden {
    private int idOrden;
    private int numeroOrden;

    public Orden(int idOrden, int numeroOrden) {
        this.idOrden = 0;
        this.numeroOrden = 0;
    }

    // Getters and Setters
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }
}
