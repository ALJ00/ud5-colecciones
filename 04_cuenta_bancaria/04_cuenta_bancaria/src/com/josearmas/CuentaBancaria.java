package com.josearmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CuentaBancaria {


    private String codigoCuenta;

    //Asociación
    private List<Titular>titulares = new ArrayList<>();
    private List<Apunte>apunteList = new ArrayList<>();


    public CuentaBancaria(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public double calcularSaldo(){

        double saldo = 0;

        for (int i = 0; i < apunteList.size(); i++) {
            saldo = apunteList.get(i).getCantidad()+saldo;
        }

        return saldo;
    }

    public void nuevoApunte( double cantidad ){

    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public List<Titular> getTitulares() {
        return titulares;
    }

    public List<Apunte> getApuntes() {
        return apunteList;
    }

    public List<Apunte> getApunteList() {
        return apunteList;
    }
}
