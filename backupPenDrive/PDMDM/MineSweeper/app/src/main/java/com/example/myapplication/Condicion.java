package com.example.myapplication;

public class Condicion {

    boolean arribaDerecha;
    boolean arribaIzquierda;
    boolean abajoDerecha;
    boolean abajoIzquierda;
    boolean derecha;
    boolean izquierda;
    boolean arriba;
    boolean abajo;

    public Condicion() {
        this.arribaDerecha = false;
        this.arribaIzquierda = false;
        this.abajoDerecha = false;
        this.abajoIzquierda = false;
        this.derecha = false;
        this.izquierda = false;
        this.arriba = false;
        this.abajo = false;
    }

    public boolean isArribaDerecha() {
        return arribaDerecha;
    }

    public void setArribaDerecha(boolean arribaDerecha) {
        this.arribaDerecha = arribaDerecha;
    }

    public boolean isArribaIzquierda() {
        return arribaIzquierda;
    }

    public void setArribaIzquierda(boolean arribaIzquierda) {
        this.arribaIzquierda = arribaIzquierda;
    }

    public boolean isAbajoDerecha() {
        return abajoDerecha;
    }

    public void setAbajoDerecha(boolean abajoDerecha) {
        this.abajoDerecha = abajoDerecha;
    }

    public boolean isAbajoIzquierda() {
        return abajoIzquierda;
    }

    public void setAbajoIzquierda(boolean abajoIzquierda) {
        this.abajoIzquierda = abajoIzquierda;
    }

    public boolean isDerecha() {
        return derecha;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    public boolean isArriba() {
        return arriba;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }

    public boolean isAbajo() {
        return abajo;
    }

    public void setAbajo(boolean abajo) {
        this.abajo = abajo;
    }

    public void reset(){
        this.arribaDerecha = false;
        this.arribaIzquierda = false;
        this.abajoDerecha = false;
        this.abajoIzquierda = false;
        this.derecha = false;
        this.izquierda = false;
        this.arriba = false;
        this.abajo = false;
    }
}
