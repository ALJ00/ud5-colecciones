package com.josearmas;

public class LineaTicket {

    private int uds;
    private String producto;
    private int importe;
    private double total;

    //Asociacion
    private Ticket ticket;

    public LineaTicket() {

    }

    public void totalLinea(){
        this.total = this.uds*this.importe;
    }

    public int getUds() {
        return uds;
    }

    public void setUds(int uds) {
        this.uds = uds;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
