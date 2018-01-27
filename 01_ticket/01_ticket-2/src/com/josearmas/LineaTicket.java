package com.josearmas;

public class LineaTicket {

    private int uds;
    private String producto;
    private double preciouds;
    private double totalinea;

    //Asociación;
    private Ticket ticket;

    public LineaTicket() {
    }

    public LineaTicket(int uds, String producto, double preciouds, double totalinea) {
        this.uds = uds;
        this.producto = producto;
        this.preciouds = preciouds;
        this.totalinea = totalinea;
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

    public double getPreciouds() {
        return preciouds;
    }

    public void setPreciouds(double preciouds) {
        this.preciouds = preciouds;
    }

    public double getTotalinea() {
        return totalinea;
    }

    public void setTotalinea(double totalinea) {
        this.totalinea = totalinea;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "LineaTicket: " +
                "uds=" + uds +
                ", producto='" + producto + '\'' +
                ", preciouds=" + preciouds +
                ", totalinea=" + totalinea;
    }
}
