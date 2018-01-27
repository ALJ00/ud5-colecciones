package com.josearmas;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private String fecha;
    private String hora;
    private String empresa="EGIBIDE";
    private double totalticket;
    private int numero;

    //Asociación
    private List<LineaTicket>lineaTickets = new ArrayList<>();

    public Ticket() {
    }

    public Ticket(String fecha, String hora, int numero) {
        this.fecha = fecha;
        this.hora = hora;
        this.numero = numero;
    }

    public void TotalTicket(){
        double total =0;
        for (int i = 0; i < lineaTickets.size(); i++) {
            total = total+lineaTickets.get(i).getTotalinea();
        }

        totalticket = total;

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public double getTotalticket() {
        return totalticket;
    }

    public void setTotalticket(double totalticket) {
        this.totalticket = totalticket;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<LineaTicket> getLineaTickets() {
        return lineaTickets;
    }

    public void setLineaTickets(List<LineaTicket> lineaTickets) {
        this.lineaTickets = lineaTickets;
    }

    @Override
    public String toString() {
        return "Fecha: "+this.fecha+"\n"+
                "Hora: "+this.hora+"\n"+
                "Nº ticket: "+this.numero+"\n"+
                "----------------------------------";
    }
}
