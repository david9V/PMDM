package com.example.prueba2.wordle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.prueba2.R;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*
    Trabajo con un textview y le voy asignando las id's que tengo en un array bidimensional, donde
    previamente he guardado todos los id's de todos los textview del layout. Mientras se va escribiendo o borrando se van sumando o restando los indices respectivamente.
    Al darle al enter a parte de hacer el checkeo de las letras también se sube el indice de las filas
     */
    int idRecuadros[][];

    int idFila1[];
    int idFila2[];
    int idFila3[];
    int idFila4[];
    int idFila5[];
    int idFila6[];

    int filaActual = 0;
    int columnaActual = 0;

    Button bA;
    Button bB;
    Button bC;
    Button bD;
    Button bE;
    Button bF;
    Button bG;
    Button bH;
    Button bI;
    Button bJ;
    Button bK;
    Button bL;
    Button bM;
    Button bN;
    Button bÑ;
    Button bO;
    Button bP;
    Button bQ;
    Button bR;
    Button bS;
    Button bT;
    Button bU;
    Button bV;
    Button bW;
    Button bX;
    Button bY;
    Button bZ;
    Button bEnviar;
    Button bBorrar;

    TextView cuadroLetra;

    String palabra;
    char[] letrasPalabra;
    int posicionCorrecta = 0;
    int aciertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordle);

        bA = findViewById(R.id.bA);
        bB = findViewById(R.id.bB);
        bC = findViewById(R.id.bCC);
        bD = findViewById(R.id.bD);
        bE = findViewById(R.id.bE);
        bF = findViewById(R.id.bF);
        bG = findViewById(R.id.bG);
        bH = findViewById(R.id.bH);
        bI = findViewById(R.id.bI);
        bJ = findViewById(R.id.bJ);
        bK = findViewById(R.id.bK);
        bL = findViewById(R.id.bL);
        bM = findViewById(R.id.bM);
        bN = findViewById(R.id.bN);
        bÑ = findViewById(R.id.bÑ);
        bO = findViewById(R.id.bO);
        bP = findViewById(R.id.bP);
        bQ = findViewById(R.id.bQ);
        bR = findViewById(R.id.bR);
        bS = findViewById(R.id.bS);
        bT = findViewById(R.id.bT);
        bU = findViewById(R.id.bU);
        bV = findViewById(R.id.bV);
        bW = findViewById(R.id.bW);
        bX = findViewById(R.id.bX);
        bY = findViewById(R.id.bY);
        bZ = findViewById(R.id.bZ);
        bEnviar = findViewById(R.id.bEnviar);
        bBorrar = findViewById(R.id.bBorrar);

        bA.setOnClickListener(this);
        bB.setOnClickListener(this);
        bC.setOnClickListener(this);
        bD.setOnClickListener(this);
        bE.setOnClickListener(this);
        bF.setOnClickListener(this);
        bG.setOnClickListener(this);
        bH.setOnClickListener(this);
        bI.setOnClickListener(this);
        bJ.setOnClickListener(this);
        bK.setOnClickListener(this);
        bL.setOnClickListener(this);
        bM.setOnClickListener(this);
        bN.setOnClickListener(this);
        bÑ.setOnClickListener(this);
        bO.setOnClickListener(this);
        bP.setOnClickListener(this);
        bQ.setOnClickListener(this);
        bR.setOnClickListener(this);
        bS.setOnClickListener(this);
        bT.setOnClickListener(this);
        bU.setOnClickListener(this);
        bV.setOnClickListener(this);
        bW.setOnClickListener(this);
        bX.setOnClickListener(this);
        bY.setOnClickListener(this);
        bZ.setOnClickListener(this);
        bEnviar.setOnClickListener(this);
        bBorrar.setOnClickListener(this);

        rellenarIds();
        escogerPalabra();
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.bA:
                añadirLetra(bA);
                break;
            case R.id.bB:
                añadirLetra(bB);
                break;
            case R.id.bCC:
                añadirLetra(bC);
                break;
            case R.id.bD:
                añadirLetra(bD);
                break;
            case R.id.bE:
                añadirLetra(bE);
                break;
            case R.id.bF:
                añadirLetra(bF);
                break;
            case R.id.bG:
                añadirLetra(bG);
                break;
            case R.id.bH:
                añadirLetra(bH);
                break;
            case R.id.bI:
                añadirLetra(bI);
                break;
            case R.id.bJ:
                añadirLetra(bJ);
                break;
            case R.id.bK:
                añadirLetra(bK);
                break;
            case R.id.bL:
                añadirLetra(bL);
                break;
            case R.id.bM:
                añadirLetra(bM);
                break;
            case R.id.bN:
                añadirLetra(bN);
                break;
            case R.id.bÑ:
                añadirLetra(bÑ);
                break;
            case R.id.bO:
                añadirLetra(bO);
                break;
            case R.id.bP:
                añadirLetra(bP);
                break;
            case R.id.bQ:
                añadirLetra(bQ);
                break;
            case R.id.bR:
                añadirLetra(bR);
                break;
            case R.id.bS:
                añadirLetra(bS);
                break;
            case R.id.bT:
                añadirLetra(bT);
                break;
            case R.id.bU:
                añadirLetra(bU);
                break;
            case R.id.bV:
                añadirLetra(bV);
                break;
            case R.id.bW:
                añadirLetra(bW);
                break;
            case R.id.bX:
                añadirLetra(bX);
                break;
            case R.id.bY:
                añadirLetra(bY);
                break;
            case R.id.bZ:
                añadirLetra(bZ);
                break;
            case R.id.bEnviar:
                enter();
                break;
            case R.id.bBorrar:
                borrar();
                break;
        }
    }

    public void añadirLetra(Button b){

        if (columnaActual < 5){
            cuadroLetra = findViewById(idRecuadros[filaActual][columnaActual]);
            cuadroLetra.setText(b.getText().toString());
            columnaActual++;
        }
    }

    public void enter(){
        if (filaActual == 5 && aciertos != 5){
            perder();
        }

        if (columnaActual > 4 ){
            check();
            if (filaActual < 5){
                filaActual++;
            }

        } else{
            Toast toast = Toast.makeText(getApplicationContext(), "No hay suficientes letras", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void check(){
        aciertos = 0;
        columnaActual = 0;
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.wordle_anim);
        final Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.wordle_anim);
        final Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.wordle_anim);
        final Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.wordle_anim);
        final Animation animation5 = AnimationUtils.loadAnimation(this, R.anim.wordle_anim);

        TextView c1 = findViewById(idRecuadros[filaActual][0]);
        TextView c2 = findViewById(idRecuadros[filaActual][1]);
        TextView c3 = findViewById(idRecuadros[filaActual][2]);
        TextView c4 = findViewById(idRecuadros[filaActual][3]);
        TextView c5 = findViewById(idRecuadros[filaActual][4]);

        c1.startAnimation(animation);
        comprobarLetra(c1, posicionCorrecta);
        posicionCorrecta++;
        new Handler().postDelayed(() -> {
            c2.startAnimation(animation2);
            comprobarLetra(c2, posicionCorrecta);
            posicionCorrecta++;
        }, 200);
        new Handler().postDelayed(() -> {
            c3.startAnimation(animation3);
            comprobarLetra(c3, posicionCorrecta);
            posicionCorrecta++;
        }, 400);
        new Handler().postDelayed(() -> {
            c4.startAnimation(animation4);
            comprobarLetra(c4, posicionCorrecta);
            posicionCorrecta++;
        }, 600);
        new Handler().postDelayed(() -> {
            c5.startAnimation(animation5);
            comprobarLetra(c5, posicionCorrecta);
            posicionCorrecta = 0;
        }, 800);
        new Handler().postDelayed(() -> {
            if (aciertos == 5){
                ganar();
            }
        }, 1000);

    }

    public void ganar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("¡Felicidades, has ganado!");
        builder.setMessage("La palabra era : " + palabra);
        builder.setPositiveButton("Reiniciar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recreate();
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

    public void perder(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Lo siento, has perdido...");
        builder.setMessage("La palabra era : " + palabra);
        builder.setPositiveButton("Reiniciar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recreate();
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

    public void comprobarLetra(TextView t, int pos){
        String s = t.getText().toString();
        boolean coloreada = false;
        boolean coloreadaAmarillo = false;
        char c = s.charAt(0);
            for(int i = 0; i < 5; i++){
                if (Character.toUpperCase(c) == Character.toUpperCase(letrasPalabra[i]) && pos == i && !coloreada){
                    t.setBackgroundResource(R.drawable.wordle_border_green);
                    t.setTextColor(Color.parseColor("#FFFFFFFF"));
                    coloreada = true;
                    aciertos++;
                } else if (Character.toUpperCase(c) == Character.toUpperCase(letrasPalabra[i]) && !coloreada){
                    t.setBackgroundResource(R.drawable.wordle_border_yellow);
                    t.setTextColor(Color.parseColor("#FFFFFFFF"));
                    coloreadaAmarillo = true;
                } else if(!coloreada && !coloreadaAmarillo ){
                    t.setBackgroundResource(R.drawable.wordle_border_grey);
                    t.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
            }
    }

    public void borrar(){
        if (columnaActual > 0){
            cuadroLetra = findViewById(idRecuadros[filaActual][columnaActual - 1]);
            cuadroLetra.setText("");
            columnaActual--;
        }

    }

    public void rellenarIds(){
        idRecuadros = new int[6][5];
        idFila1 = new int[]{R.id.r1t1, R.id.r1t2, R.id.r1t3, R.id.r1t4, R.id.r1t5};
        idFila2 = new int[]{R.id.r2t1, R.id.r2t2, R.id.r2t3, R.id.r2t4, R.id.r2t5};
        idFila3 = new int[]{R.id.r3t1, R.id.r3t2, R.id.r3t3, R.id.r3t4, R.id.r3t5};
        idFila4 = new int[]{R.id.r4t1, R.id.r4t2, R.id.r4t3, R.id.r4t4, R.id.r4t5};
        idFila5 = new int[]{R.id.r5t1, R.id.r5t2, R.id.r5t3, R.id.r5t4, R.id.r5t5};
        idFila6 = new int[]{R.id.r6t1, R.id.r6t2, R.id.r6t3, R.id.r6t4, R.id.r6t5};
        idRecuadros[0] = idFila1;
        idRecuadros[1] = idFila2;
        idRecuadros[2] = idFila3;
        idRecuadros[3] = idFila4;
        idRecuadros[4] = idFila5;
        idRecuadros[5] = idFila6;
    }

    public void escogerPalabra(){
        String [] palabras = getResources().getStringArray(R.array.wordle_words);
        int n = new Random().nextInt(8);
        palabra = palabras[n];
        letrasPalabra = palabra.toCharArray();
    }
}
