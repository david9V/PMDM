package com.example.pruebacanvas1.tema12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

public class MainActivityPathEj1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraficoViewPathEj1 graficoViewPathEj1 = new GraficoViewPathEj1(this);
        setContentView(graficoViewPathEj1);
    }
}

class GraficoViewPathEj1 extends View {

    Paint pincel;
    Path trazo;

    public GraficoViewPathEj1(Context context) {
        super(context);
        pincel = new Paint();
        trazo = new Path();
    }

    protected void onDraw(Canvas canvas) {
        pincel.setColor(Color.GREEN);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        float width = getWidth();
        for (int x = 0; x < width; x += 20) {
            trazo.moveTo(x + 10, 180);
            trazo.lineTo(x, 180);
        }
        trazo.moveTo(0, 180);

        for (int x = 0; x <= width; x += 1) {
            double y = 180.0 - Math.sin(x * Math.PI / 180) * 120;
            trazo.lineTo((float) x, (float) y);
        }
        canvas.drawPath(trazo, pincel);

    }
}