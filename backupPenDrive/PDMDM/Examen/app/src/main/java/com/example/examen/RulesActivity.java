package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {
    ImageButton volver;
    TextView normasTitulo;
    TextView normas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        Bundle extras = getIntent().getExtras();
        String u = extras.getString("usuario");

        volver = findViewById(R.id.bVolverJuego);
        volver.setOnClickListener(view -> intentVolver(view));


        normasTitulo = findViewById(R.id.normasTitulo);
        normasTitulo.setText("Bienvenido a las normas " + u);

        normas = findViewById(R.id.textoNormas);
        normas.setText(R.string.normas);
    }

    public void intentVolver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}