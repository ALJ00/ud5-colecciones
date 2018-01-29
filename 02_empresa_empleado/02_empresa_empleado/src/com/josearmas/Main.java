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


        char opcion;
        List<Empresa> empresaList = new ArrayList<>();
        int recorre = 0;


        do {
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
                    Empresa e = new Empresa();
                    e.crearEmpresa(nombre, fund);
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
                    Empleado empleado = new Empleado(nom, ape, fecha, contrato);
                    System.out.println("Empresa en la que se le va a contratar: ");
                    String respuesta = br.readLine();
                    if (empresaList.size() == 0) {
                        System.out.println("No hay empresas creadas");
                    } else {
                        for (int i = 0; i < empresaList.size(); i++) {
                            if (empresaList.get(i).getNombre().equalsIgnoreCase(respuesta)) {
                                empresaList.get(i).getEmpleados().add(empleado);
                                empleado.setEmpresa(empresaList.get(i));
                            }
                        }
                    }
                    break;
                case '3':
                    if(empresaList.size()==0){
                        System.out.println("No hay empresas creadas");
                    }else{
                        for (int i = 0; i < empresaList.size(); i++) {
                            System.out.println(empresaList.get(i).toString());
                        }
                    }
                    break;
                case '4':
                    for (int i = 0; i < empresaList.size(); i++) {
                        System.out.println("Empresa: " + empresaList.get(i).getNombre());
                        System.out.println("Año fundación: " + empresaList.get(i).getAnyoFundacion());
                        System.out.println("-------------------------------");
                        List<Empleado> empleados = empresaList.get(i).getEmpleados();
                        for (int j = 0; j < empleados.size(); j++) {
                            System.out.println("Empleado: " +empleados.get(j).getNombre());
                            System.out.println("Apellidos: " + empleados.get(j).getApellidos());
                            System.out.println("Fecha Nacimiento: " + empleados.get(j).getFechaNacimiento());
                            System.out.println("Fecha Contrato: " + empleados.get(j).getFechaContrato());
                        }
                        System.out.println("-----------------------------");
                        System.out.println("-----------------------------");
                    }
                    break;
                case '5':
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Error....");

            }

        } while (opcion != '5');


    }
}
