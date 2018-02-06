package com.josearmas;

public class Apunte {

    private double cantidad;
    private String fecha;

    //Conexion
    private Cuenta cuenta;

    public Apunte() {
    }

    public Apunte(double cantidad, String fecha) {
        this.cantidad = cantidad;
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

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
