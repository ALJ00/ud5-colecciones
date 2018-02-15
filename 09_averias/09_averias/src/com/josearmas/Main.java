package com.josearmas;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void listarAverias (Map<Integer,Averia>averias){

        System.out.println("Seleccione la avería a reparar: ");

        if(averias.isEmpty()){
            System.out.println("No hay averías pendientes.");
        }else {
            System.out.println("Qué avería desea atender ?");
            averias.forEach((k, v) -> {
                System.out.println(k + "---" + v);
            });
        }

    }



    public static void main(String[] args) throws IOException {
	// write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer,Tecnico> tecnicosMapMain = new HashMap<>();
        Map<Integer, Averia> averiasMapMain = new HashMap<>();
        Map<Integer, Averia> averiasMapMainResueltas = new HashMap<>();

        int opcion;
        int keyTecnico = 0;
        int keyAveria = 0;

        do{
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



            switch (opcion){

                case 1:

                    System.out.println("Nuevo técnico: ");
                    System.out.println("Nombre: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Nivel 1, 2 o 3");
                    int nivel = Integer.parseInt(br.readLine());

                    Tecnico tecnico = new Tecnico(nombre,nivel);
                    tecnicosMapMain.put(keyTecnico,tecnico);

                    keyTecnico++;

                    break;
                case 2:

                    System.out.println("---------- NUEVA AVERIA ------------");
                    System.out.println("Titulo: ");
                    String titulo = br.readLine().toUpperCase();
                    System.out.println("Descripción: ");
                    String descripcion = br.readLine().toUpperCase();
                    System.out.println("Fecha de apertura: ");
                    String fechaApertura = br.readLine().toUpperCase();
                    System.out.println("Nivel: ");
                    int niv = Integer.parseInt(br.readLine());

                    Averia averia = new Averia(titulo,descripcion,fechaApertura,niv);
                    averiasMapMain.put(keyAveria,averia);
                    keyAveria++;


                    break;

                case 3:
                    System.out.println("------------ ASIGNAR AVERIA A TÉCNICO ------------");

                    listarAverias(averiasMapMain);

                    System.out.print("Avería seleccionada: ");
                    int key = Integer.parseInt(br.readLine());

                    Averia averiaSeleccionada = averiasMapMain.get(key);

                    System.out.println("Elija el técnico a asociar con la avería: ");
                    tecnicosMapMain.forEach((k,v)->{
                        System.out.println(k+"---"+v);
                    });
                    System.out.println("Técnico elegido: ");
                    int keyTec = Integer.parseInt(br.readLine());

                    Tecnico tecnicoElegido = tecnicosMapMain.get(keyTec);

                    tecnicoElegido.getAverias().put(key,averiaSeleccionada);
                    averiaSeleccionada.setTecnico(tecnicoElegido);

                    break;

                case 4:
                    System.out.println("------- ATENDER AVERÍA -------");

                    listarAverias(averiasMapMain);

                        System.out.print("Selección: ");
                        int numero = Integer.parseInt(br.readLine());

                        if( averiasMapMain.get(numero ).resolverAveria()){
                            //La meto en averias resueltas.
                            averiasMapMain.get(numero).setFechaApertura("closed");
                            averiasMapMainResueltas.put(numero,averiasMapMain.get(numero));
                            
                            //Elimino las conexiones a la avería que voy a eliminar.
                            Tecnico seleccionado = averiasMapMain.get(numero).getTecnico();
                            seleccionado.getAverias().remove(numero);
                            averiasMapMain.remove(numero);


                        }else{
                            averiasMapMain.get(numero).setNivel(-1);
                            averiasMapMain.put(numero,averiasMapMain.get(numero));
                        }

                    break;
                case 5:
                    System.out.println("-------- LISTADO DE AVERÍAS SIN RESOLVER DE UN TÉCNICO -------------");
                    System.out.println("Seleccione un técnico: ");
                    tecnicosMapMain.forEach((k,v)->{
                        System.out.println(k+"---"+v);
                    });
                    System.out.println("Selección: ");
                    int sel = Integer.parseInt(br.readLine());
                    tecnicosMapMain.get(sel).getAverias().forEach((k,v)->{
                        System.out.println(k+"---"+v);
                    });

                    break;
            }



        }while( opcion!= 8 );






    }
}
