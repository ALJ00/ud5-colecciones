package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Alarma> alarmas = new ArrayList<>();

        int opcion;

        do {
            System.out.println("1.Activar alarma\n" +
                    "2.Desactivar alarma (necesario PIN)\n" +
                    "3.Consultar sensores\n" +
                    "4.Salir");
            System.out.println("Opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Activación de la alarma: ");
                    System.out.println("-----------------------------");
                    System.out.println("Introduzca el número de teléfono: ");
                    int numeroTelefono = Integer.parseInt(br.readLine());
                    //Creo un objeto alarma.
                    Alarma alarma = new Alarma(numeroTelefono);
                    alarmas.add(alarma);
                    int uno = 1;
                    break;
                case 2:
                    System.out.println("Desactivar alarma: ");
                    System.out.println("-------------------------");
                    if (alarmas.isEmpty()) {
                        System.out.println("No hay alarmas creadas...");
                    } else {
                        System.out.println("Qué alarma quiere desactivar: ");
                        for (int i = 0; i < alarmas.size(); i++) {
                            System.out.println(i + "." + alarmas.get(i).getTelefonoAviso());
                        }
                        System.out.println("Seleccione el nº correspondiente: : ");
                        int elecc = Integer.parseInt(br.readLine());
                        Alarma alarmaSeleccionada = alarmas.get(elecc);

                        int intentos = 3;
                        int pin;

                        do {
                            System.out.println("Introduzca pin, " + intentos + " intentos");
                            pin = Integer.parseInt(br.readLine());
                            if (alarmaSeleccionada.getPin() == pin) {
                                alarmaSeleccionada.desactivar(pin);
                                for (int i = 0; i < alarmaSeleccionada.getSensoresMovientos().size(); i++) {
                                    alarmaSeleccionada.setActivada(false);
                                    alarmaSeleccionada.getSensoresMovientos().get(i).setAlarma(null);
                                }
                                System.out.println("Alarma desactivada correctamente.");
                                intentos = 0;
                            } else {
                                System.out.println("Pin erroneo");
                                intentos--;
                            }

                        } while (intentos > 0 );

                        int prueba =0;
                        break;
                    }
                case 3:
                    System.out.println("Consultar sensores: ");
                    System.out.println("-------------------------");
                    System.out.println("Qué alarma quieres consultar?: ");
                    for (int i = 0; i < alarmas.size(); i++) {
                        System.out.println(i+"."+alarmas.get(i));
                    }
                    System.out.println("Alarma elegida: ");
                    int indiceElegido = Integer.parseInt(br.readLine());
                    Alarma alarmaElegida = alarmas.get(indiceElegido);

                    //Consulto si hay alarmas.
                    if(alarmas.size()==0){
                        System.out.println("No hay alarmas creadas...");

                    }else if(alarmaElegida.isActivada()) {
                        //Compruebo que la alarma seleccionada esté activada.
                        
                    }



                    break;
            }

        } while (opcion != 4) ;
    }
}