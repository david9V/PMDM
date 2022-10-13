package com.example.prueba2.pruebaIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_act_intent);
        Button bPasarDatos = (Button) findViewById(R.id.bDatos);
        bPasarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanzarIntent(view);
            }
        });


    }

    public void lanzarIntent(View view){
        Intent intent = new Intent(MainActivity.this, DatosActivity.class);
        Bundle b = new Bundle();
        b.putString("Año", "2022");
        b.putString("Mes", "Abril");
        intent.putExtras(b);
        startActivity(intent);
    }

}