package models;

public class Tecnico extends Persona {
    private float salary;

    public Tecnico(int idPersona, String nombre, String apellido, String DNI, String celular, float salary) {
        super(idPersona, nombre, apellido, DNI, celular);
        this.salary = 0;
    }

    // Getters and Setters
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
