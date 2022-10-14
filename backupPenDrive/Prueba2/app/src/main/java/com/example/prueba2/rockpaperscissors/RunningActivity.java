package com.example.prueba2.rockpaperscissors;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

import java.util.Random;

public class RunningActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textoGoku;

    ImageButton piedra;
    ImageButton papel;
    ImageButton tijeras;

    ImageView piedraGoku;
    ImageView tijerasGoku;
    ImageView papelGoku;

    ImageView taBien;
    ImageView taMal;
    ImageView mondongo;
    ImageView gokuDrip;

    boolean flag = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rps2);
        textoGoku = findViewById(R.id.textoGoku);
        textoGoku.setText(R.string.goku_waiting);

        piedra = findViewById(R.id.bRock);
        papel = findViewById(R.id.bPaper);
        tijeras = findViewById(R.id.bScissors);

        piedraGoku = findViewById(R.id.piedraGoku);
        tijerasGoku = findViewById(R.id.tijerasGoku);
        papelGoku = findViewById(R.id.papelGoku);

        taBien = findViewById(R.id.taBien);
        taMal = findViewById(R.id.taMal);
        mondongo = findViewById(R.id.mondongo);
        gokuDrip = findViewById(R.id.gokuDrip);

        piedra.setOnClickListener(this);
        papel.setOnClickListener(this);
        tijeras.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (!flag){
            switch (id){
                case R.id.bScissors:
                    new Handler().postDelayed(() -> textoGoku.setText(calcularResultadoFinal(calcularResultadoTijeras(calcularTiradaDeGoku()))), 1500);
                    break;
                case R.id.bRock:
                    new Handler().postDelayed(() -> textoGoku.setText(calcularResultadoFinal(calcularResultadoPiedra(calcularTiradaDeGoku()))), 1500);
                    break;
                case R.id.bPaper:
                    new Handler().postDelayed(() -> textoGoku.setText(calcularResultadoFinal(calcularResultadoPapel(calcularTiradaDeGoku()))), 1500);
                    break;
            }
            new Handler().postDelayed(() -> reset(), 3500);

        }

    }

    public String calcularTiradaDeGoku(){
        int n = new Random().nextInt(3);
        String res = "";
        if (n == 0){
            res = "Piedra";
            piedraGoku.setVisibility(View.VISIBLE);
            tijerasGoku.setVisibility(View.INVISIBLE);
            papelGoku.setVisibility(View.INVISIBLE);
        } else if (n == 1){
            res = "Papel";
            piedraGoku.setVisibility(View.INVISIBLE);
            tijerasGoku.setVisibility(View.INVISIBLE);
            papelGoku.setVisibility(View.VISIBLE);
        } else if (n == 2){
            res = "Tijeras";
            piedraGoku.setVisibility(View.INVISIBLE);
            tijerasGoku.setVisibility(View.VISIBLE);
            papelGoku.setVisibility(View.INVISIBLE);
        }
        return res;
    }

    public int calcularResultadoTijeras(String tiradaGoku){
        int res = 0;
        if (tiradaGoku == "Piedra"){
            res = -1;
        } else if (tiradaGoku == "Tijeras"){
            res = 0;
        } else if (tiradaGoku == "Papel"){
            res = 1;
        }
        return res;
    }

    public int calcularResultadoPapel(String tiradaGoku){
        int res = 0;
        if (tiradaGoku == "Piedra"){
            res = 1;
        } else if (tiradaGoku == "Tijeras"){
            res = -1;
        } else if (tiradaGoku == "Papel"){
            res = 0;
        }
        return res;
    }

    public int calcularResultadoPiedra(String tiradaGoku){
        int res = 0;
        if (tiradaGoku == "Piedra"){
            res = 0;
        } else if (tiradaGoku == "Tijeras"){
            res = 1;
        } else if (tiradaGoku == "Papel"){
            res = -1;
        }
        return res;
    }

    public String calcularResultadoFinal(int n){
        String res = "";
        if (n == -1){
            res = "Derrota";
            perder();
        } else if (n == 0){
            res = "Empate";
            empatar();
        } else{
            res = "Victoria";
            ganar();
        }
        return res;
    }

    public void ganar(){
        gokuDrip.setVisibility(View.INVISIBLE);
        taMal.setVisibility(View.VISIBLE);
        taBien.setVisibility(View.INVISIBLE);
        mondongo.setVisibility(View.INVISIBLE);
    }

    public void perder(){
        gokuDrip.setVisibility(View.INVISIBLE);
        taMal.setVisibility(View.INVISIBLE);
        taBien.setVisibility(View.INVISIBLE);
        mondongo.setVisibility(View.VISIBLE);
    }

    public void empatar(){
        gokuDrip.setVisibility(View.INVISIBLE);
        taMal.setVisibility(View.INVISIBLE);
        taBien.setVisibility(View.VISIBLE);
        mondongo.setVisibility(View.INVISIBLE);
    }

    public void reset(){
        gokuDrip.setVisibility(View.VISIBLE);
        taMal.setVisibility(View.INVISIBLE);
        taBien.setVisibility(View.INVISIBLE);
        mondongo.setVisibility(View.INVISIBLE);
        textoGoku.setText(R.string.goku_waiting2);
        piedraGoku.setVisibility(View.INVISIBLE);
        tijerasGoku.setVisibility(View.INVISIBLE);
        papelGoku.setVisibility(View.INVISIBLE);
        flag = true;
    }
}
