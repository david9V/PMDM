package com.example.pruebacanvas1.tema12;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebacanvas1.R;
/*
public class MainActivityUltimo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout milayout = findViewById(R.id.ml);

        //obtiene dimensiones del layout rectangulo
        Rect window=new Rect();
        milayout.getWindowVisibleDisplayFrame(window);
        int w = window.width();
        int h = window.height();

        SpecialView view1 = new SpecialView(this, 0xFFCEA5B0, "w:" + w +",h:" + h/3);
        SpecialView view2 = new SpecialView(this, 0xFFA6CEA5, "w:" + w*2/3 +",h:" + h/3);
        SpecialView view3 = new SpecialView(this, 0xFFA5BECE, "w:" + w/3 +",h:" + h/3);

        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(w,h/3);
        view1.setLayoutParams(params);
        //view1.setY(h - (2*h/3));

        LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(w*2/3,h/3);
        view2.setLayoutParams(params2);
        // view2.setY(h/3);

        LinearLayout.LayoutParams params3=new LinearLayout.LayoutParams(w*1/3,h/3);
        view3.setLayoutParams(params3);
        view3.setX(w * 2 / 3);

        milayout.addView(view1); //se añade al layout la vista 1
        milayout.addView(view2); //se añade al layout la vista 2
        milayout.addView(view3); //se añade al layout la vista 3

        //setContentView(milayout);
    }
}

 */