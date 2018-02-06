package com.josearmas;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Titular>titularesMain = new ArrayList<>();
        List<Cuenta>cuentasMain = new ArrayList<>();

        int opcion;

        do{
            System.out.println("1.Nuevo titular\n" +
                    "2.Cuenta bancaria\n" +
                    "3.Consultas\n" +
                    "Dado un titular, saldo de todas sus cuentas\n" +
                    "Dada una cuenta, titulares asociados\n" +
                    "4.Salir  ");
            System.out.println("Opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch(opcion){

                case 1:
                    //Doy de alta un titular:
                    System.out.println("Alta de nu nuevo titular:\n"+
                    "---------------------------------");
                    System.out.println("Nombre: ");
                    String nombre =br.readLine().toUpperCase();
                    System.out.println("Apellido: ");
                    String apellido =br.readLine().toUpperCase();
                    System.out.println("Dni: ");
                    String dni =br.readLine().toUpperCase();
                    System.out.println("Fecha alta: ");
                    String fechaAlta =br.readLine().toUpperCase();

                    Titular titular = new Titular(nombre,apellido,dni,fechaAlta);
                    titularesMain.add(titular);
                    break;

                case 2:
                    System.out.println("Operación en cuenta bancaria: \n"+
                    "-------------------------------------------");
                    System.out.println("a) Nueva cuenta. \n" +
                            "b) Nuevo apunte.\n" +
                            "c) Borrar cuenta.");
                    System.out.println("Opción: ");
                    char letra = br.readLine().charAt(0);

                    switch (letra){
                        case 'a':
                            //Creo nueva cuenta.
                            System.out.println("Nueva cuenta :");
                            System.out.println("--------------------------");
                            System.out.print("Código de cuenta: ");
                            String cod = br.readLine().toUpperCase();
                            Cuenta cuenta = new Cuenta(cod);

                            //Compruebo que haya titulares para asociar la cuenta.

                            if( titularesMain.size() == 0){
                                System.out.println("Error, no hay titulares para asociación, genere titulares");
                            }else{
                                for (int i = 0; i < titularesMain.size(); i++) {
                                    System.out.println(i+" "+titularesMain.get(i).getNombreTitular());
                                }
                                System.out.println("Elija el nº del titular a asociar: ");
                                int num =Integer.parseInt(br.readLine());
                                Titular copiaTitular = titularesMain.get(num);

                                cuentasMain.add(cuenta);
                                copiaTitular.getCuentas().add(cuenta);
                                cuenta.getTitulares().add(copiaTitular);
                                System.out.println();


                            }



                            break;
                    }



                    break;

            }





        }while(opcion !=4);








    }
}
