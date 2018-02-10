package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Alarma> alarmas = new HashMap<>();

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
                    alarmas.put(numeroTelefono, alarma);
                    //int uno = 1;
                    break;
                case 2:
                    System.out.println("Desactivar alarma: ");
                    System.out.println("-------------------------");
                    int intentos = 3;
                    do {
                        System.out.println("Introduzca el código pin, sólo tiene " + intentos + " intentos:");
                        int codigo = Integer.parseInt(br.readLine());
                        if (alarmas.isEmpty()) {
                            System.out.println("No hay alarmas activadas...");
                        } else if (alarmas.containsValue()) {

                        }


                        intentos--;
                        if (intentos == 0) {
                            System.out.println("La Alarma se ha bloqueado, llame al servicio técnico...");
                        }
                    } while (intentos > 0);


                    break;
            }

        } while (opcion != 4);


    }
}
