package com.example.prueba2.hangmanGame;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.prueba2.R;

public class MainActivity extends AppCompatActivity {
    ImageView intro;
    ImageView loading;
    Button bAnimal;
    Button bDeporte;
    Button bRopa;
    Button bHerramienta;
    Button bPais;
    Button bComida;


    TextView textoIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangman);
        intro = findViewById(R.id.viewIntro);
        intro.setVisibility(View.VISIBLE);
        loading = findViewById(R.id.viewLoading);
        loading.setVisibility(View.VISIBLE);
        Glide.with(this).load(R.drawable.hangman_intro).into(intro);
        Glide.with(this).load(R.drawable.loading).into(loading);

        bAnimal = findViewById(R.id.bAnimales);
        bDeporte = findViewById(R.id.bDeporte);
        bRopa = findViewById(R.id.bRopa);
        bHerramienta = findViewById(R.id.bHerramientas);
        bPais = findViewById(R.id.bPaises);
        bComida = findViewById(R.id.bComida);

        textoIntro = findViewById(R.id.infoHangman);


        cargar();
    }


    public void cargar(){ //muestra icono y tras 3s da la opción de empezar el juego
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intro.setVisibility(View.GONE);
                loading.setVisibility(View.GONE);
                textoIntro.setVisibility(View.VISIBLE);
                textoIntro.setText(R.string.introHangman);

                bAnimal.setVisibility(View.VISIBLE);
                bDeporte.setVisibility(View.VISIBLE);
                bRopa.setVisibility(View.VISIBLE);
                bHerramienta.setVisibility(View.VISIBLE);
                bPais.setVisibility(View.VISIBLE);
                bComida.setVisibility(View.VISIBLE);
            }
        }, 6000); //SEGUNDOS (1000 = 1s)
    }
}
