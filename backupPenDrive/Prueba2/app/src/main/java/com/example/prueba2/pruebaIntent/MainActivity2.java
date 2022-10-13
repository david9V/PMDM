package com.example.prueba2.pruebaIntent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;


public class MainActivity2 extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_act_intent);
        Button bPasarDatos = (Button) findViewById(R.id.bDatos);
        bPasarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createLlamada(view);
            }
        });


    }

    public void createLlamada(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
    }

}