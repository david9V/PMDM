package com.example.mislugaresdavid;

import android.app.Application;

import com.example.mislugaresdavid.datos.LugaresBD;
import com.example.mislugaresdavid.modelo.GeoPunto;
import com.example.mislugaresdavid.presentacion.AdaptadorLugaresBD;

public class Aplicacion extends Application {

    public LugaresBD lugares;
    public AdaptadorLugaresBD adaptador;
    public GeoPunto posicionActual = new GeoPunto(0.0, 0.0);

    @Override public void onCreate() {
        super.onCreate();
        lugares = new LugaresBD(this);
        adaptador = new AdaptadorLugaresBD(lugares, lugares.extraeCursor());
    }
   /* @Override public void onCreate() {
        super.onCreate();
        lugares.añadeEjemplos();
    }*/


/*    public LugaresLista getLugares() {
        return lugares;
    }*/
}
