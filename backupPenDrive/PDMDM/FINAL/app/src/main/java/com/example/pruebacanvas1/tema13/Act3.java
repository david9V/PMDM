package com.example.pruebacanvas1.tema13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class Act3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Grafico3 grafico3 = new Grafico3(this);
        setContentView(grafico3);
    }
}

class Grafico3 extends View {
    float s = getResources().getDisplayMetrics().scaledDensity;
    float[] x = {50 * s, 50 * s};
    float[] y = {50 * s, 150 * s};
    float[] radio = {40 * s, 60 * s};
    Paint paint[] = new Paint[2];
    Paint p;
    int seleccion = -1;
    String texto = "Mueva los círculos";
    public Grafico3(Context context) {
        super(context);
        paint[0] = new Paint();
        paint[1] = new Paint();
        paint[0].setColor(Color.RED);
        paint[1].setColor(Color.BLUE);
        p = new Paint();
        p.setTextSize(20 * s);
        p.setColor(Color.BLACK);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        canvas.drawText(texto, 100 * s, 25 * s, p);
        for (int i = 0; i < 2; i++) {
            canvas.drawCircle(x[i], y[i], radio[i], paint[i]);
        }
    }

    @Override

    public boolean onTouchEvent(MotionEvent evento) {
        float newX = evento.getX();
        float newY = evento.getY();
        if (evento.getAction() == MotionEvent.ACTION_DOWN) {
            seleccion = -1;//si no hay ningun circulo seleccionado
            for (int i = 0; i < 2; i++) {
//calculo de la distacia al centro de cada círculo
                double dX = newX - x[i];
                double dY = newY - y[i];
                float distancia = (float) Math.sqrt(dX * dX + dY * dY);
                if (distancia <= radio[i]) {
//se ha seleccionado el círculo i
                    seleccion = i;
                    texto = "Seleccion: " + i;
                    invalidate();
                }
            }
        }
        if (evento.getAction() == MotionEvent.ACTION_MOVE) {
//si hay algun circulo seleccionado lo trasladamos al nuevo punto
            if (seleccion > -1) {
                x[seleccion] = newX;
                y[seleccion] = newY;
                invalidate();
            }
        }
        return true;
    }
}