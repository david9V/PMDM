package com.example.prueba2.pruebaWidgetsSeleccion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

import java.util.ArrayList;
import java.util.List;

public class PruebaListViewAlumno extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_test2);

        List<Alumno> alumnos = new ArrayList<>();
        Alumno a1 = new Alumno("David");
        Alumno a2 = new Alumno("José");
        //a1.setFoto(new ImageView(this));
        //a2.setFoto(new ImageView(this));
        alumnos.add(a1);
        alumnos.add(a2);



        ArrayAdapter<Alumno> adaptador;

        ListView l = findViewById(R.id.lista);

        adaptador = new ArrayAdapter<>(this, R.layout.fila_alumno, alumnos);

        l.setAdapter(adaptador);
        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView t = findViewById(R.id.eleccion);
        t.setText(adapterView.getItemAtPosition(i).toString());
    }


}

