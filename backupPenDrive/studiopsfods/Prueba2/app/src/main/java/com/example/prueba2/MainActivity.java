package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView texto1;
    TextView texto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        texto1 = (TextView)findViewById(R.id.textView);
        texto1.setOnClickListener(this);
        texto2 = (TextView)findViewById(R.id.textView2);
        texto2.setOnClickListener(this);

        Button boton = (Button) findViewById(R.id.button2);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Se ha hecho click en el botón de la esquina", Toast.LENGTH_SHORT).show();
                Log.i("CICLO VIDA", "metodo onClick");
            }
        });
    }

    @Override
    public void onClick(View view) { // forma 3
        int id = view.getId();
        if (id == R.id.textView){
            Toast.makeText(MainActivity.this, "Se ha hecho click en el texto 'Hola'", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(MainActivity.this, "Se ha hecho click en el texto 'Hello David'", Toast.LENGTH_LONG).show();
        }
    }

    public void ejemplo1(View view){ // forma 1
        Toast.makeText(MainActivity.this, "Se ha hecho click en el botón", Toast.LENGTH_SHORT).show();
    }





}