package com.josearmas;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {

    private String nombre;
    private int horasSemanales;

    //Asociacion
    private List<Alumno>alumnos = new ArrayList<>();

    public Asignatura(String nombre,int horasSemanales) {

        this.nombre = nombre;
        this.horasSemanales = horasSemanales;
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

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }


    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", horasSemanales=" + horasSemanales ;
    }
}
