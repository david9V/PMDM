package com.example.prueba2.tarea4Spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba2.R;
import com.example.prueba2.tarea4GridView.Elemento;

import java.util.List;

public class AdaptadorPersonalizado extends BaseAdapter {

    private List<com.example.prueba2.tarea4GridView.Elemento> lista;

    private Context context;

    public AdaptadorPersonalizado(List<com.example.prueba2.tarea4GridView.Elemento> lista, Context context) {
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
        com.example.prueba2.tarea4GridView.Elemento el = (Elemento) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.ad_tarea4,null);
        ImageView foto = (ImageView) view.findViewById(R.id.imgTarea4);
        TextView nom = (TextView) view.findViewById(R.id.textoTarea4);

        foto.setBackgroundResource(el.getIdImg());
        nom.setText(el.getNombre());


        return view;
    }
}