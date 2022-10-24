package com.example.prueba2.wordle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.prueba2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.bA:
                break;
            case R.id.bB:
                break;
            case R.id.bCC:
                break;
            case R.id.bD:
                break;
            case R.id.bE:
                break;
            case R.id.bF:
                break;
            case R.id.bG:
                break;
            case R.id.bH:
                break;
            case R.id.bI:
                break;
            case R.id.bJ:
                break;
            case R.id.bK:
                break;
            case R.id.bL:
                break;
            case R.id.bM:
                break;
            case R.id.bN:
                break;
            case R.id.bÑ:
                break;
            case R.id.bO:
                break;
            case R.id.bP:
                break;
            case R.id.bQ:
                break;
            case R.id.bR:
                break;
            case R.id.bS:
                break;
            case R.id.bT:
                break;
            case R.id.bU:
                break;
            case R.id.bV:
                break;
            case R.id.bW:
                break;
            case R.id.bX:
                break;
            case R.id.bY:
                break;
            case R.id.bZ:
                break;
        }
    }

    public void añadirLetra(Button b, int fila, int columna){
        switch (columna){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
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


}
