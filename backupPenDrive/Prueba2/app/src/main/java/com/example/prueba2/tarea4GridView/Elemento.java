package com.example.prueba2.tarea4GridView;

public class Elemento {

    private int idImg;
    private String nombre;

    public Elemento(int idImg, String nombre) {
        this.idImg = idImg;
        this.nombre = nombre;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
