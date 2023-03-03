package com.example.pruebacanvas1.tema14;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebacanvas1.R;

public class Act2_t14 extends AppCompatActivity implements View.OnClickListener{

    ImageButton ima1;
    ImageButton ima2;
    ImageButton ima3;
    ImageButton ima4;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2_t14);

        ima1 = findViewById(R.id.ima1);
        ima2 = findViewById(R.id.ima2);
        ima3 = findViewById(R.id.ima3);
        ima4 = findViewById(R.id.ima4);
        info = findViewById(R.id.info1);
        ima1.setOnClickListener(this);
        ima2.setOnClickListener(this);
        ima3.setOnClickListener(this);
        ima4.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.ima1:{
                Toast toast=Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                info.setText(R.string.img1);
            }
            case R.id.ima2:{
                Toast toast=Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                info.setText(R.string.img2);
            }
            case R.id.ima3:{
                Toast toast=Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                info.setText(R.string.img3);
            }
            case R.id.ima4:{
                Toast toast=Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
                info.setText(R.string.img4);
            }
        }
    }
}