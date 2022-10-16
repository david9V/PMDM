package com.example.prueba2.elementosGraficos;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

public class MainActivity extends AppCompatActivity{
    ImageView jesse;
    ImageView walter;
    ImageView walterMalo;
    ToggleButton sombrero;
    ImageButton llamar;
    ImageButton llamando;
    ImageButton colgar;
    boolean llamada = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_el1);

        jesse = findViewById(R.id.jesse1);
        walter = findViewById(R.id.walterBueno);
        walterMalo = findViewById(R.id.walterMalo);
        llamar = findViewById(R.id.bLlamar);
        llamando = findViewById(R.id.bLlamando);
        colgar = findViewById(R.id.bColgar);
        sombrero = findViewById(R.id.toggleButton);
        sombrero.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) cambiarImagen(jesse, R.drawable.jesse2);
                else cambiarImagen(jesse, R.drawable.jesse1);
            }
        });

        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarLlamada();
            }
        });

        colgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarLlamada();
            }
        });


    }

    public void cambiarImagen(ImageView i ,int id){
        i.setImageResource(id);
    }

    public void cambiarLlamada(){
         if (!llamada){
            llamada = true;
            llamar.setVisibility(View.GONE);
            llamando.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    llamando.setVisibility(View.GONE);
                    colgar.setVisibility(View.VISIBLE);
                    walter.setVisibility(View.GONE);
                    walterMalo.setVisibility(View.VISIBLE);
                }
            }, 3000);

        } else{
            llamada = false;
            llamando.setVisibility(View.GONE);
            colgar.setVisibility(View.GONE);
            llamar.setVisibility(View.VISIBLE);
            walter.setVisibility(View.VISIBLE);
            walterMalo.setVisibility(View.GONE);
        }
    }


}

//sym_action_call sym_call_outgoing sym_call_missed