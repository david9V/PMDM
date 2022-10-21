package com.example.prueba2.hangmanGame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

import java.util.Arrays;
import java.util.Random;

public class RunningActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView fase1;
    ImageView fase2;
    ImageView fase3;
    ImageView fase4;
    ImageView fase5;
    ImageView fase6;
    ImageView fase7;
    ImageView fase8;

    String[] palabras;

    char[] letras;
    char[] oculto;

    TextView adivinar;

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

    int nivel = 1;

    int letrasCorrectas = 0;

    boolean fin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangman2);
        Bundle extras = getIntent().getExtras();
        palabras = extras.getStringArray("palabras");

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
        bX.setOnClickListener(this);
        bY.setOnClickListener(this);
        bZ.setOnClickListener(this);

        fase1 = findViewById(R.id.fase1);
        fase2 = findViewById(R.id.fase2);
        fase3 = findViewById(R.id.fase3);
        fase4 = findViewById(R.id.fase4);
        fase5 = findViewById(R.id.fase5);
        fase6 = findViewById(R.id.fase6);
        fase7 = findViewById(R.id.fase7);
        fase8 = findViewById(R.id.fase8);
        adivinar = findViewById(R.id.adivinar);

        preparar();

        escogerPalabra();
        adivinar.setLetterSpacing(1);
        adivinar.setText(convertirString());
    }

    public void preparar(){
        fase1.setVisibility(View.VISIBLE);
        fase2.setVisibility(View.INVISIBLE);
        fase3.setVisibility(View.INVISIBLE);
        fase4.setVisibility(View.INVISIBLE);
        fase5.setVisibility(View.INVISIBLE);
        fase6.setVisibility(View.INVISIBLE);
        fase7.setVisibility(View.INVISIBLE);
        fase8.setVisibility(View.INVISIBLE);
    }

    public void escogerPalabra(){
        int n = new Random().nextInt(8);
        String p = palabras[n];
        letras = p.toCharArray();
        oculto = new char[letras.length];
        Arrays.fill(oculto, '_');
    }

    public String convertirString(){
        String p = String.valueOf(oculto);
        return p;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (!fin){
            switch (id){
                case R.id.bA:
                    comprobarLetra(bA);
                    break;
                case R.id.bB:
                    comprobarLetra(bB);
                    break;
                case R.id.bCC:
                    comprobarLetra(bC);
                    break;
                case R.id.bD:
                    comprobarLetra(bD);
                    break;
                case R.id.bE:
                    comprobarLetra(bE);
                    break;
                case R.id.bF:
                    comprobarLetra(bF);
                    break;
                case R.id.bG:
                    comprobarLetra(bG);
                    break;
                case R.id.bH:
                    comprobarLetra(bH);
                    break;
                case R.id.bI:
                    comprobarLetra(bI);
                    break;
                case R.id.bJ:
                    comprobarLetra(bJ);
                    break;
                case R.id.bK:
                    comprobarLetra(bK);
                    break;
                case R.id.bL:
                    comprobarLetra(bL);
                    break;
                case R.id.bM:
                    comprobarLetra(bM);
                    break;
                case R.id.bN:
                    comprobarLetra(bN);
                    break;
                case R.id.bÑ:
                    comprobarLetra(bÑ);
                    break;
                case R.id.bO:
                    comprobarLetra(bO);
                    break;
                case R.id.bP:
                    comprobarLetra(bP);
                    break;
                case R.id.bQ:
                    comprobarLetra(bQ);
                    break;
                case R.id.bR:
                    comprobarLetra(bR);
                    break;
                case R.id.bS:
                    comprobarLetra(bS);
                    break;
                case R.id.bT:
                    comprobarLetra(bT);
                    break;
                case R.id.bU:
                    comprobarLetra(bU);
                    break;
                case R.id.bV:
                    comprobarLetra(bV);
                    break;
                case R.id.bX:
                    comprobarLetra(bX);
                    break;
                case R.id.bY:
                    comprobarLetra(bY);
                    break;
                case R.id.bZ:
                    comprobarLetra(bZ);
                    break;
            }
        }

    }

    public void comprobarLetra(Button b){
        boolean esta = false;
        char adivinada = 0;
        int indice[] = new int[0];
        int iIndice = 0;
        for(int i = 0; i < letras.length; i++){
            if(b.getText().toString().equalsIgnoreCase(String.valueOf(letras[i]))){
                esta = true;
                adivinada = letras[i];
                indice = Arrays.copyOf(indice, indice.length + 1);
                indice[iIndice] = i;
                iIndice++;
            }
        }

        if (esta){
            b.setBackgroundTintList(getResources().getColorStateList(R.color.green));
            for(int i = 0; i < indice.length; i++){
                letrasCorrectas++;
                oculto[indice[i]] = adivinada;
            }
            adivinar.setText(convertirString());
            if(letrasCorrectas == letras.length){
                fin = true;
                comprobarVictoria();
            }

        } else{
            b.setBackgroundTintList(getResources().getColorStateList(R.color.red));
            avanzarFase();
        }

    }

    public void avanzarFase(){
        switch (nivel){
            case 1:
                fase1.setVisibility(View.INVISIBLE);
                fase2.setVisibility(View.VISIBLE);
                break;
            case 2:
                fase2.setVisibility(View.INVISIBLE);
                fase3.setVisibility(View.VISIBLE);
                break;
            case 3:
                fase3.setVisibility(View.INVISIBLE);
                fase4.setVisibility(View.VISIBLE);
                break;
            case 4:
                fase4.setVisibility(View.INVISIBLE);
                fase5.setVisibility(View.VISIBLE);
                break;
            case 5:
                fase5.setVisibility(View.INVISIBLE);
                fase6.setVisibility(View.VISIBLE);
                break;
            case 6:
                fase6.setVisibility(View.INVISIBLE);
                fase7.setVisibility(View.VISIBLE);
                break;
            case 7:
                fase7.setVisibility(View.INVISIBLE);
                fase8.setVisibility(View.VISIBLE);
                fin = true;
                comprobarVictoria();
                break;
            case 8:
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("¡Has ganado!");
                builder.setMessage("¡Felicidades! Has ganado a goku, ¿quieres jugar de nuevo o salir?");
                builder.setPositiveButton("Jugar de nuevo",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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
                break;
                 */
        }
        nivel++;
    }

    public void comprobarVictoria(){
        if (nivel == 7){
            finMalo();
        } else{
            finBueno();
        }
    }

    public void finBueno(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("¡Felicidades, has ganado!");
        builder.setMessage("La palabra era : " + String.valueOf(letras));
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        builder.setNegativeButton("Jugar de nuevo", new DialogInterface.OnClickListener() {
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
        builder.setTitle("Has perdido... La próxima vez será :)");
        builder.setMessage("La palabra era: " + String.valueOf(letras));
        builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        builder.setNegativeButton("Jugar de nuevo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAndRemoveTask();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
/*
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
 */