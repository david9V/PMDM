package com.example.prueba2.hangmanGame;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

import java.util.Arrays;
import java.util.Random;

public class RunningActivity extends AppCompatActivity {
    ImageView fase1;
    ImageView fase2;
    ImageView fase3;
    ImageView fase4;
    ImageView fase5;
    ImageView fase6;
    ImageView fase7;
    ImageView fase8;

    String[] palabras;

    char[] letras;
    char[] oculto;

    TextView adivinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangman2);
        Bundle extras = getIntent().getExtras();
        palabras = extras.getStringArray("palabras");

        fase1 = findViewById(R.id.fase1);
        fase2 = findViewById(R.id.fase2);
        fase3 = findViewById(R.id.fase3);
        fase4 = findViewById(R.id.fase4);
        fase5 = findViewById(R.id.fase5);
        fase6 = findViewById(R.id.fase6);
        fase7 = findViewById(R.id.fase7);
        fase8 = findViewById(R.id.fase8);
        adivinar = findViewById(R.id.adivinar);

        preparar();

        escogerPalabra();
        adivinar.setLetterSpacing(1);
        adivinar.setText(convertirString());
    }

    public void preparar(){
        fase1.setVisibility(View.INVISIBLE);
        fase2.setVisibility(View.INVISIBLE);
        fase3.setVisibility(View.INVISIBLE);
        fase4.setVisibility(View.INVISIBLE);
        fase5.setVisibility(View.INVISIBLE);
        fase6.setVisibility(View.INVISIBLE);
        fase7.setVisibility(View.INVISIBLE);
        fase8.setVisibility(View.INVISIBLE);
    }

    public void escogerPalabra(){
        int n = new Random().nextInt(8);
        String p = palabras[n];
        letras = p.toCharArray();
        oculto = new char[letras.length];
        Arrays.fill(oculto, '_');
    }

    public String convertirString(){
        String p = String.valueOf(oculto);
        return p;
    }
}
