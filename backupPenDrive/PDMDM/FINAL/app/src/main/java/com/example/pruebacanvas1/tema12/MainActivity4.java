package com.example.pruebacanvas1.tema12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraficoView4 graficoView4 = new GraficoView4(this);
        setContentView(graficoView4);
    }
}

class GraficoView4 extends View {

    public GraficoView4(Context context) {

        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        float s = getResources().getDisplayMetrics().scaledDensity;
        paint.setStrokeWidth(2*s);
        canvas.drawColor(Color.YELLOW);
        int width = getWidth();
        int height = getHeight();

        canvas.drawLine(0, 0, width, height, paint);

        canvas.drawLine(width, 0, 0, height, paint);

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