package com.example.prueba2.tarea4Spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;
import com.example.prueba2.tarea4GridView.AdaptadorPersonalizado;
import com.example.prueba2.tarea4GridView.Elemento;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_test1);

        List<Elemento> cosas = new ArrayList<>();
        cosas.add(new Elemento(R.drawable.boxeo, "Boxeo"));
        cosas.add(new Elemento(R.drawable.muay_thai, "Muay Thai"));
        cosas.add(new Elemento(R.drawable.jiu_jitsu, "Jiu Jitsu"));
        cosas.add(new Elemento(R.drawable.mma, "MMA"));
        cosas.add(new Elemento(R.drawable.karate, "Karate"));
        cosas.add(new Elemento(R.drawable.judo, "Judo"));
        cosas.add(new Elemento(R.drawable.kung_fu, "Kung-Fu"));
        cosas.add(new Elemento(R.drawable.capoeira, "Capoeira"));

        AdaptadorPersonalizado adaptador;
        adaptador = new AdaptadorPersonalizado(cosas, this);

        Spinner s = findViewById(R.id.spinner);

        s.setAdapter(adaptador);
        s.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView t = findViewById(R.id.eleccion2);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}

