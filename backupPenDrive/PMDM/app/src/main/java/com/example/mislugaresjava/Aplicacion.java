package com.example.mislugaresjava;

import android.app.Application;

public class Aplicacion extends Application {

    public RepositorioLugares lugares = new LugaresLista();
    @Override public void onCreate() {
        super.onCreate();
    }
}

