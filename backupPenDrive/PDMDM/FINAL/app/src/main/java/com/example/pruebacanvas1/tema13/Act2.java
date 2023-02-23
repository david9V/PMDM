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


public class Act2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Grafico2 grafico2 = new Grafico2(this);
        setContentView(grafico2);
    }

}

class Grafico2 extends View {
    Paint paint;
    float s; // scaled density
    float x,y;
    Path trazo;

    public Grafico2(Context context) {
        super(context);
        paint = new Paint();
        trazo = new Path();
        s = getResources().getDisplayMetrics().scaledDensity;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.rgb(247, 252, 189));
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5*s);
        canvas.drawPath(trazo, paint);
    }

    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent motionEvent) {
        x = motionEvent.getX();
        y = motionEvent.getY();
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            trazo.moveTo(x, y);
        }
        if(motionEvent.getAction()==MotionEvent.ACTION_UP){
        }
        if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){
            trazo.lineTo(x,y);

        }

        invalidate();
        return true;
    }
}
