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
    public boolean equals(Persona p2) {

        return getDNI().equals(p2.getDNI());
    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getDNI() != null ? getDNI().hashCode() : 0);
        return result;
    }
}
