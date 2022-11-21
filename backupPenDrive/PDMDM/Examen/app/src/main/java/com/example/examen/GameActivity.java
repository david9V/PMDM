package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

public class GameActivity extends AppCompatActivity  implements View.OnClickListener {
    ImageButton volver;

    String f1c1 = "";
    String f1c2 = "";
    String f1c3 = "";
    String f2c1 = "";
    String f2c2 = "";
    String f2c3 = "";
    String f3c1 = "";
    String f3c2 = "";
    String f3c3 = "";

    ImageButton f11;
    ImageButton f12;
    ImageButton f13;
    ImageButton f21;
    ImageButton f22;
    ImageButton f23;
    ImageButton f31;
    ImageButton f32;
    ImageButton f33;

    String u;

    int idOpc [][];

    int turno = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        volver = findViewById(R.id.bVolverJuego);
        volver.setOnClickListener(view -> intentVolver(view));

        Bundle extras = getIntent().getExtras();
        u = extras.getString("usuario");

        idOpc = new int[3][3];
        idOpc[0][0] = R.id.f1c1; idOpc[0][1] = R.id.f1c2;idOpc[0][2] = R.id.f1c3;
        idOpc[1][0] = R.id.f2c1; idOpc[1][1] = R.id.f2c2;idOpc[1][2] = R.id.f2c3;
        idOpc[2][0] = R.id.f3c1; idOpc[2][1] = R.id.f3c2;idOpc[2][2] = R.id.f3c3;

        f11 = findViewById(R.id.f1c1);
        f12 = findViewById(R.id.f1c2);
        f13 = findViewById(R.id.f1c3);
        f21 = findViewById(R.id.f2c1);
        f22 = findViewById(R.id.f2c2);
        f23 = findViewById(R.id.f2c3);
        f31 = findViewById(R.id.f3c1);
        f32 = findViewById(R.id.f3c2);
        f33 = findViewById(R.id.f3c3);



