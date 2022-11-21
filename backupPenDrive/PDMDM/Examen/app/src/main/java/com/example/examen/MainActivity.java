package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usuario;
    Button jugar;
    Button reglas;
    String u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.editUsuario);
        jugar = findViewById(R.id.bJugar);
        reglas = findViewById(R.id.bReglas);


        jugar.setOnClickListener(view -> intentJuego(view));
        reglas.setOnClickListener(view -> intentReglas(view));

    }

    public void intentJuego(View view){
        u = usuario.getText().toString();
        if (!u.isEmpty()){
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            Bundle b = new Bundle();
            b.putString("usuario", u);
            intent.putExtras(b);
            startActivity(intent);
        } else Toast.makeText(this, "Introduzca un usuario, por favor :)", Toast.LENGTH_SHORT).show();
    }

    public void intentReglas(View view){
        u = usuario.getText().toString();
        if (!u.isEmpty()){
            Intent intent = new Intent(MainActivity.this, RulesActivity.class);
            Bundle b = new Bundle();
            b.putString("usuario", u);
            intent.putExtras(b);
            startActivity(intent);
        } else Toast.makeText(this, "Introduzca un usuario, por favor :)", Toast.LENGTH_SHORT).show();
    }
}