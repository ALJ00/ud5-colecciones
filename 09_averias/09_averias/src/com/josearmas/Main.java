package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void listarAverias(Map<Integer, Averia> averias) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Seleccione la avería a reparar: ");

        if (averias.isEmpty()) {
            System.out.println("No hay averías pendientes.");
        } else {
            System.out.println("Qué avería desea atender ?");
            averias.forEach((k, v) -> {
                System.out.println(k + "---" + v);
            });

        }

    }


    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Tecnico> tecnicosMapMain = new HashMap<>();
        Queue< Averia> averiasMapMain = new LinkedList<>();
        Map<Integer, Averia> averiasMapMainResueltas = new HashMap<>();



        int opcion;
        int keyTecnico = 0;
        int keyAveria = 0;

        do {
            System.out.println("1.Alta de técnico.\n" +
                    "/-------- Gestión de averías --------/\n" +
                    "2.Nueva avería.\n" +
                    "3.Asignar avería a técnico.\n" +
                    "4.Atender avería.\n" +
                    "/--------- Listados ------------/\n" +
                    "5.Listado de averías sin resolver de un técnico.\n" +
                    "6.Listado de todas las averías de un técnico (resueltas y no resueltas).\n" +
                    "7.Listado de todas las averías del sistema y técnico asignado.\n" +
                    "8.Salir");

            System.out.print("Opción: ");
            opcion = Integer.parseInt(br.readLine());


            switch (opcion) {

                case 1:





                    break;
                case 2:
                    System.out.println("-------- NUEVA AVERÍA --------");

                    System.out.println("Título: ");
                    String titulo = br.readLine().toUpperCase();
                    System.out.println("Descripción: ");
                    String descripción = br.readLine().toUpperCase();
                    System.out.println("Fecha de apertura: ");
                    String fecha = br.readLine().toUpperCase();
                    System.out.println("Nivel: ");
                    int nivel = Integer.parseInt(br.readLine());

                    averiasMapMain.add(new Averia(titulo,descripción,fecha,nivel));

                    if(tecnicosMapMain.size()==0){
                        System.out.println("Crea un técnico....");
                    }else{
                        System.out.println("Elije un técnico: ");
                        tecnicosMapMain.forEach((k,v)->{
                            System.out.println(k+"---"+v);
                        });
                        int eleccion = Integer.parseInt(br.readLine());

                        Tecnico tecnicoSeleccionado = tecnicosMapMain.get(eleccion);

                        tecnicoSeleccionado.getAverias().add(averiasMapMain.element());

                        averiasMapMain.element().setTecnico(tecnicoSeleccionado);
                    }
                    break;

                case 3:
                    System.out.println("------------ ASIGNAR AVERIA A TÉCNICO ------------");


                    break;

                case 4:
                    System.out.println("------- ATENDER AVERÍA -------");



                    break;
                case 5:


                    break;
                case 6:
                    System.out.println("---------------- AVERIAS ABIERTAS ------------------");


                    break;

                case 7:
                    System.out.println("---------------- LISTADO DE TODAS LAS AVERÍAS DEL SISTEMA -----------------");




                    break;
            }


        } while (opcion != 8);


    }
}
