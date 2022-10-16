package com.example.prueba2.rockpaperscissors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;
import com.example.prueba2.pruebaIntent.DatosActivity;

public class MainActivity extends AppCompatActivity {
    ImageView fondo;
    Button start;
    TextView intro;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rockpaperscissors);
        fondo = findViewById(R.id.icono);
        start = findViewById(R.id.bStart);
        start.setVisibility(View.GONE);
        start.setText(R.string.start);
        intro = findViewById(R.id.textoIntro);
        intro.setVisibility(View.GONE);
        intro.setText(R.string.introJuegoGoku);

        cargar();

        start.setOnClickListener(view -> lanzarIntent(view));
    }

    public void cargar(){ //muestra icono y tras 3s da la opción de empezar el juego
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fondo.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
                intro.setVisibility(View.VISIBLE);
            }
        }, 2000); //SEGUNDOS (1000 = 1s)
    }

    public void lanzarIntent(View view){
        Intent intent = new Intent(MainActivity.this, RunningActivity.class);
        startActivity(intent);
    }
}



/*
new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   //CODIGO CUALQUIERA
                }
            }, 3000); //SEGUNDOS (1000 = 1s)
 */
