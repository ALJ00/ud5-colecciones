package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException  {
	// write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Persona> conjuntoPersonas1 = new HashSet<>();
        Set<Persona> conjuntoPersonas2 = new HashSet<>();


        System.out.println("Datos para el conjunto 1: \n"+
        "------------------------------------");
        for (int i = 0; i < 2; i++) {
            System.out.println("Nombre: ");
            String nombre = br.readLine().toUpperCase();
            System.out.println("DNI: ");
            String dni = br.readLine().toUpperCase();
            Persona people1 = new Persona(nombre,dni);
            conjuntoPersonas1.add(people1);
        }

        System.out.println("Datos para el conjunto 2: \n"+
                "------------------------------------");

        for (int i = 0; i < 2; i++) {
            System.out.println("Nombre: ");
            String nombre = br.readLine().toUpperCase();
            System.out.println("DNI: ");
            String dni = br.readLine().toUpperCase();
            Persona people2 = new Persona(nombre,dni);
            conjuntoPersonas2.add(people2);
        }

        //Operaciones de los conjuntos:

        //Conjunto formado por todas las personas sin duplicados




        //Unión  duplicados
        conjuntoPersonas1.addAll(conjuntoPersonas2);
        System.out.println("Con duplicados:");
        for (Persona grupo2:conjuntoPersonas1) {
            System.out.println(grupo2.getNombre()+"--"+grupo2.getDNI());
        }

        System.out.println("------------------");
        System.out.println("Sin duplicados:");

        //Unión con los elementos comunes, sin duplicados:
        conjuntoPersonas1.retainAll(conjuntoPersonas2);

        for (Persona grupo2:conjuntoPersonas1) {
            System.out.println(grupo2.getNombre()+"--"+grupo2.getDNI());
        }

        System.out.println("---------------------------");

        //Diferencia entre ambos conjuntos:
        Set<Persona> diferencia = new HashSet<>();
        diferencia = conjuntoPersonas2.removeAll(conjuntoPersonas1);

        for (Persona grupo2:conjuntoPersonas1) {
            System.out.println(grupo2.getNombre()+"--"+grupo2.getDNI());
        }






    }

}
