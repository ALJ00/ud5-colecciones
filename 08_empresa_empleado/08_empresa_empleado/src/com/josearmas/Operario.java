package com.josearmas;

public class Operario extends Empleado {

    private double salarioHora;
    private int horasContrato;

    public Operario(Double salarioHora, int horasContrato, String name, String ape, String fechaN, String fechaC) {
        super(name,ape,fechaN,fechaC);
        this.salarioHora = salarioHora;
        this.horasContrato = horasContrato;

    }


    public Double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int getHorasContrato() {
        return horasContrato;
    }

    public void setHorasContrato(int horasContrato) {
        this.horasContrato = horasContrato;
    }
}
