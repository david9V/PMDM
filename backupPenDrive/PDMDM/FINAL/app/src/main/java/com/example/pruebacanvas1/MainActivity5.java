package com.example.pruebacanvas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraficoView5 graficoView5 = new GraficoView5(this);
        setContentView(graficoView5);
    }
}

class GraficoView5 extends View {

    public GraficoView5(Context context) {

        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float s = getResources().getDisplayMetrics().scaledDensity;

        float radio = 30 * s;

        float w = getWidth();
        float h = getHeight();
        Paint paint = new Paint();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawColor(Color.YELLOW);
        canvas.drawCircle(w/2, h/2, radio, paint);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawRect(10,10,100*s,100*s,paint);

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10*s);
        canvas.drawRect(10,10,100*s,100*s,paint);



    }
}