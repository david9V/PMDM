package com.example.prueba2.actividadInternacionalizacion;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

public class MainActivity extends AppCompatActivity {
    TextView titulo;
    TextView eNombre;
    TextView eApellido;
    TextView eEmail;
    TextView eClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_internacionalizacion);
        titulo = findViewById(R.id.etTitulo);
        eNombre = findViewById(R.id.etNombre);
        eApellido = findViewById(R.id.etApellido);
        eEmail = findViewById(R.id.etEmail);
        eClave = findViewById(R.id.etClave);

        titulo.setText(R.string.intro);
        eNombre.setText(R.string.nombre);
        eApellido.setText(R.string.apellidos);
        eEmail.setText(R.string.email);
        eClave.setText(R.string.password);
    }
}
