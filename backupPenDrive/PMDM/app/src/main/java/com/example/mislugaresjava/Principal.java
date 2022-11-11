package com.example.mislugaresjava;

class Principal {
    public static void main(String[] main) {
        LugaresLista lugares = new LugaresLista();
        for (int i=0; i<lugares.tamaño(); i++) {
            System.out.println(lugares.elemento(i).toString());
        }
    }
}

