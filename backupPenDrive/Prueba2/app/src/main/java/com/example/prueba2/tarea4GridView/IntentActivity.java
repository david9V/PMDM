package com.example.prueba2.tarea4GridView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

public class IntentActivity extends AppCompatActivity {

    ImageView img;
    TextView texto;
    ImageButton atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagen_sola);

        img = findViewById(R.id.imagenSola);
        texto = findViewById(R.id.textoSolo);
        atras = findViewById(R.id.bAtras);

        int id = getIntent().getIntExtra("Elemento", 0);
        String eleccion = getIntent().getStringExtra("Nombre");
        img.setBackgroundResource(id);
        texto.setText("Ha elegido: " + eleccion);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}