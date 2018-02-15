package com.josearmas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {

    private String nombre;
    private String anyoFundacion;

    //Conexión
    private Map<String,Empleado>empleados = new HashMap<>();

    public Empresa() {
    }

    public Empresa(String nombre, String anyoFundacion) {
        this.nombre = nombre;
        this.anyoFundacion = anyoFundacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnyoFundacion() {
        return anyoFundacion;
    }

    public Map<String,Empleado> getEmpleados() {
        return empleados;
    }

    public void setAnyoFundacion(String anyoFundacion) {
        this.anyoFundacion = anyoFundacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        if (nombre != null ? !nombre.equals(empresa.nombre) : empresa.nombre != null) return false;
        return anyoFundacion != null ? anyoFundacion.equals(empresa.anyoFundacion) : empresa.anyoFundacion == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (anyoFundacion != null ? anyoFundacion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", anyoFundacion='" + anyoFundacion + '\'' +
                '}';
    }
}
