package com.josearmas;

public class Persona {


    private String nombre;
    private String DNI;

    public Persona() {


    }

    public Persona(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return DNI.equals(persona.DNI);
    }

    @Override
    public int hashCode() {
        return DNI.hashCode();
    }
}
