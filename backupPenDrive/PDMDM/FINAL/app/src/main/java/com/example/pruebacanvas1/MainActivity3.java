package com.example.pruebacanvas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraficoView3 graficoView3 = new GraficoView3(this);
        setContentView(graficoView3);
    }
}

class GraficoView3 extends View {

    public GraficoView3(Context context) {

        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawColor(Color.WHITE);
        int width = getWidth();
        int height = getHeight();
        float space = height / 20;
        float s = getResources().getDisplayMetrics().scaledDensity;
        for (int i = 0; i < 20; i++){
            canvas.drawLine(0, i * space, width, i * space, paint);
        }
        /*
        paint.setColor(Color.BLACK);
        paint.setTextSize(25 * s);
        paint.setAntiAlias(true);
        paint.setTextSize(36 * s);
        paint.setTextSize(12 * s);
        paint.setTextSize(20 * s);
         */
    }
}