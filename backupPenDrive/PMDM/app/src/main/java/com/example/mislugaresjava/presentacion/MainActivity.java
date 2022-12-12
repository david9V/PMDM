package com.example.mislugaresjava.presentacion;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mislugaresjava.Aplicacion;
import com.example.mislugaresjava.R;
import com.example.mislugaresjava.RepositorioLugares;
import com.example.mislugaresjava.casos_uso.CasosUsoLugar;

public class MainActivity extends AppCompatActivity {


    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lugares = ((Aplicacion) getApplication()).lugares;
        usoLugar = new CasosUsoLugar(this, lugares);
    }

    public void lanzarVistaLugar(View view){
        usoLugar.mostrar(0);
    }
}
