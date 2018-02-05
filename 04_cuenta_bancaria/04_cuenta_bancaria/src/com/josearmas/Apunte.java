package com.josearmas;

import java.util.ArrayList;
import java.util.List;

public class Apunte {

    private double cantidad;
    private String fecha;

    //Asociación
    CuentaBancaria cuentaBancaria;

    public Apunte(double cantidad, String fecha) {
        this.cantidad = this.cantidad;
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
}
