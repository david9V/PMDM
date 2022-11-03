package com.example.prueba2.pruebaWidgetsSeleccion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prueba2.R;

import java.util.List;

public class AdaptadorPersonalizado extends BaseAdapter {

    private List<Alumno> lista;

    private Context c;

    public AdaptadorPersonalizado(List<Alumno> lista, Context c) {
        this.lista = lista;
        this.c = c;
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
        Alumno alumno = (Alumno) getItem(i);
        view = LayoutInflater.from(c).inflate(R.layout.fila_alumno,null);
        ImageView foto = (ImageView) view.findViewById(R.id.alumnoFoto);
        TextView nom = (TextView) view.findViewById(R.id.alumnoNombre);
        TextView num = (TextView) view.findViewById(R.id.alumnoNum);
        TextView dir = (TextView) view.findViewById(R.id.alumnoDir);

        foto.setImageResource(alumno.getFoto());
        nom.setText(alumno.getNomAp());
        num.setText((int) alumno.getTlf());
        dir.setText(alumno.getDireccion());

        return view;
    }
}