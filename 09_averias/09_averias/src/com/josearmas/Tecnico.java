package com.josearmas;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tecnico {

    private String nombre;
    private int nivel;

    //Asociación.
    private Map<Integer,Averia> averias = new LinkedHashMap<>();

    public Tecnico() {
    }

    public Tecnico(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Map<Integer, Averia> getAverias() {
        return averias;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tecnico tecnico = (Tecnico) o;

        if (nivel != tecnico.nivel) return false;
        return nombre != null ? nombre.equals(tecnico.nombre) : tecnico.nombre == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + nivel;
        return result;
    }
}
