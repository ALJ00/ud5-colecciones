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

        char opcion;
        List<Titular> titulares = new ArrayList<>();
        List<CuentaBancaria> cuentaBancarias = new ArrayList<>();
        List<Apunte> apuntes = new ArrayList<>();

        do {
            System.out.println("1.Nuevo titular\n" +
                    "2.Cuenta bancaria\n" +
                    "3.Consultas\n" +
                    "4.Salir");

            System.out.println("Opción: ");
            opcion = br.readLine().charAt(0);

            switch (opcion) {
                case '1':
                    System.out.println("Alta nuevo titular: \n" +
                            "-----------------------------");
                    System.out.println("Nombre: ");
                    String name = br.readLine().toUpperCase();
                    System.out.println("Apellidos: ");
                    String apellidos = br.readLine().toUpperCase();
                    System.out.println("DNI: ");
                    String dni = br.readLine().toUpperCase();
                    System.out.println("Fecha alta: ");
                    String dateAlta = br.readLine().toUpperCase();
                    titulares.add(new Titular(name, apellidos, dni, dateAlta));

                    break;
                case '2':
                    System.out.println("Cuenta bancaria: \n"
                            + "------------------------------");
                    System.out.println("a) Nueva cuenta\n" +
                            "b) Nuevo apunte\n" +
                            "c) Borrar cuenta\n");
                    System.out.println("Selecciona la letra correspondiente: ");
                    char seleccion = br.readLine().charAt(0);
                    switch (seleccion) {
                        case 'a':
                            System.out.println("Introducir código de cuenta: ");
                            String codigo = br.readLine().toUpperCase();
                            CuentaBancaria c = new CuentaBancaria(codigo);
                            cuentaBancarias.add(c);
                            System.out.println("A qué usuario pertenece? :");
                            if (titulares.size() == 0) {
                                System.out.println("No hay titulares para asociar... crea titulares");
                            } else {
                                System.out.println("Seleccione el titular: ");
                                for (int i = 0; i < titulares.size(); i++) {
                                    System.out.println(i + "." + titulares.get(i).getNombre());
                                }
                                System.out.print("Selecciona el número correspondiente: ");
                                int n = Integer.parseInt(br.readLine());

                                Titular titularSeleccionado = titulares.get(n);

                                titularSeleccionado.getCuentaBancariaList().add(c);
                                c.getTitulares().add(titularSeleccionado);
                            }
                            break;
                        case 'b':
                            System.out.println("Nuevo apunte: \n" +
                                    "----------------------------");
                            System.out.println("Cantidad: ");
                            double cantidad = Double.parseDouble(br.readLine());
                            System.out.println("Fecha apunte: ");
                            String fechaApunte = br.readLine().toUpperCase();
                            Apunte apunte = new Apunte(cantidad, fechaApunte);
                            apuntes.add(apunte);

                            if (cuentaBancarias.size() == 0) {
                                System.out.println("No hay cuentas creadas, cree una nueva...");
                            } else {
                                System.out.println("Seleccione código de cuenta: ");
                                for (int i = 0; i < cuentaBancarias.size(); i++) {
                                    System.out.println(cuentaBancarias.get(i).getCodigoCuenta());
                                }

                                System.out.print("Seleccion: ");
                                String cod = br.readLine().toUpperCase();

                                for (int i = 0; i < cuentaBancarias.size(); i++) {
                                    if (cuentaBancarias.get(i).getCodigoCuenta().equalsIgnoreCase(cod)) {
                                        CuentaBancaria cuentaSeleccionada = cuentaBancarias.get(i);
                                        cuentaSeleccionada.getApunteList().add(apunte);
                                        apunte.setCuentaBancaria(cuentaSeleccionada);
                                    }
                                }
                            }


                            break;
                        case 'c':

                            break;
                    }

                    break;
                case '3':
                    System.out.println("a) Dado un titular, saldo de todas sus cuentas\n" +
                            "b) Dada una cuenta, titulares asociados");
                    System.out.println("Opcion: ");
                    char op = br.readLine().charAt(0);
                    switch (op) {
                        case 'a':
                            for (int i = 0; i < titulares.size(); i++) {
                                if (titulares.size() == 0) {
                                    System.out.println("No hay titulares a consultar...");
                                } else {
                                    System.out.println("Lista de titulaes: \n" +
                                            "----------------------------------");
                                    for (int j = 0; j < titulares.size(); j++) {
                                        System.out.println(titulares.get(j).getNombre());
                                    }
                                }
                                System.out.println("Seleccione el titular: ");
                                String titularSeleccionado = br.readLine().toUpperCase();

                                for (int j = 0; j < titulares.size(); j++) {
                                    if (titularSeleccionado.equalsIgnoreCase(titulares.get(j).getNombre())) {
                                        if (titulares.get(j).getCuentaBancariaList().size() == 0) {
                                            System.out.println("Error, no hay cuenta bancaria asociada...");
                                        } else {
                                            for (int k = 0; k < titulares.get(j).getCuentaBancariaList().size(); k++) {
                                                System.out.println("Cuenta: "+titulares.get(j).getCuentaBancariaList()
                                                        .get(k).getCodigoCuenta());
                                                System.out.println("Saldo: "+titulares.get(j).getCuentaBancariaList()
                                                        .get(k).calcularSaldo());

                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case 'b':
                            for (int i = 0; i < cuentaBancarias.size(); i++) {

                            }
                    }

                    break;
                case '4':
                    System.out.println("Adios...");
                    break;
            }

        } while (opcion != '4');


    }
}
