package com.example.pruebacanvas1.tema14;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.pruebacanvas1.R;

public class Act0_t14 extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act0_t14);

        imageView = findViewById(R.id.i14_1);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize=2;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.calor, options);
        imageView.setImageBitmap(bitmap);
    }
}