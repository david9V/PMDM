package com.example.mislugaresjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPrueba extends AppCompatActivity implements View.OnClickListener {
    Button acercaDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        acercaDe = findViewById(R.id.bAcercaDe);
        acercaDe.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.bAcercaDe){
            Intent i = new Intent(this, AcercaDeActivity.class);
            startActivity(i);
        }
    }
}