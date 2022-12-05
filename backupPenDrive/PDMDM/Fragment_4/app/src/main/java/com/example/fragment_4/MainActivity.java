package com.example.fragment_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnControlesFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new ControlesFragment())
                .commit();
    }

    @Override
    public void botonColorClicked(String color) {
        Toast.makeText(this, "Estoy en el activity color rojo", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void botonTextoClicked(String texto) {
        Toast.makeText(this, "Estoy en el activity textoooo hola", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mensaje(String texto) {

    }
}