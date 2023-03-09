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
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    boolean continuar = true;
    boolean hitmarkerF = false;
    float velocidadX = 1.5f;
    float velocidadY = 1.5f;
    float velocidadXc = 1.5f;
    float velocidadYc = 1.5f;
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
        int xC, yC ,ymaxC, xmaxC;
        Paint paintFondo, paintParticula, paint;
        float radio = 100 * s;
        Bitmap bitmap, hitmarker, vidas;
        BitmapFactory.Options options;
        int nVidas = 5;

        public DinamicaView(Context context) {
            super(context);
            paintFondo = new Paint();
            paintParticula = new Paint();
            paint = new Paint();
            paintFondo.setColor(Color.WHITE);
            paintParticula.setColor(Color.TRANSPARENT);
            paint.setColor(Color.BLACK);
            options = new BitmapFactory.Options();
            options.inSampleSize=4;
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.assasincrab);
            vidas = BitmapFactory.decodeResource(context.getResources(), R.drawable.assasincrab, options);
            hitmarker = BitmapFactory.decodeResource(context.getResources(), R.drawable.hitmarker);
        }

        @Override
        public void run() {
            while (continuar) {
                tiempo = tiempo + dt;
                y = y  + (int) (velocidadY * dt);
                x = x  + (int) (velocidadX * dt);

                yC = yC  + (int) (velocidadYc * dt);
                xC = xC + (int) (velocidadXc * dt);

                if (y > (ymax - 400)) {
                    velocidadY = -velocidadY;
                }
                if (y < (-400)) {
                    velocidadY = -velocidadY;
                }
                if (x > (xmax - 302)) {
                    velocidadX = -velocidadX;
                }
                if (x < (-320)) {
                    velocidadX = -velocidadX;
                }

                //CIRCULO
                if (yC > ymaxC) {
                    velocidadYc = -velocidadYc;
                }
                if (yC < 0) {
                    velocidadYc = -velocidadYc;
                }
                if (xC > xmaxC + 20) {
                    velocidadXc = -velocidadXc;
                }
                if (xC < 0) {
                    velocidadXc = -velocidadXc;
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
            x = - 320;
            y = -400;
            ymax = h;
            xmax = w;

            xC = 0;
            yC= 0;
            ymaxC = h;
            xmaxC = w;
        }

        @Override
        public void onDraw(Canvas canvas) {
            canvas.drawPaint(paintFondo);
            paint.setTextSize(20 * s);
            if (vivo)
                canvas.drawBitmap(bitmap, x, y, null);
            if (hitmarkerF){
                canvas.drawBitmap(hitmarker, xC - 420, yC - 270, null);
                Handler handler = new Handler();
                handler.postDelayed(() -> hitmarkerF = false, 100);

            }
            switch (nVidas){
                case 1:
                    canvas.drawBitmap(vidas, 40, -10, null);
                case 2: {
                    canvas.drawBitmap(vidas, 40, -10, null);
                    canvas.drawBitmap(vidas, 250, -10, null);
                    break;
                }
                case 3:{
                    canvas.drawBitmap(vidas, 40, -10, null);
                    canvas.drawBitmap(vidas, 250, -10, null);
                    canvas.drawBitmap(vidas, 450, -10, null);
                    break;
                }
                case 4: {
                    canvas.drawBitmap(vidas, 40, -10, null);
                    canvas.drawBitmap(vidas, 250, -10, null);
                    canvas.drawBitmap(vidas, 450, -10, null);
                    canvas.drawBitmap(vidas, 650, -10, null);
                    break;
                }
                case 5:{
                    canvas.drawBitmap(vidas, 40, -10, null);
                    canvas.drawBitmap(vidas, 250, -10, null);
                    canvas.drawBitmap(vidas, 450, -10, null);
                    canvas.drawBitmap(vidas, 650, -10, null);
                    canvas.drawBitmap(vidas, 850, -10, null);
                    break;
                }

            }
            canvas.drawCircle(xC, yC, 100 * s, paintParticula);
            //canvas.drawText("Puntos: " + puntos, (float) (xmax / 2.5), 25 * s, paint);
        }

        @SuppressLint("ClickableViewAccessibility")
        public boolean onTouchEvent(MotionEvent evento) {
            float clickedX = evento.getX();
            float clickedY = evento.getY();
            System.out.println(clickedX + "," + clickedY);
            if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                double dX = clickedX - xC;
                double dY = clickedY - yC;
                float distancia = (float) Math.sqrt(dX * dX + dY * dY);
                distancia -= 150;
                System.out.println("DISTANCIA:" + distancia);
                if ((distancia) <= radio) {
                    hitmarkerF = true;
                    nVidas--;
                    invalidate();
                }
            }
            return true;
        }
    }
}