package com.example.prueba2.pruebaWidgetsSeleccion;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

public class PruebaSpinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_test1);

        String[] elementos = {"Destornillador", "Cuerda", "Gancho", "Pelota", "Saco"};

        ArrayAdapter<String> adaptador;

        Spinner s = findViewById(R.id.spinner);

        adaptador = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, elementos);

        s.setAdapter(adaptador);
        s.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView t = findViewById(R.id.eleccion2);
        t.setText("Has elegido: " + adapterView.getItemAtPosition(i).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        TextView t = findViewById(R.id.eleccion2);
        t.setText("No has elegido nada");
    }
}

