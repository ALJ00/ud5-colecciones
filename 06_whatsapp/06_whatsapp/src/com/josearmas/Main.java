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

         /*HashMap<String,String >drae = new HashMap<>();
       drae.put("casa","Edificio para habitar");
        System.out.println("Definición de casa: "+drae.get("casa"));*/

        HashMap<String,Contacto >agenda = new HashMap<>();
        List<Contacto> contactos = new ArrayList<>();
        List<String >numerosTelefonicos = new ArrayList<>();

        int opcion;

        do {
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
            System.out.println("Opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion){
                case   11:
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
                    
                    //Creo el objeto nuevoContacto y lo añado a la Lista de contactos y el número a la lista de números
                    Contacto nuevoContacto = new Contacto(nombre,apellidos,email);
                    contactos.add(nuevoContacto);
                    numerosTelefonicos.add(numeroTelefono);
                    
                    //Compruebo que no haya más números idénticos
                    if(agenda.containsKey(numeroTelefono)){
                        System.out.println("Error, el número introducido ya existe...");
                    }else{
                        //Inserto en la agenda, introduzco un mapeo en el diccionario
                        agenda.put(numeroTelefono,nuevoContacto);
                    }
                    break;
                case 12:
                    System.out.println("Borrar contacto: ");
                    System.out.println("-------------------------");

                    //Le pido al usuario qué contacto quiere borrar.
                    System.out.println("Qué contacto desea borrar?: ");
                    for (int i = 0; i < contactos.size(); i++) {
                        System.out.println(i+"."+contactos.get(i).toString());
                    }
                    System.out.println("Número elegido: ");
                    int posicionElegida = Integer.parseInt(br.readLine());
                    //Muestro el número de telefono y si dice que sí lo borro
                    System.out.println("Está segur@ que desea borrar el nº "+numerosTelefonicos.get(posicionElegida)+"S/N");
                    char respuesta = br.readLine().toUpperCase().charAt(0);
                    if (respuesta=='S' )
                        agenda.remove(numerosTelefonicos.get(posicionElegida));
                    break;
            }
        }while(opcion != 4);








    }
}
