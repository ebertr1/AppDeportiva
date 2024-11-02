package com.example.models;

public class Resultado {
    private Integer id;
    private String equipoGanador;
    private String equipoPerdedor;
    private Intege golesEquipo1;
    private Intege golesEquipo2;
    private Boolean empate;
    private Integer puntosEncuentro;

    public Resultado() {
    }

    public Resultado(Integer id, String equipoGanador, String equipoPerdedor, Intege golesEquipo1, Intege golesEquipo2, Boolean empate, Integer puntosEncuentro) {
        this.id = id;
        this.equipoGanador = equipoGanador;
        this.equipoPerdedor = equipoPerdedor;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.empate = empate;
        this.puntosEncuentro = puntosEncuentro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(String equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public String getEquipoPerdedor() {
        return equipoPerdedor;
    }

    public void setEquipoPerdedor(String equipoPerdedor) {
        this.equipoPerdedor = equipoPerdedor;
    }

    public Intege getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(Intege golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public Intege getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(Intege golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public Boolean getEmpate() {
        return empate;
    }

    public void setEmpate(Boolean empate) {
        this.empate = empate;
    }

    public Integer getPuntosEncuentro() {
        return puntosEncuentro;
    }

    public void setPuntosEncuentro(Integer puntosEncuentro) {
        this.puntosEncuentro = puntosEncuentro;
    }

}
