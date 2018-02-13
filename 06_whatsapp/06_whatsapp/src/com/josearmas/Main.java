package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void espaciosConLineas() {
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         /*HashMap<String,String >drae = new HashMap<>();
       drae.put("casa","Edificio para habitar");
        System.out.println("Definición de casa: "+drae.get("casa"));*/

        HashMap<String, Contacto> agendaKeyTelefono = new HashMap<>();
        HashMap<String,Contacto> agendaKeyContacto = new HashMap<>();

        List<Contacto> contactosList = new ArrayList<>();


        int opcion;

        do {
            System.out.println("---------MENÚ PRINCIPAL------");
            espaciosConLineas();
            System.out.println(".Gestión de contactos\n" +
                    "11.Nuevo contacto.\n" +
                    "12.Eliminar contacto.\n" +
                    ".Búsqueda\n" +
                    "21.Buscar contacto por número de teléfono.\n" +
                    "22.Buscar contacto por nombre.\n" +
                    ".Listados\n" +
                    "31.Listado de todos los contactos, tal como se han añadido.\n" +
                    "32.Listado de todos los contactos, ordenados por número de teléfono.\n" +
                    "4.Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 11:
                    System.out.println("Nuevo contacto:");
                    System.out.println("---------------------");

                    //Creo un nuevo contacto:
                    //Pido los datos...
                    System.out.println("Inserte nombre: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Inserte apellidos: ");
                    String apellidos = br.readLine().toUpperCase();
                    System.out.println("Inserte mail: ");
                    String email = br.readLine().toUpperCase();
                    System.out.println("Inserte número: ");
                    String numeroTelefono = br.readLine().toUpperCase();

                    //Creo el objeto nuevoContacto
                    Contacto nuevoContacto = new Contacto(nombre, apellidos, email);
                    contactosList.add(nuevoContacto);

                    //Compruebo si la agenda contiene el mismo telefono
                    if (agendaKeyTelefono.containsKey(numeroTelefono)) {
                        System.out.println("Error, el número introducido ya existe...");
                    } else {
                        //Inserto en ambas agendas, introduzco un mapeo en el diccionario
                        agendaKeyTelefono.put(numeroTelefono, nuevoContacto);
                        agendaKeyContacto.put(nombre,nuevoContacto);
                    }
                    espaciosConLineas();
                    break;
                case 12:
                    System.out.println("Borrar contacto: ");
                    System.out.println("-------------------------");

                    //Le pido al usuario qué contacto quiere borrar y para ello recorro la agenda foreach
                    System.out.println("Qué contacto desea borrar?: ");
                    for (Contacto value : agendaKeyTelefono.values()) {
                        System.out.println("Contacto: "+value);
                    }
                    System.out.println("Introduzca el teléfono que desea borrar: ");
                    String numeroParaBorrarMapeo = br.readLine().toUpperCase();
                    agendaKeyTelefono.remove(numeroParaBorrarMapeo);
                    Contacto borradoCorrectamente = agendaKeyTelefono.remove(numeroParaBorrarMapeo);
                    if (agendaKeyTelefono.remove(numeroParaBorrarMapeo) == borradoCorrectamente)
                        System.out.println("El contacto se ha borrado correctamente.");
                    espaciosConLineas();
                    break;
                case 21:
                    //Buscar contacto por número de teléfono.
                    System.out.println("Buscar contacto:");
                    System.out.println("---------------------");
                    //Compruebo que la agenda contenga mapeos
                    if (agendaKeyTelefono.isEmpty()) {
                        System.out.println("Agenda vacía...");
                    } else {
                            System.out.println("Introduzca el teléfono para buscar contacto: ");
                            String numero = br.readLine().toUpperCase();
                            if(agendaKeyTelefono.containsKey(numero)){
                                System.out.println(agendaKeyTelefono.get(numero));
                            }else{
                                System.out.println("Número erróneo...");
                            }
                    }
                    espaciosConLineas();
                    break;
                case 22:
                    //Buscar contacto por nombre.
                    System.out.println("Búscar contacto por nombre: ");
                    System.out.println("-------------------------------");
                    //Compruebo si hay mapeos en la agenda.
                    if (agendaKeyContacto.isEmpty()) {
                        System.out.println("Agenda vacía.....");
                    } else {
                        System.out.println("Introduzca el nombre para buscar contacto: ");
                        String name= br.readLine().toUpperCase();
                        if(agendaKeyContacto.containsKey(name)){
                            System.out.println(agendaKeyContacto.get(name));
                        }else{
                            System.out.println("Número erróneo...");
                        }

                    }
                    espaciosConLineas();
                    break;
                case 31:
                    //Listado de todos los contactos, tal como se han añadido.
                    System.out.println("Listado de todos los contactos ordenados por orden de insercción: ");
                    for (Contacto c:contactosList) {
                        System.out.println(c);
                    }
                    espaciosConLineas();
                    break;
                case 32:
                    //Listado de todos los contactos ordenados por números de teléfono.
                    System.out.println("Listado de todos los contactos ordenados por número de teléfono: ");
                    SortedMap<String, Contacto> copiaAgenda2 = new TreeMap<>(agendaKeyTelefono);
                    for (Map.Entry entry : copiaAgenda2.entrySet()) {
                        System.out.println("Teléfono: " + entry.getKey() + " ---- " + entry.getValue().toString());
                    }
                    espaciosConLineas();
                    break;
            }
        } while (opcion != 4);


    }
}
