package com.josearmas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

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

        HashMap<String, Contacto> agenda = new HashMap<>();


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

                    //Creo el objeto nuevoContacto y lo añado a la agenda
                    Contacto nuevoContacto = new Contacto(nombre, apellidos, email);

                    //Compruebo si la agenda contiene el mismo telefono
                    if (agenda.containsKey(numeroTelefono)) {
                        System.out.println("Error, el número introducido ya existe...");
                    } else {
                        //Inserto en la agenda, introduzco un mapeo en el diccionario
                        agenda.put(numeroTelefono, nuevoContacto);
                    }
                    espaciosConLineas();
                    break;
                case 12:
                    System.out.println("Borrar contacto: ");
                    System.out.println("-------------------------");

                    //Le pido al usuario qué contacto quiere borrar y para ello recorro la agenda foreach
                    System.out.println("Qué contacto desea borrar?: ");
                    for (Map.Entry<String, Contacto> entry : agenda.entrySet()) {
                        System.out.println("Contacto: " + entry.getValue().toString() + "---" + "Teléfono: " + entry.getKey());
                    }
                    System.out.println("Introduzca el teléfono que desea borrar: ");
                    String numeroParaBorrarMapeo = br.readLine().toUpperCase();
                    agenda.remove(numeroParaBorrarMapeo);
                    Contacto borradoCorrectamente = agenda.remove(numeroParaBorrarMapeo);
                    if (agenda.remove(numeroParaBorrarMapeo) == borradoCorrectamente)
                        System.out.println("El contacto se ha borrado correctamente.");
                    espaciosConLineas();
                    break;
                case 21:
                    //Buscar contacto por número de teléfono.
                    System.out.println("Buscar contacto:");
                    System.out.println("---------------------");
                    //Compruebo que la agenda contenga mapeos
                    if (agenda.isEmpty()) {
                        System.out.println("Agenda vacía...");
                    } else {
                        String numero;
                        do {
                            System.out.println("Introduzca el número de teléfono para buscar contacto: ");
                            numero = br.readLine().toUpperCase();

                            if (agenda.get(numero) == null) {
                                System.out.println("El teléfono no existe, introduzca otro número por favor...");
                            } else {
                                System.out.println("Contacto: " + agenda.get(numero) + "--- Teléfono: " + numero);
                            }

                        } while (agenda.get(numero) == null);
                    }
                    espaciosConLineas();
                    break;
                case 22:
                    //Buscar contacto por nombre.
                    System.out.println("Búscar contacto por nombre: ");
                    System.out.println("-------------------------------");
                    //Compruebo si hay mapeos en la agenda.
                    if (agenda.isEmpty()) {
                        System.out.println("Agenda vacía.....");
                    } else {
                        String nombreAbuscar;
                        for (Map.Entry<String, Contacto> entry : agenda.entrySet()) {
                            System.out.println("Introduzca el nombre del contacto que quieres buscar:");
                            nombreAbuscar = br.readLine().toUpperCase();

                            if (!entry.getValue().getNombre().equalsIgnoreCase(nombreAbuscar)) {
                                System.out.println("El nombre introducido no pertenece a ningún contacto, inténtelo de nuevo");
                            } else {
                                System.out.println(entry.getValue().toString() + "--- Teléfono: " + entry.getKey());
                            }

                        }
                    }
                    espaciosConLineas();
                    break;
                case 31:
                    //Listado de todos los contactos, tal como se han añadido.
                    System.out.println("Listado de todos los contactos ordenados por orden de insercción: ");
                    HashMap<String, Contacto> copiaAgenda = new HashMap<>(agenda);
                    for (Map.Entry entry : copiaAgenda.entrySet()) {
                        System.out.println(entry.getValue().toString() + "--- Teléfono: " + entry.getKey());
                    }
                    espaciosConLineas();
                    break;
                case 32:
                    //Listado de todos los contactos ordenados por números de teléfono.
                    System.out.println("Listado de todos los contactos ordenados por número de teléfono: ");
                    SortedMap<String, Contacto> copiaAgenda2 = new TreeMap<>(agenda);
                    for (Map.Entry entry : copiaAgenda2.entrySet()) {
                        System.out.println("Teléfono: " + entry.getKey() + " ---- " + entry.getValue().toString());
                    }
                    espaciosConLineas();
                    break;
            }
        } while (opcion != 4);


    }
}
