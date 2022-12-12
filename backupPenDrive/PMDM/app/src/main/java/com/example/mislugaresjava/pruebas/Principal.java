package com.example.mislugaresjava.pruebas;

import com.example.mislugaresjava.LugaresLista;

class Principal {
    public static void main(String[] main) {
        LugaresLista lugares = new LugaresLista();
        for (int i=0; i<lugares.tamaño(); i++) {
            System.out.println(lugares.elemento(i).toString());
        }
    }
}

