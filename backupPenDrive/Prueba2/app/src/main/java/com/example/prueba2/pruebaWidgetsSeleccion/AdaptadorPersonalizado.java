package com.example.prueba2.pruebaWidgetsSeleccion;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AdaptadorPersonalizado extends ArrayAdapter<String> {
    public AdaptadorPersonalizado(Context ctx,
                                  int txtViewResourceId, String[] objects) {
        super(ctx, txtViewResourceId, objects);
    }
}
