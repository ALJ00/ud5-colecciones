package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Ticket t = new Ticket();

        System.out.println("Fecha: ");
        t.setFecha("24/01/2018");
        System.out.println(t.getFecha());
        System.out.println("Hora: ");
        t.setHora("21:00");
        System.out.println(t.getHora());

        int contador = 0;
        char respuesta;

        do{
            System.out.println("¿Nuevo producto (S/N)?: ");
            respuesta = br.readLine().toUpperCase().charAt(0);
            if(respuesta =='S' )
                System.out.println("Descripción: ");
                t.getLineas().get(contador).setProducto(br.readLine());
            System.out.println("Precio: ");
            t.getLineas().get(contador).setImporte(Integer.parseInt(br.readLine()));
            System.out.println("Unidades: ");
            t.getLineas().get(contador).setUds(Integer.parseInt(br.readLine()));
            t.getLineas().get(contador).totalLinea();
            contador++;


        }while(contador<5 || respuesta !='N');

        double total = 0;

        System.out.println("-------------- TICKET Nº "+t.getNumero()+" -------------------");
        System.out.println(t.toString());
        for (int i = 0; i <t.getLineas().size(); i++) {
            System.out.println("Producto: "+t.getLineas().get(i).getProducto());
            System.out.println("Unidades: "+t.getLineas().get(i).getUds());
            System.out.println("Precio uds:"+t.getLineas().get(i).getImporte());
            System.out.println("Total linea: "+t.getLineas().get(i).getTotal());
            total = total + t.getLineas().get(i).getTotal();

            System.out.println("-------------------------------------------------------");
        }
        System.out.println("Total ticket: "+total);









    }
}
