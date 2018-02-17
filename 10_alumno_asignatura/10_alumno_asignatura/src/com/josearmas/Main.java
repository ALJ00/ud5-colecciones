package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        Map<Integer, Alumno> alumnosMapMain = new HashMap<>();
        Map<Integer, Asignatura> asignaturasMapMain = new HashMap<>();

        int keyAlumno = 0;
        int keyAsignatura = 0;

        do {
            System.out.println("-------------Alumnos---------------\n" +
                    "1.Crear nuevo alumno.\n" +
                    "2.Borrar alumno.\n" +
                    "---------------------Asignaturas----------------\n" +
                    "3.Crear nueva asignatura.\n" +
                    "4.Borrar asignatura.\n" +
                    "---------------------Matrícula-------------------\n" +
                    "5.Matricular alumno en asignatura.\n" +
                    "6.Listado de alumnos matriculados en una asignatura.\n" +
                    "7.Listado de asignaturas en las que está matriculado un alumno.\n" +
                    "8.Listado de todos los alumnos del centro y total de horas en las que están matriculados.\n" +
                    "9.Salir");

            System.out.print("Opcion: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {

                case 1:
                    System.out.println("-------------- NUEVO ALUMNO ---------------");
                    System.out.println("Nombre: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Apellidos: ");
                    String apellidos = br.readLine().toUpperCase();
                    System.out.println("E-Mail: ");
                    String mail = br.readLine().toUpperCase();

                    Alumno alumno = new Alumno(nombre, apellidos, mail);
                    alumnosMapMain.put(keyAlumno, alumno);
                    keyAlumno++;

                    break;

                case 2:
                    System.out.println("-------------- BORRAR ALUMNO ----------------");
                    System.out.println("Qué alumno quiere borrar? ");

                    if (alumnosMapMain.size() == 0) {
                        System.out.println("No hay alumnos");
                    } else {
                        alumnosMapMain.forEach((k, v) -> {
                            System.out.println(k + "--" + v);
                        });
                        System.out.println("Elije el número correspondiente: ");
                        int eleccion = Integer.parseInt(br.readLine());

                        alumnosMapMain.get(eleccion).getAsignaturasAlumno().clear();//1
                        alumnosMapMain.remove(eleccion);//2

                        int tres = 0;

                    }


                    break;

                case 3:
                    System.out.println("-------------- NUEVA ASIGNATURA ---------------");
                    System.out.println("Nombre: ");
                    String name = br.readLine().toUpperCase();
                    System.out.println("Horas semanales: ");
                    int horas = Integer.parseInt(br.readLine());

                    Asignatura asignatura = new Asignatura(name, horas);

                    asignaturasMapMain.put(keyAsignatura, asignatura);
                    keyAsignatura++;

                    int hola = 0;

                    break;


                case 4:

                    System.out.println("-------------- BORRAR ASIGNATURA ----------------");
                    System.out.println("Qué asignatura quiere borrar? ");

                    if (asignaturasMapMain.size() == 0) {
                        System.out.println("No hay asignaturas");
                    } else {
                        asignaturasMapMain.forEach((k, v) -> {
                            System.out.println(k + "--" + v);
                        });
                        System.out.println("Elije el número correspondiente: ");
                        int eleccion = Integer.parseInt(br.readLine());


                        Asignatura asignaturaAborrar = asignaturasMapMain.get(eleccion);
                        asignaturaAborrar.getAlumnosAsignatura().clear();
                        asignaturasMapMain.remove(eleccion);

                    }

                    int uno = 0;

                    break;

                case 5:
                    System.out.println("--------------- MATRICULAR UN ALUMNO EN UNA ASIGNATURA --------------------");
                    System.out.println("Qué alumno quiere matricular? ");
                    alumnosMapMain.forEach((k, v) -> {
                        System.out.println(k + "---" + v);
                    });
                    System.out.println("Alumno elegido: ");
                    int numero = Integer.parseInt(br.readLine());
                    Alumno alumnoAmatricular = alumnosMapMain.get(numero);

                    if(asignaturasMapMain.size()==0){
                        System.out.println("No hay asignaturas...");
                    }else{
                        System.out.println("Asignatura :");
                        asignaturasMapMain.forEach((k, v) -> {
                            System.out.println(k + "---" + v);
                        });
                        System.out.println("Asignatura elegida: ");
                        int numAsig = Integer.parseInt(br.readLine());

                        Asignatura asignaturaEscogida = asignaturasMapMain.get(numAsig);

                        alumnoAmatricular.getAsignaturasAlumno().put(numAsig, asignaturaEscogida);
                        asignaturaEscogida.getAlumnosAsignatura().put(numero, alumnoAmatricular);
                    }


                    break;
                case 6:
                    System.out.println("------------ LISTADO DE ALUMNOS MATRICULADOS EN UNA ASIGNATURA -------------------");
                    System.out.println("Asignatura :");
                    asignaturasMapMain.forEach((k, v) -> {
                        System.out.println(k + "---" + v);
                    });
                    System.out.println("Elección: ");
                    int asig = Integer.parseInt(br.readLine());

                    Asignatura asignaturaElegida = asignaturasMapMain.get(asig);

                    asignaturaElegida.getAlumnosAsignatura().forEach((k,v)->{
                        System.out.println(k+"---"+v);
                    });

                    break;


            }

        } while (opcion != 9);


    }
}
