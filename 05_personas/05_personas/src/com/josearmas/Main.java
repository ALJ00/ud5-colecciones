package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException  {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Persona> personas1 = new HashSet<>();
        personas1.add(new Persona("Jose","101"));
        personas1.add(new Persona("Pedro","101"));
        personas1.add(new Persona("oscar","103"));
        personas1.add(new Persona("Raul","104"));
        personas1.add(new Persona("Sofia","105"));

        Set<Persona> personas2 = new HashSet<>();
        personas2.add(new Persona("Endi","101"));
        personas2.add(new Persona("Pol","102"));
        personas2.add(new Persona("Jose","109"));
        personas2.add(new Persona("Enzo","110"));
        personas2.add(new Persona("Juan","111"));

        System.out.println("Grupo de personas 1:");
        System.out.println("--------------------------------");
        for (Persona p:personas1) {
            System.out.println(p);
        }
        System.out.println();

        System.out.println("Grupo de personas 2:");
        System.out.println("--------------------------------");
        for (Persona p:personas2) {
            System.out.println(p);
        }
        System.out.println();

        // Crear un grupo con todos los elementos sin duplicados
        Set<Persona> copia = new HashSet<>(personas1);
        copia.addAll(personas2);
        System.out.println("Conjunto sin duplicados:");
        System.out.println("----------------------------");
        for (Persona p:copia) {
            System.out.println(p);
        }
        System.out.println();

        // Crear un grupo con todos los elementos y con duplicados
        List<Persona> replica = new LinkedList<>(personas1);

        System.out.println();
        replica.addAll(personas2);
        System.out.println("Conjunto con duplicados:");
        System.out.println("----------------------------");
        for (Persona p:replica) {
            System.out.println(p);
        }
        System.out.println();

        // Diferencia entre grupo1 y grupo2
        Set<Persona> conjunto2 = new HashSet<>(personas1);
        conjunto2.removeAll(personas2);

        System.out.println("Diferencia grupo1 y grupo2:");
        System.out.println("----------------------------");
        for (Persona p:conjunto2) {
            System.out.println(p);
        }
        System.out.println();

        //Intersencción grupo1 y grupo2

        Set<Persona> conjunto3 = new HashSet<>(personas1);
        conjunto3.retainAll(personas2);

        for (Persona p:conjunto3) {
            System.out.println(p);
        }








        
        
        

        










    }

}
