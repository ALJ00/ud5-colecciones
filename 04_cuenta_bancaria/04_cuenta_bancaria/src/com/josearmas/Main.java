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

        List<Titular> titularesMain = new ArrayList<>();
        List<Cuenta> cuentasMain = new ArrayList<>();

        int opcion;

        do {
            System.out.println("1.Nuevo titular\n" +
                    "2.Cuenta bancaria\n" +
                    "3.Consultas\n" +
                    "4.Salir  ");
            System.out.println("Opción: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {

                case 1:
                    //Doy de alta un titular:
                    System.out.println("Alta de nu nuevo titular:\n" +
                            "---------------------------------");
                    System.out.println("Nombre: ");
                    String nombre = br.readLine().toUpperCase();
                    System.out.println("Apellido: ");
                    String apellido = br.readLine().toUpperCase();
                    System.out.println("Dni: ");
                    String dni = br.readLine().toUpperCase();
                    System.out.println("Fecha alta: ");
                    String fechaAlta = br.readLine().toUpperCase();

                    Titular titular = new Titular(nombre, apellido, dni, fechaAlta);
                    titularesMain.add(titular);
                    break;

                case 2:
                    System.out.println("Operación en cuenta bancaria: \n" +
                            "-------------------------------------------");
                    System.out.println("a) Nueva cuenta. \n" +
                            "b) Nuevo apunte.\n" +
                            "c) Borrar cuenta.");
                    System.out.println("Opción: ");
                    char letra = br.readLine().charAt(0);

                    switch (letra) {
                        case 'a':
                            //Creo nueva cuenta.
                            System.out.println("Nueva cuenta :");
                            System.out.println("--------------------------");
                            System.out.print("Código de cuenta: ");
                            String cod = br.readLine().toUpperCase();
                            Cuenta cuenta = new Cuenta(cod);

                            //Compruebo que haya titulares para asociar la cuenta.
                            if (titularesMain.size() == 0) {
                                System.out.println("Error, no hay titulares para asociación, genere titulares");
                            } else {
                                //Muestro los titulares
                                for (int i = 0; i < titularesMain.size(); i++) {
                                    System.out.println(i + " " + titularesMain.get(i).getNombreTitular());
                                }
                                System.out.println("Elija el nº del titular a asociar: ");
                                int num = Integer.parseInt(br.readLine());
                                Titular copiaTitular = titularesMain.get(num);
                                cuentasMain.add(cuenta);
                                copiaTitular.getCuentas().add(cuenta);
                                cuenta.getTitulares().add(copiaTitular);
                                System.out.println();
                            }
                            break;

                        case 'b':
                            //Nuevo apunte
                            System.out.println("Nuevo apunte --------");
                            //Muestro la cuenta a asociar para que la elija
                            if (cuentasMain.size() == 0) {
                                System.out.println("Error, no hay cuentas para asociar...");
                            } else {
                                for (int i = 0; i < cuentasMain.size(); i++) {
                                    System.out.println(i + "--" + cuentasMain.get(i).getCodigoCuenta());
                                }
                                System.out.println("Elija el nº correspondiente a la cuenta a asociar: ");
                                int num = Integer.parseInt(br.readLine());

                                System.out.println("Cantidad: ");
                                double cantidad = Double.parseDouble(br.readLine());

                                Cuenta copiaCuenta = cuentasMain.get(num);
                                copiaCuenta.nuevoApunte(cantidad);

                            }
                            break;
                        case 'c':
                            // Eliminar cuenta
                            System.out.println("Qué cuenta desea borrar? ");
                            for (int i = 0; i < cuentasMain.size(); i++) {
                                System.out.println(i+"."+cuentasMain.get(i).getCodigoCuenta());
                            }
                            int resp = Integer.parseInt(br.readLine());
                            Cuenta c = cuentasMain.get(resp);


                            // 1
                            for (int i = 0; i < c.getApuntes().size(); i++) {
                                c.getApuntes().get(i).setCuenta(null);
                            }

                            // 2
                            cuentasMain.remove(resp);

                            // 3
                            for (int i = 0; i < c.getTitulares().size(); i++) {
                                c.getTitulares().get(i).getCuentas().remove(c);
                            }
                            
                            cuentasMain.get(resp).getApuntes().clear();

                            break;
                    }
                    break;

                case 3:
                    //Consultas
                    System.out.println("Consultas, elija la opción correspondiente: ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("a) Dado un titular, saldo de todas sus cuentas \n" +
                            "b) Dada una cuenta, titulares asociados");
                    char option = br.readLine().charAt(0);
                    switch (option){
                        case 'a':
                            //Muestro titulares para que escoja uno
                            if(titularesMain.size()==0){
                                System.out.println("No hay titulares...ERROR....");
                            }else{
                                for (int i = 0; i < titularesMain.size(); i++) {
                                    System.out.println(i+"."+titularesMain.get(i).getNombreTitular());
                                }
                                System.out.println("Elija el número del titular: ");
                                int numTit = Integer.parseInt(br.readLine());
                                Titular titularElejido = titularesMain.get(numTit);
                                for (int i = 0; i < titularElejido.getCuentas().size(); i++) {
                                    System.out.println("Codigo cuenta " + titularElejido.getCuentas().get(i).getCodigoCuenta());
                                    System.out.println("Saldo: "+titularElejido.getCuentas().get(i).calcularSaldo());
                                }

                            }

                            break;

                        case 'b':
                            //Elejir una cuenta
                            if(cuentasMain.size()==0){
                                System.out.println("Error... no hay cuentas");
                            }else{
                                for (int i = 0; i < cuentasMain.size(); i++) {
                                    System.out.println(i+"."+cuentasMain.get(i).getCodigoCuenta());
                                }
                                System.out.println("Elije cuenta: ");
                                int eleccion = Integer.parseInt(br.readLine());

                                Cuenta c = cuentasMain.get(eleccion);
                                System.out.println("Titulares asociados a la cuenta: "+c.getCodigoCuenta());
                                for (int i = 0; i < c.getTitulares().size(); i++) {
                                    System.out.println(c.getTitulares().get(i).getNombreTitular());
                                }
                            }

                            break;
                    }
                    break;

            }


        } while (opcion != 4);


    }
}
