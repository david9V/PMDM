package com.example.prueba2.pruebaWidgetsSeleccion;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

import java.util.ArrayList;
import java.util.List;

public class PruebaListViewAlumno extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_test2);

        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Casa 1", 68518293, "David", R.drawable.alumno2));
        alumnos.add(new Alumno("Casa 1", 68518293, "Pepe", R.drawable.alumno));
        alumnos.add(new Alumno("Casa 1", 68518293, "Marta", R.drawable.alumno2));
        alumnos.add(new Alumno("Casa 1", 68518293, "Marcos", R.drawable.alumno));
        alumnos.add(new Alumno("Casa 1", 68518293, "Pedro", R.drawable.alumno2));

        ListView l;
        l = findViewById(R.id.listaAlumno);
        AdaptadorPersonalizado adaptador = new AdaptadorPersonalizado(alumnos, this);

        l.setAdapter(adaptador);

        l.setOnItemClickListener((parent, view, position, id)->view.animate().rotation(360).setDuration(2000).start());

    }


}

