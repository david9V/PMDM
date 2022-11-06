package com.example.prueba2.tarea4GridView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private GridView g;
    private AdaptadorPersonalizado adaptador;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarea4_1);

        List<Elemento> cosas = new ArrayList<>();
        cosas.add(new Elemento(R.drawable.boxeo, "Boxeo"));
        cosas.add(new Elemento(R.drawable.muay_thai, "Muay Thai"));
        cosas.add(new Elemento(R.drawable.jiu_jitsu, "Jiu Jitsu"));
        cosas.add(new Elemento(R.drawable.mma, "MMA"));
        cosas.add(new Elemento(R.drawable.karate, "Karate"));
        cosas.add(new Elemento(R.drawable.judo, "Judo"));
        cosas.add(new Elemento(R.drawable.kung_fu, "Kung-Fu"));
        cosas.add(new Elemento(R.drawable.capoeira, "Capoeira"));

        adaptador = new AdaptadorPersonalizado(cosas, this);
        g = findViewById(R.id.gridTarea4);
        g.setAdapter(adaptador);
        g.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Elemento el = (Elemento) adapterView.getItemAtPosition(i);
        Intent intent = new Intent(this, IntentActivity.class);
        intent.putExtra("Elemento", el.getIdImg());
        intent.putExtra("Nombre", el.getNombre());
        startActivity(intent);
    }
}
