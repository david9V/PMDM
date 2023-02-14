package com.example.pruebacanvas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class MainActivityEjemploPath1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraficoViewPath1 graficoViewPath1 = new GraficoViewPath1(this);
        setContentView(graficoViewPath1);
    }
}

class GraficoViewPath1 extends View {

    public GraficoViewPath1(Context context) {

        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Paint pincel = new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(450, 450, 100, pincel);
        canvas.drawLine(450,450,550,600,pincel);
        Path trazo = new Path();
        trazo.moveTo(50, 100);
        trazo.cubicTo(60,70, 150,90, 200,110);
        trazo.lineTo(300,200);
        canvas.drawPath(trazo, pincel);
        pincel.setStrokeWidth(1);
        pincel.setStyle(Paint.Style.FILL);
        pincel.setTextSize(40);
        pincel.setTypeface(Typeface.SANS_SERIF);
        canvas.drawTextOnPath("2ª FP DAM", trazo, 10, 40, pincel);


    }
}