        f11.setOnClickListener(this);
        f12.setOnClickListener(this);
        f13.setOnClickListener(this);
        f21.setOnClickListener(this);
        f22.setOnClickListener(this);
        f23.setOnClickListener(this);
        f31.setOnClickListener(this);
        f32.setOnClickListener(this);
        f33.setOnClickListener(this);


    }

    public void intentVolver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        boolean valido = false;

        switch (id) {
            case R.id.f1c1:
                if (vacio(f1c1)){
                    f11.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f1c1 = "o";
                    valido = true;
                }
                break;
            case R.id.f1c2:
                if (vacio(f1c2)){
                    f12.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f1c2 = "o";
                    valido = true;
                }
                break;
            case R.id.f1c3:
                if (vacio(f1c3)){
                    f13.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f1c3 = "o";
                    valido = true;
                }
                break;
            case R.id.f2c1:
                if (vacio(f2c1)){
                    f21.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f2c1 = "o";
                    valido = true;
                }
                break;
            case R.id.f2c2:
                if (vacio(f2c2)){
                    f22.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f2c2 = "o";
                    valido = true;

                }
                break;
            case R.id.f2c3:
                if (vacio(f2c3)){
                    f23.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f2c3 = "o";
                    valido = true;

                }
                break;
            case R.id.f3c1:
                if (vacio(f3c1)){
                    f31.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f3c1 = "o";
                    valido = true;

                }
                break;
            case R.id.f3c2:
                if (vacio(f3c2)){
                    f32.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f3c2 = "o";
                    valido = true;

                }
                break;
            case R.id.f3c3:
                if (vacio(f3c3)){
                    f33.setBackgroundResource(R.drawable.ic_outline_circle_24);
                    f3c3 = "o";
                    valido = true;

                }
                break;
        }
        if (valido){
            turno++;
            if (turno < 5) elegirMaquina();
        }

        if (comprobarVictoriaJugador()) ganar();
        else if (comprobarVictoriaMaquina()) perder();
        else if (turno == 5) empate();
    }

    public boolean vacio(String s){
        if (s.isEmpty()) return true;
        else return false;
    }

    public boolean comprobarVictoriaJugador(){
        boolean victoria = false;
        //filas
        if (f1c1.equals("o") && f1c2.equals("o") && f1c3.equals("o"))
            victoria = true;
        if (f2c1.equals("o") && f2c2.equals("o") && f2c3.equals("o"))
            victoria = true;
        if (f3c1.equals("o") && f3c2.equals("o") && f3c3.equals("o"))
            victoria = true;

        //columnas
        if (f1c1.equals("o") && f2c1.equals("o") && f3c1.equals("o"))
            victoria = true;
        if (f1c2.equals("o") && f2c2.equals("o") && f3c2.equals("o"))
            victoria = true;
        if (f1c3.equals("o") && f2c3.equals("o") && f3c3.equals("o"))
            victoria = true;

        //diagonales
        if (f1c1.equals("o") && f2c2.equals("o") && f3c3.equals("o"))
            victoria = true;
        if (f1c3.equals("o") && f2c2.equals("o") && f3c1.equals("o"))
            victoria = true;

        return victoria;
    }

    public boolean comprobarVictoriaMaquina(){
        boolean victoria = false;
        //filas
        if (f1c1.equals("x") && f1c2.equals("x") && f1c3.equals("x"))
            victoria = true;
        if (f2c1.equals("x") && f2c2.equals("x") && f2c3.equals("x"))
            victoria = true;
        if (f3c1.equals("x") && f3c2.equals("x") && f3c3.equals("x"))
            victoria = true;

        //columnas
        if (f1c1.equals("x") && f2c1.equals("x") && f3c1.equals("x"))
            victoria = true;
        if (f1c2.equals("x") && f2c2.equals("x") && f3c2.equals("x"))
            victoria = true;
        if (f1c3.equals("x") && f2c3.equals("x") && f3c3.equals("x"))
            victoria = true;

        //diagonales
        if (f1c1.equals("x") && f2c2.equals("x") && f3c3.equals("x"))
            victoria = true;
        if (f1c3.equals("x") && f2c2.equals("x") && f3c1.equals("x"))
            victoria = true;

        return victoria;
    }

    public void ganar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("¡Has ganado!");
        builder.setMessage("¡Felicidades " + u + "!");
        builder.setNegativeButton("Salir", (dialog, which) -> finishAndRemoveTask());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void perder(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Has perdido...");
        builder.setMessage("Buenas suerte la próxima vez " + u);
        builder.setNegativeButton("Salir", (dialog, which) -> finishAndRemoveTask());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void empate(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Has empatado");
        builder.setMessage("Esto no puede quedar así..");
        builder.setNegativeButton("Salir", (dialog, which) -> finishAndRemoveTask());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void elegirMaquina(){
        boolean posCorrecta = false;
        int fila = 0;
        int columna = 0;

        while(!posCorrecta){
            fila = new Random().nextInt(3);
            columna = new Random().nextInt(3);

            ImageButton i = findViewById(idOpc[fila][columna]);
            if (i.getBackground() == null){
                posCorrecta = true;
            }
        }

        ImageButton i = findViewById(idOpc[fila][columna]);
        i.setBackgroundResource(R.drawable.ic_outline_close_24);

        if (fila == 0 && columna == 0) f1c1 = "x";
        if (fila == 0 && columna == 1) f1c2 = "x";
        if (fila == 0 && columna == 2) f1c3 = "x";

        if (fila == 1 && columna == 0) f2c1 = "x";
        if (fila == 1 && columna == 1) f2c2 = "x";
        if (fila == 1 && columna == 2) f2c3 = "x";

        if (fila == 2 && columna == 0) f3c1 = "x";
        if (fila == 2 && columna == 1) f3c2 = "x";
        if (fila == 2 && columna == 2) f3c3 = "x";
    }
}