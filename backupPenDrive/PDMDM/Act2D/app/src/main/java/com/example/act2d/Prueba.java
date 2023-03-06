package com.example.act2d;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Prueba extends AppCompatActivity {

    boolean continuar = true;
    float velocidadX = 1.5f;
    float velocidadY = 1.5f;
    int dt = 10;
    int tiempo = 0;
    DinamicaView dinamica;
    float s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dinamica = new DinamicaView(this);
        setContentView(dinamica);
        s = getResources().getDisplayMetrics().density;
    }

    class DinamicaView extends View {
        Bitmap bitmap;
        float x = 200;
        float y = 200;

        public DinamicaView(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.assasincrab);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // TODO Auto-generated method stub

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = event.getX();
                    y = event.getY();
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    x = event.getX();
                    y = event.getY();
                    invalidate();
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            super.onDraw(canvas);
            canvas.drawBitmap(bitmap, x, y, null);
        }
    }
}
