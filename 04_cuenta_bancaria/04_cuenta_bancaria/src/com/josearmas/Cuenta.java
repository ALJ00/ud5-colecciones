package com.josearmas;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

    private String codigoCuenta;

    //Conexión
    private List<Titular>titulares = new ArrayList<>();
    private List<Apunte>apuntes = new ArrayList<>();

    public Cuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public double calcularSaldo(){
        double saldo = 0.0;
        for (int i = 0; i < apuntes.size(); i++) {
            saldo = saldo+apuntes.get(i).getCantidad();
        }
        return saldo;
    }

    public void nuevoApunte( double cantidad){
        Apunte apunte = new Apunte();
        apuntes.add(apunte);
        apunte.setCuenta(this);
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
        return apuntes;
    }
}
