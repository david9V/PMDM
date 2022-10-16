package com.example.prueba2.prueba1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

import java.util.Random;

public class RunningActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textoGoku;
    TextView tcJugador;
    TextView tcGoku;

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


    int pJugador = 0;
    int pGoku = 0;
    boolean flag = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rps2);
        textoGoku = findViewById(R.id.textoGoku);
        textoGoku.setText(R.string.goku_waiting);
        tcJugador = findViewById(R.id.contadorJugador);
        tcGoku = findViewById(R.id.contadorGoku);
        tcJugador.setText(String.valueOf(pJugador));
        tcGoku.setText(String.valueOf(pGoku));

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
            flag = true;
            switch (id){
                case R.id.bScissors:
                    animarBoton(tijeras);
                    desaparecer(piedra);
                    desaparecer(papel);
                    new Handler().postDelayed(() -> textoGoku.setText(calcularResultadoFinal(calcularResultadoTijeras(calcularTiradaDeGoku()))), 1500);
                    break;
                case R.id.bRock:
                    animarBoton(piedra);
                    desaparecer(tijeras);
                    desaparecer(papel);
                    new Handler().postDelayed(() -> textoGoku.setText(calcularResultadoFinal(calcularResultadoPiedra(calcularTiradaDeGoku()))), 1500);
                    break;
                case R.id.bPaper:
                    animarBoton(papel);
                    desaparecer(piedra);
                    desaparecer(tijeras);
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
            aparecer(piedraGoku);
            tijerasGoku.setVisibility(View.INVISIBLE);
            papelGoku.setVisibility(View.INVISIBLE);
        } else if (n == 1){
            res = "Papel";
            piedraGoku.setVisibility(View.INVISIBLE);
            tijerasGoku.setVisibility(View.INVISIBLE);
            aparecer(papelGoku);
        } else if (n == 2){
            res = "Tijeras";
            piedraGoku.setVisibility(View.INVISIBLE);
            aparecer(tijerasGoku);
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
            new Handler().postDelayed(() -> perder(), 500);
        } else if (n == 0){
            new Handler().postDelayed(() -> empatar(), 500);
        } else{
            new Handler().postDelayed(() -> ganar(), 500);
        }
        return res;
    }

    public void ganar(){
        gokuDrip.setVisibility(View.INVISIBLE);
        taMal.setVisibility(View.VISIBLE);
        taBien.setVisibility(View.INVISIBLE);
        mondongo.setVisibility(View.INVISIBLE);
        pJugador++;
        animarNumero(tcJugador);
        tcJugador.setText(String.valueOf(pJugador));
        if (pJugador == 3){
            finBueno();
        }
    }

    public void perder(){
        gokuDrip.setVisibility(View.INVISIBLE);
        taMal.setVisibility(View.INVISIBLE);
        taBien.setVisibility(View.INVISIBLE);
        mondongo.setVisibility(View.VISIBLE);
        pGoku++;
        animarNumero(tcGoku);
        tcGoku.setText(String.valueOf(pGoku));
        if (pGoku == 3){
            finMalo();
        }
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
        flag = false;
    }

    public void animarBoton(ImageButton b){
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        b.startAnimation(animation);
    }

    public void desaparecer(ImageButton b){
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.fade2);
        b.startAnimation(animation);
        b.startAnimation(animation2);
    }

    public void aparecer(ImageView b){
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        b.startAnimation(animation);
    }

    public void animarNumero(TextView t){
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce2);
        t.startAnimation(animation);
    }

    public void finBueno(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("¡Has ganado!");
        builder.setMessage("¡Felicidades! Has ganado a goku, ¿quieres jugar de nuevo o salir?");
        builder.setPositiveButton("Jugar de nuevo",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pJugador = 0;
                        pGoku = 0;
                        tcJugador.setText(String.valueOf(pJugador));
                        tcGoku.setText(String.valueOf(pGoku));
                    }
                });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAndRemoveTask();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void finMalo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Has perdido...");
        builder.setMessage("No te preocupes, la próxima vez será... Es que goku a piedra, papel o tijeras es de los mejores.");
        builder.setPositiveButton("Intentar de nuevo",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        pJugador = 0;
                        pGoku = 0;
                        tcJugador.setText(String.valueOf(pJugador));
                        tcGoku.setText(String.valueOf(pGoku));
                    }
                });
        builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAndRemoveTask();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
