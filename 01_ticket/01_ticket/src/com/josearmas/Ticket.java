package com.josearmas;

import java.util.ArrayList;

public class Ticket {

    private String empresa = "EGIBIDE";
    private String fecha;
    private int numero;
    private String hora;

    //Asociacion
    private ArrayList<LineaTicket> lineas = new ArrayList<>();

    public Ticket() {

        for (int i = 0; i < 5; i++) {

            LineaTicket l = new LineaTicket();
            l.setTicket(this);
            lineas.add(l);

        }


    }

    public Ticket(String empresa, String fecha, int numero) {
        this.empresa = empresa;
        this.fecha = fecha;
        this.numero = numero;

    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }



    public ArrayList<LineaTicket> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaTicket> lineas) {
        this.lineas = lineas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "empresa='" + empresa + '\'' +
                ", fecha='" + fecha + '\'' +
                ", numero=" + numero +
                ", hora='" + hora + '\'' +
                '}';
    }
}
