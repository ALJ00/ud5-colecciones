package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Empresa>empresaList = new ArrayList<>();
        List<Empleado>empleadoList = new ArrayList<>();

        char opcion;


        do{
            System.out.println("1.Crear nueva empresa.\n" +
                    "2.Añadir empleado a empresa ya existente.\n" +
                    "3.Listado de empresas.\n" +
                    "4.Listado detallado de empresas y empleados.\n" +
                    "5.Salir  ");
            System.out.println("Opción: ");
            opcion = br.readLine().charAt(0);

            switch (opcion) {
                case '1':
                    System.out.println("Nombre empresa: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Año de fundación: ");
                    String fund = br.readLine();
                    Empresa e = new Empresa(nombre,fund);
                    empresaList.add(e);
                    break;
                case '2':
                    System.out.println("Nombre empleado: ");
                    String nom = br.readLine();
                    System.out.println("Apellidos: ");
                    String ape = br.readLine();
                    System.out.println("Fecha Nacimiento: ");
                    String fecha = br.readLine();
                    System.out.println("Fecha Contrato: ");
                    String contrato = br.readLine();
                    Empleado empleado = new Empleado(nom,ape,fecha,contrato);
                    System.out.println("Empresa en la que se le va a contratar: ");
                    String respuesta = br.readLine();
                    if(empresaList.size()==0){
                        System.out.println("No hay empresas creadas, cree la empresa o asócielo a otra");
                    }
                    for (int i = 0; i < empresaList.size(); i++) {
                        if(respuesta.equalsIgnoreCase(empresaList.get(i).getNombre())){
                            empleadoList.add(empleado);
                            empresaList.get(i).getEmpleados().
                            empleado.getEmpresas().add(empresaList.get(i));

                        }

                    }


                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '5':
                    break;
                default:
                    System.out.println("Error....");

            }

        }while(opcion != '5');



    }
}
