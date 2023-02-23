package com.example.pruebacanvas1.tema12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GraficoView7 graficoView7 = new GraficoView7(this, Color.GRAY, "green");
        setContentView(graficoView7);
    }
}

class GraficoView7 extends View {

    int color;

    String texto;

    public GraficoView7(Context context, int color, String texto) {

        super(context);

        this.color=color;

        this.texto=texto;

    }

    protected void onDraw(Canvas canvas){
        float s = getResources().getDisplayMetrics().scaledDensity;

        canvas.drawColor(color);

        Paint paint=new Paint();

        paint.setAntiAlias(true);

        paint.setColor(Color.BLACK);

        paint.setTextSize(20*s);

        canvas.drawText(texto,10*s,25*s,paint);

    }

}