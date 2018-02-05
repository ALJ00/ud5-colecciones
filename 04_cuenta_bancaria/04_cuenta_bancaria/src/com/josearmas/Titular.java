package com.josearmas;

import java.util.ArrayList;
import java.util.List;

public class Titular {

    private String nombre;
    private String apellidos;
    private String DNI;
    private String fechaAlta;

    //Asociación
    private List<CuentaBancaria>cuentaBancariaList = new ArrayList<>();

    public Titular(String nombre, String apellidos, String DNI, String fechaAlta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.fechaAlta = fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public List<CuentaBancaria> getCuentaBancariaList() {
        return cuentaBancariaList;
    }


}
