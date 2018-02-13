package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Empresa>empresasMain = new ArrayList<>();
        Map<String,Empresa> empresaMap = new HashMap<>();
        List<Empleado>empleadosMain = new ArrayList<>();


        int opcion;

        do{
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
                    "---------------\n"+
                    "9.Salir");
            System.out.println("Opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion){

                case 1:
                    System.out.println("---------- NUEVA EMPRESA ----------");
                    System.out.println("Nombre: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Año de fundación: ");
                    String anyo = br.readLine().toUpperCase();
                    //Creo nueva empresa.
                    Empresa empresa = new Empresa(nombre,anyo);
                    empresasMain.add(empresa);
                    empresaMap.put(nombre,empresa);
                    break;
                case 2:
                    System.out.println("-------- BORRAR UNA EMPRESA ----------");
                    if(empresasMain.size() == 0){
                        System.out.println("No hay empresas que borrar.");
                    }else{
                        System.out.println("Introduzca el nombre de la empresa que quiere borrar.");
                        String nombreAborrar = br.readLine().toUpperCase();
                        if(empresaMap.containsKey(nombreAborrar)){
                            System.out.println("Está seguro que desea borrar "+empresaMap.get(nombreAborrar).toString()+"? S/N.");
                            char respuesta = br.readLine().toUpperCase().charAt(0);
                            if(respuesta == 'S'){
                                empresaMap.remove(nombreAborrar);
                                for (int i = 0; i < empresasMain.size(); i++) {
                                    if(empresasMain.get(i) == empresaMap.get(nombreAborrar)){
                                        empresasMain.get(i).getEmpleados().clear();
                                    }
                                }
                            }
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
                    Operario operario = new Operario(salarioHora,horas,nombreEmpleado,apellidos,fechaNac,fechaContrac);
                    Empleado empleado = (Empleado)operario;

                    //Selecciono la empresa donde lo voy a contratar.
                    System.out.println("En qué empresa lo quieres contratar ?: ");
                    for (int i = 0; i < empresasMain.size(); i++) {
                        System.out.println(i+"."+empresasMain.get(i).getNombre());
                    }
                    System.out.println("Índice seleccionado: ");
                    int indice = Integer.parseInt(br.readLine());
                    Empresa empresaSeleccionada = empresasMain.get(indice);

                    //Una vez seleccionada asocio el empleado a esa empresa.
                    empresaSeleccionada.getEmpleados().add(empleado);
                    empleado.setEmpresa(empresaSeleccionada);
                    empleadosMain.add(empleado);

                    int prue = 0;
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("Adios...");
                    break;
            }

        }while(opcion !=9 );



    }
}
