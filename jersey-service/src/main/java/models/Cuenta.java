package models;

public class Cuenta {
    private int idCuenta;
    private String email;
    private String password;
    private int idPersona;
    private boolean estado;

    public Cuenta(int idCuenta, String email, String password, int idPersona, boolean estado) {
        this.idCuenta = 0;
        this.email = "";
        this.password = "";
        this.idPersona = 0;
        this.estado = estado;
    }

    // Getters and Setters
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
