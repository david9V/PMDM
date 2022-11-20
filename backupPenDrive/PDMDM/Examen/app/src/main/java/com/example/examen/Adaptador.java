package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador {
    private List<Elemento> lista;

    private Context context;

    public AdaptadorPersonalizado(List<Elemento> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Elemento el = (Elemento) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.ad_tarea4,null);
        ImageView foto = (ImageView) view.findViewById(R.id.imgTarea4);
        TextView nom = (TextView) view.findViewById(R.id.textoTarea4);

        foto.setBackgroundResource(el.getIdImg());
        nom.setText(el.getNombre());


        return view;
    }
}
