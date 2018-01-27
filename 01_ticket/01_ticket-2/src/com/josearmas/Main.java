package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Fecha: ");
        String fecha = br.readLine();
        System.out.println("Hora: ");
        String hora = br.readLine();
        System.out.println("Número: ");
        int numero = Integer.parseInt(br.readLine());

        Ticket t1 = new Ticket(fecha, hora, numero);

        System.out.println("------------------------");
        char respuesta;

        do {

            System.out.println("Producto: ");
            String producto = br.readLine();
            System.out.println("Precio: ");
            double precio = Double.parseDouble(br.readLine());
            System.out.println("Uds: ");
            int uds = Integer.parseInt(br.readLine());
            double totalLinea = uds * precio;
            LineaTicket uno = new LineaTicket(uds, producto, precio, totalLinea);
            t1.getLineaTickets().add(uno);
            uno.setTicket(t1);

            System.out.println("Nuevo producto (S/N): ");
            respuesta = br.readLine().toUpperCase().charAt(0);

        } while (respuesta == 'S');

        System.out.println(t1.toString());

        for (int i = 0; i < t1.getLineaTickets().size(); i++) {
            System.out.println(t1.getLineaTickets().get(i));
            System.out.println("----------------------------------------");
        }

        t1.TotalTicket();

        System.out.println("TOTAL TICKET: "+t1.getTotalticket());






    }
}
