package com.example.prueba2.tarea4GridView;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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


        g = findViewById(R.id.gridTarea4);
        adaptador = new AdaptadorPersonalizado(cosas, this);

    }

}
