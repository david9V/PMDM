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
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    boolean continuar = true;
    float velocidadX = 1.5f;
    float velocidadY = 1.5f;
    int dt = 10;
    int tiempo = 0;
    Thread hilo = null;
    DinamicaView dinamica;
    float s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dinamica = new DinamicaView(this);
        setContentView(dinamica);
        s = getResources().getDisplayMetrics().density;
        hilo = new Thread(dinamica);
        hilo.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        continuar = false;
    }

    @Override

    public void onResume() {
        super.onResume();
        continuar = true;
        if (!hilo.isAlive()) {
            hilo = new Thread(dinamica);
            hilo.start();
        }
    }

    class DinamicaView extends View implements Runnable {
        boolean vivo = true;
        int puntos = 0;
        int x, y, ymax, xmax;
        Paint paintFondo, paintParticula, paint;
        float radio = 60 * s;
        Bitmap bitmap;

        public DinamicaView(Context context) {
            super(context);
            paintFondo = new Paint();
            paintParticula = new Paint();
            paint = new Paint();
            paintFondo.setColor(Color.WHITE);
            paintParticula.setColor(Color.RED);
            paint.setColor(Color.BLACK);

            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.assasincrab);        }

        @Override
        public void run() {
            while (continuar) {
                tiempo = tiempo + dt;
                y = y  + (int) (velocidadY * dt);
                x = x  + (int) (velocidadX * dt);

                if (y > (ymax - 600)) {
                    velocidadY = -velocidadY;
                }
                if (y < (-400)) {
                    velocidadY = -velocidadY;
                }
                if (x > (xmax - 400)) {
                    velocidadX = -velocidadX;
                }
                if (x < (-200)) {
                    velocidadX = -velocidadX;
                }
                postInvalidate();
                try {
                    Thread.sleep(dt);
                } catch (InterruptedException ignored) {
                }
            }
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            x = - 200;
            y = - 200;
            ymax = h;
            xmax = w;
        }

        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawPaint(paintFondo);
            paint.setTextSize(20 * s);
            if (vivo)
                canvas.drawBitmap(bitmap, x, y, null);
            //canvas.drawCircle(x, y, 40 * s, paintParticula);
            canvas.drawText("y= " + y, 10 * s, 25 * s, paint);
            canvas.drawText("x= " + x, 10 * s, 50 * s, paint);
            canvas.drawText("Puntos: " + puntos, (float) (xmax / 2.5), 25 * s, paint);
        }

        @SuppressLint("ClickableViewAccessibility")
        public boolean onTouchEvent(MotionEvent evento) {
            float clickedX = evento.getX();
            float clickedY = evento.getY();
            System.out.println(clickedX + "," + clickedY);
            if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                double dX = clickedX - x;
                double dY = clickedY - y;
                float distancia = (float) Math.sqrt(dX * dX + dY * dY);
                distancia -= 150;
                System.out.println("DISTANCIA:" + distancia);
                if ((distancia) <= radio) {
                    puntos++;
                    invalidate();
                }
            }
            return true;
        }
    }
}