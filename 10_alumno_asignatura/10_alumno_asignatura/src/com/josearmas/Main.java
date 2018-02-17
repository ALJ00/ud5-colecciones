package com.josearmas;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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

        Map<Integer,Alumno>alumnosMapMain = new HashMap<>();
        Map<Integer,Asignatura>asignaturasMapMain = new HashMap<>();

        int keyAlumno = 0;
        int keyAsignatura = 0;

        do{
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

            switch (opcion){

                case 1:
                    System.out.println("-------------- NUEVO ALUMNO ---------------");
                    System.out.println("Nombre: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Apellidos: ");
                    String apellidos = br.readLine().toUpperCase();
                    System.out.println("E-Mail: ");
                    String mail = br.readLine().toUpperCase();

                    Alumno alumno = new Alumno(nombre,apellidos,mail);
                    alumnosMapMain.put(keyAlumno,alumno);
                    keyAlumno++;

                    break;

                case 2:
                    System.out.println("-------------- BORRAR ALUMNO ----------------");
                    System.out.println("Qué alumno quiere borrar? ");

                    if(alumnosMapMain.size()==0){
                        System.out.println("No hay alumnos");
                    }else{
                        alumnosMapMain.forEach((k,v)->{
                            System.out.println(k+"--"+v);
                        });
                        System.out.println("Elije el número correspondiente: ");
                        int eleccion = Integer.parseInt(br.readLine());

                        alumnosMapMain.get(eleccion).getAsignaturasAlumno().clear();//1

                        alumnosMapMain.remove(eleccion);//2



                    }



                    break;

                case 3:
                    System.out.println("-------------- NUEVA ASIGNATURA ---------------");
                    System.out.println("Nombre: ");
                    String name = br.readLine().toUpperCase();
                    System.out.println("Horas semanales: ");
                    int horas = Integer.parseInt(br.readLine());

                    Asignatura asignatura = new Asignatura(name,horas);

                    asignaturasMapMain.put(keyAsignatura,asignatura);
                    keyAsignatura++;

                    break;

                case 4:

                    System.out.println("-------------- BORRAR ASIGNATURA ----------------");
                    System.out.println("Qué asignatura quiere borrar? ");

                    if(asignaturasMapMain.size()==0){
                        System.out.println("No hay asignaturas");
                    }else{
                        asignaturasMapMain.forEach((k,v)->{
                            System.out.println(k+"--"+v);
                        });
                        System.out.println("Elije el número correspondiente: ");
                        int eleccion = Integer.parseInt(br.readLine());

                        asignaturasMapMain.remove(eleccion);

                    }

                    break;


            }

        }while(  opcion!= 9);






    }
}
