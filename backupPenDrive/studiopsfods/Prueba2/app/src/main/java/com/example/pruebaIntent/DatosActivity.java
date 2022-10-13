package com.example.pruebaIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

public class DatosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Bundle extras = getIntent().getExtras();
        int anio = extras.getInt("Año");
        String mes = extras.getString("Mes");
        Toast.makeText(this, "Año: " + anio + "Mes: " + mes, Toast.LENGTH_SHORT).show();

    }

}
