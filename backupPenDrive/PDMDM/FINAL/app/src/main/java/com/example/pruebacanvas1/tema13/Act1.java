package com.example.pruebacanvas1.tema13;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class Act1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Grafico1 grafico1 = new Grafico1(this);
        setContentView(grafico1);
    }

}

class Grafico1 extends View {
    Paint paint;
    float s; // scaled density
    float radio;
    float x,y;
    boolean first;
    float xTexto,yTexto;
    String evento;

    public Grafico1(Context context) {
        super(context);
        paint = new Paint();
        s = getResources().getDisplayMetrics().scaledDensity;
        radio = 40 * s;
        first = true;
        evento = "";
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        xTexto = getWidth() / 2.5f;
        yTexto = getHeight() / 6f;
        if (first){
            y = getHeight() / 2f;
            x = getWidth() / 2f;
            first = false;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawColor(Color.rgb(255, 243, 212));
        canvas.drawCircle(x, y, radio, paint);
        paint.setTextSize(20 * s);
        paint.setColor(Color.BLACK);
        canvas.drawText("x: " + x, xTexto, yTexto, paint);
        canvas.drawText("y: " + y, xTexto, yTexto + 50, paint);
        canvas.drawText("Evento: " + evento, xTexto, yTexto + 100, paint);
    }

    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent motionEvent) {
        x = motionEvent.getX();
        y = motionEvent.getY();
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            evento = "ACTION_DOWN";
        }
        if(motionEvent.getAction()==MotionEvent.ACTION_UP){
            evento = "ACTION_UP";
        }
        if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){
            evento = "ACTION_MOVE";
        }

        invalidate();
        return true;
    }
}
