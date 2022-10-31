package com.example.prueba2.pruebaWidgetsSeleccion;

import android.widget.ImageView;

public class Alumno {
    String nombre;
    ImageView foto;

    public Alumno(String nombre, ImageView foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ImageView getFoto() {
        return foto;
    }

    public void setFoto(ImageView foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Alumno:" + nombre;
    }
}
