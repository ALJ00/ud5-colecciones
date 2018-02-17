package com.josearmas;

import java.util.HashMap;
import java.util.Map;

public class Alumno {

    private String nombre;
    private String apellidos;
    private String email;

    //Asociación.
    private Map<Integer,Asignatura> asignaturasAlumno = new HashMap<>();

    public Alumno(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Alumno() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Integer, Asignatura> getAsignaturasAlumno() {
        return asignaturasAlumno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (!nombre.equals(alumno.nombre)) return false;
        if (!apellidos.equals(alumno.apellidos)) return false;
        return email.equals(alumno.email);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + apellidos.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
