package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Empresa> empresasMapMain = new HashMap<>();
        Map<String, Empleado> empleadosMapMain = new HashMap<>();



        int opcion;

        do {
            System.out.println("----- Empresa -----\n" +
                    "1.Crear nueva empresa\n" +
                    "2.Borrar una empresa\n" +
                    "---- Añadir empleados (a una empresa) -----\n" +
                    "3.Añadir operario\n" +
                    "4.Añadir directivo\n" +
                    "5.Listar empleados (de la empresa)\n" +
                    "---- Listados ----\n" +
                    "6.Todas las empresas\n" +
                    "7.Todos los empleados\n" +
                    "8.Listado por empresa y empleado\n" +
                    "---------------\n" +
                    "9.Salir");
            System.out.println("Opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {

                case 1:
                    System.out.println("---------- NUEVA EMPRESA ----------");
                    System.out.println("Nombre: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Año de fundación: ");
                    String anyo = br.readLine().toUpperCase();
                    //Creo nueva empresa.
                    Empresa empresa = new Empresa(nombre, anyo);
                    empresasMapMain.put(nombre, empresa);
                    break;
                case 2:
                    System.out.println("-------- BORRAR UNA EMPRESA ----------");
                    System.out.println("Introduzca el nombre de la empresa que quiere borrar.");
                    String nombreAborrar = br.readLine().toUpperCase();

                    if (empresasMapMain.get(nombreAborrar) == null) {
                        System.out.println("Error, la empresa no existe...");
                    } else {
                        System.out.println("Está seguro que desea borrar " + empresasMapMain.get(nombreAborrar).getNombre() + "? S/N.");
                        char respuesta = br.readLine().toUpperCase().charAt(0);
                        if (respuesta == 'S') {
                            empresasMapMain.remove(nombreAborrar);
                        }
                    }

                    int prueba = 2;
                    break;
                case 3:
                    System.out.println("---------- AÑADIR OPERARIO ----------");
                    System.out.println("Nombre: ");
                    String nombreEmpleado = br.readLine().toUpperCase();
                    System.out.println("Apellidos: ");
                    String apellidos = br.readLine().toUpperCase();
                    System.out.println("Fecha de nacimiento: ");
                    String fechaNac = br.readLine().toUpperCase();
                    System.out.println("Fecha contrato: ");
                    String fechaContrac = br.readLine().toUpperCase();
                    System.out.println("Salario hora: ");
                    Double salarioHora = Double.parseDouble(br.readLine());
                    System.out.println("Horas contrato: ");
                    int horas = Integer.parseInt(br.readLine());

                    //Creo nuevo operario.
                    Operario operario = new Operario(salarioHora, horas, nombreEmpleado, apellidos, fechaNac, fechaContrac);
                    empleadosMapMain.put(nombreEmpleado,operario);

                    //Selecciono la empresa donde lo voy a contratar.
                    System.out.println("En qué empresa lo quieres contratar ?: ");
                    empresasMapMain.forEach((k, v) -> {
                        System.out.println(k + "----" + v);
                    });
                    System.out.println("Empresa seleccionada: ");
                    String nombreSeleccionado = br.readLine().toUpperCase();
                    Empresa empresaSeleccionada = empresasMapMain.get(nombreSeleccionado);

                    //Una vez seleccionada asocio el empleado a esa empresa.
                    empresaSeleccionada.getEmpleados().put(nombreEmpleado, operario);
                    operario.setEmpresa(empresaSeleccionada);

                    int prue = 0;
                    break;
                case 4:
                    System.out.println("------------ AÑADIR DIRECTIVO --------------");
                    System.out.println("Nombre: ");
                    String nombreDirectivo = br.readLine().toUpperCase();
                    System.out.println("Apellidos: ");
                    String apellidosDirectivo = br.readLine().toUpperCase();
                    System.out.println("Fecha de nacimiento: ");
                    String fechaNacDirectivo = br.readLine().toUpperCase();
                    System.out.println("Fecha contrato: ");
                    String fechaContracDirectivo = br.readLine().toUpperCase();
                    System.out.println("Salario anual: ");
                    double salarioAnual = Double.parseDouble(br.readLine());

                    Directivo directivo = new Directivo(nombreDirectivo, apellidosDirectivo, fechaNacDirectivo,
                            fechaContracDirectivo, salarioAnual, 0.0);
                    empleadosMapMain.put(nombreDirectivo,directivo);

                    //Le pido al usuario que elija la empresa a asociar.
                    System.out.println("En qué empresa lo va a contratar? ");
                    empresasMapMain.forEach((k, v) -> {
                        System.out.println(k + "-----" + v);
                    });
                    System.out.print("Empresa seleccionada: ");
                    String nameSelection = br.readLine().toUpperCase();
                    //Asocio el directivo a la empresa.
                    Empresa empresaSelection = empresasMapMain.get(nameSelection);

                    empresaSelection.getEmpleados().put(nombreDirectivo, directivo);
                    empresaSelection.getEmpleados().get(nombreDirectivo).setEmpresa(empresaSelection);

                    int pol = 0;
                    break;
                case 5:
                    System.out.println("------------ LISTAR EMPLEADOS POR EMPRESA ------------------");
                    System.out.println("Introduzca la empresa a consultar");
                    String empresaAconsultar = br.readLine().toUpperCase();
                    if (empresasMapMain.get(empresaAconsultar) == null) {
                        System.out.println("Empresa no encontrada.");
                    } else {
                        Empresa consultaEmpresa = empresasMapMain.get(empresaAconsultar);
                        consultaEmpresa.getEmpleados().forEach((k, v) -> {
                            System.out.println(k+"-----"+v);
                        });
                    }

                    int ro = 0;
                    break;
                case 6:
                    System.out.println("----------- LISTADO DE TODAS LAS EMPRESAS -----------");
                    empresasMapMain.forEach((k,v)->{
                        System.out.println(k+"----"+v);
                    });
                    break;
                case 7:
                    System.out.println("----------- LISTADO DE TODAS LOS EMPLEADOS -----------");
                    empleadosMapMain.forEach((k,v)->{
                        System.out.println(k+"----"+v);
                    });
                    break;
                case 8:
                    System.out.println("---------- LISTADO POR EMPRESA Y EMPLEADO -----------");


                    break;
                case 9:
                    System.out.println("Adios...");
                    break;
            }

        } while (opcion != 9);


    }
}
