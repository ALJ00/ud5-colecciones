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
        List<Alumno> alumnoList = new ArrayList<>();
        List<Asignatura> asignaturaList = new ArrayList<>();

        do {
            System.out.println("1.Crear nuevo alumno.\n" +
                    "2.Crear nueva asignatura.\n" +
                    "3.Matricular alumno en asignatura.\n" +
                    "4.Listado de alumnos matriculados en una asignatura.\n" +
                    "5.Listado de asignaturas en las que está matriculado un alumno y total de horas.\n" +
                    "6.Salir");
            System.out.println("Opcion: ");

            opcion = br.readLine().charAt(0);

            switch (opcion) {
                case '1':
                    System.out.println("Nombre alumno: ");
                    String name = br.readLine().toUpperCase();
                    System.out.println("Apellidos: ");
                    String apellidos = br.readLine().toUpperCase();
                    System.out.println("Email:");
                    String mail = br.readLine();
                    Alumno alum = new Alumno(name, apellidos, mail);
                    alumnoList.add(alum);
                    break;
                case '2':
                    System.out.println("Nombre asignatura: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Horas semanales: ");
                    int horas = Integer.parseInt(br.readLine());
                    Asignatura asig = new Asignatura(nombre, horas);
                    asignaturaList.add(asig);
                    break;
                case '3':
                    System.out.println("Matriculación:  ");
                    System.out.println("--------------------------");
                    System.out.println("Elige alumno: ");
                    for (int i = 0; i < alumnoList.size(); i++) {
                        System.out.println(i + "." + alumnoList.get(i).getNombre() + " " + alumnoList.get(i).getApellido());
                    }
                    String seleccionAlumno = br.readLine().toUpperCase();
                    System.out.println("Elige asignatura: ");
                    for (int i = 0; i < asignaturaList.size(); i++) {
                        System.out.println(i + "." + asignaturaList.get(i).getNombre());
                    }
                    String asigSelec = br.readLine().toUpperCase();

                    int posicionAlumno=0;
                    for (int i = 0; i < alumnoList.size(); i++) {
                        if (alumnoList.get(i).getNombre().equalsIgnoreCase(seleccionAlumno)) {
                            posicionAlumno = i;
                        }
                    }

                    int posicionAsignatura=0;
                    for (int i = 0; i < asignaturaList.size(); i++) {
                        if(asignaturaList.get(i).getNombre().equalsIgnoreCase(asigSelec)){
                            posicionAsignatura = i;
                        }
                    }

                    alumnoList.get(posicionAlumno).getAsignaturas().add(asignaturaList.get(posicionAsignatura));
                    asignaturaList.get(posicionAsignatura).getAlumnos().add(alumnoList.get(posicionAlumno));
                    break;
                case '4':
                    System.out.println("Alumnos matriculados en una asignatura, elija la asignatura a mostrar:  ");
                    for (int i = 0; i < asignaturaList.size(); i++) {
                        System.out.println(i+" "+asignaturaList.get(i).getNombre());
                    }
                    System.out.print("Asignatura nº: ");
                    int numero = Integer.parseInt(br.readLine());

                    System.out.println(asignaturaList.get(numero).getNombre());

                    for (int i = 0; i < alumnoList.size(); i++) {
                        System.out.println("Nombre: "+asignaturaList.get(numero).getAlumnos().get(i).getNombre());
                        System.out.println("Apellidos: "+asignaturaList.get(numero).getAlumnos().get(i).getApellido());
                    }

                    break;
                case '5':
                    break;
                case '6':
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Error...");
            }

        } while (opcion != '6');


    }
}
