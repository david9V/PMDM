package com.example.pruebacanvas1.tema14;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.pruebacanvas1.R;

public class Act1_t14 extends AppCompatActivity implements View.OnClickListener{

    ImageButton right;
    ImageButton left;
    ImageView imageView;
    Bitmap[] imagenes;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1_t14);
        imageView = findViewById(R.id.imagenAct1);
        right = findViewById(R.id.right);
        left = findViewById(R.id.left);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize=2;
        imagenes = new Bitmap[3];
        imagenes[0] = BitmapFactory.decodeResource(getResources(), R.drawable.calor, options);
        imagenes[1] = BitmapFactory.decodeResource(getResources(), R.drawable.mec, options);
        imagenes[2] = BitmapFactory.decodeResource(getResources(), R.drawable.viejoven, options);
        imageView.setImageBitmap(imagenes[0]);
        right.setOnClickListener(this);
        left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == right.getId()){
            if (i < 2)
                i++;
            else
                i = 0;
            imageView.setImageBitmap(imagenes[i]);
        }
        else{
            if (i > 0)
                i--;
            else
                i = 2;
            imageView.setImageBitmap(imagenes[i]);
        }
    }
}