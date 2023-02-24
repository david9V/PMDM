package com.example.pruebacanvas1.tema14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.pruebacanvas1.R;

public class Act3_t14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Grafico3_t14 grafico3_t14 = new Grafico3_t14(this);
        setContentView(grafico3_t14);
    }
}

class Grafico3_t14 extends View {
    float s = getResources().getDisplayMetrics().scaledDensity;
    Paint p;
    Drawable imagen;
    int indiceImagen;
    public Grafico3_t14(Context context) {
        super(context);

        p = new Paint();
        p.setTextSize(40 * s);
        p.setColor(Color.RED);
        indiceImagen = R.drawable.perroresando;
        imagen = ContextCompat.getDrawable(context, indiceImagen);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        int anchura=getWidth();
        int altura=getHeight();
        imagen.setBounds(0,0,anchura,altura);
        imagen.draw(canvas);
        canvas.drawText("h: " + altura, 10, 100, p);
        canvas.drawText("w: " + anchura, 10, 200, p);
        canvas.drawText("density: " + s, 10, 300, p);
    }
}