package com.example.prueba2.pruebaWidgetsSeleccion;

public class Alumno {
    private String direccion;

    private long tlf;

    private String nomAp;

    private int foto;

    public Alumno(String direccion, long tlf, String nomAp, int foto) {
        this.direccion = direccion;
        this.tlf = tlf;
        this.nomAp = nomAp;
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTlf() {
        return tlf;
    }

    public void setTlf(long tlf) {
        this.tlf = tlf;
    }

    public String getNomAp() {
        return nomAp;
    }

    public void setNomAp(String nomAp) {
        this.nomAp = nomAp;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

