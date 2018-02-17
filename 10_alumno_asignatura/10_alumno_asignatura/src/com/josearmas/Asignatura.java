package com.josearmas;

import java.util.HashMap;
import java.util.Map;

public class Asignatura {

    private String nombre;
    private int horasSemanales;

    //Asociación.
    private Map<Integer,Alumno> alumnosAsignatura = new HashMap<>();

    public Asignatura(String nombre, int horasSemanales) {
        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
    }

    public Asignatura() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Map<Integer, Alumno> getAlumnosAsignatura() {
        return alumnosAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asignatura that = (Asignatura) o;

        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", horasSemanales='" + horasSemanales + '\'' +
                '}';
    }
}
