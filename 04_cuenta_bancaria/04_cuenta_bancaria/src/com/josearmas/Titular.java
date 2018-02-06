package com.josearmas;

import java.util.ArrayList;
import java.util.List;

public class Titular {

    private String nombreTitular;
    private String apellidoTitular;
    private String DNI;
    private String fechaAlta;

    //Conexión
    private List<Cuenta> cuentas = new ArrayList<>();

    public Titular(String nombreTitular, String apellidoTitular, String DNI, String fechaAlta) {
        this.nombreTitular = nombreTitular;
        this.apellidoTitular = apellidoTitular;
        this.DNI = DNI;
        this.fechaAlta = fechaAlta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getApellidoTitular() {
        return apellidoTitular;
    }

    public void setApellidoTitular(String apellidoTitular) {
        this.apellidoTitular = apellidoTitular;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
}
