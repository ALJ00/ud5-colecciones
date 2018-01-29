package com.josearmas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private String anyoFundacion;

    //Asociacion
    private List<Empleado>empleados = new ArrayList<>();

    public Empresa() {
/*
        Empleado e = new Empleado();
        e.setEmpresa(this);
        empleados.add(e);
*/

        }

        public void crearEmpresa(String nombre, String anyoFundacion){
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

    public void setAnyoFundacion(String anyoFundacion) {
        this.anyoFundacion = anyoFundacion;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", anyoFundacion='" + anyoFundacion + '\'' +
                '}';
    }
}
