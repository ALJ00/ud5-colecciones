package com.josearmas;

public class Averia {

    private String titulo;
    private String descripcion;
    private String fechaApertura;
    private int nivel;

    //Asociación.
    private Tecnico tecnico;

    public Averia() {
    }

    public Averia(String titulo, String descripcion,String fechaApertura, int nivel) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaApertura = fechaApertura;
        this.nivel = nivel;
    }

    public boolean resolverAveria (){

        boolean resuelta = false;
        if(this.tecnico.getNivel()>= this.nivel){
            resuelta = true;
        }
        return resuelta;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "Averia{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaApertura='" + fechaApertura + '\'' +
                ", nivel=" + nivel +
                ", tecnico=" + tecnico +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Averia averia = (Averia) o;

        if (titulo != null ? !titulo.equals(averia.titulo) : averia.titulo != null) return false;
        return tecnico != null ? tecnico.equals(averia.tecnico) : averia.tecnico == null;
    }

    @Override
    public int hashCode() {
        int result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + (tecnico != null ? tecnico.hashCode() : 0);
        return result;
    }
}
