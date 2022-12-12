package com.example.mislugaresjava.pruebas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mislugaresjava.R;

public class MainPrueba extends AppCompatActivity implements View.OnClickListener {
    Button acercaDe;
    Button salir;
    Button preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        acercaDe = findViewById(R.id.bAcercaDe);
        acercaDe.setOnClickListener(this);
        salir = findViewById(R.id.bSalir);
        salir.setOnClickListener(this);
        preferencias = findViewById(R.id.bPreferencias);
        preferencias.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.bAcercaDe){
            Intent i = new Intent(this, AcercaDeActivity.class);
            startActivity(i);
        }
        if (id == R.id.bSalir){
            finish();
        }
        if (id == R.id.bPreferencias){
            Intent i = new Intent(this, PreferenciasActivity.class);
            startActivity(i);
        }
    }
}