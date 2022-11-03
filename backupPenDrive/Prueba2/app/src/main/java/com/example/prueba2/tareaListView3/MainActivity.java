package com.example.prueba2.tareaListView3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.prueba2.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarea3_listview);

        List<String> entradas = new ArrayList<>();
        //Button agregar = findViewById(R.id.bAgregar);
        //EditText edit = findViewById(R.id.editTarea3);
/*
        agregar.setOnClickListener(view -> {
            String entrada = String.valueOf(edit.getText());
            entradas.add(convertirEntrada(entrada));
        });

 */
/*
        ListView l = findViewById(R.id.lista_tarea3);
        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, entradas);

        l.setAdapter(adaptador);
        l.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                return false;
            }
        });

 */
    }

    public String convertirEntrada(String e){
        int pos = -1;

        for(int i = 0; i < e.length(); i++){
            char c = e.charAt(i);
            if (c == ' '){
                pos = i;
            }
        }
        String separador = " : ";
        StringBuilder sb = new StringBuilder(e);
        sb.insert(pos, separador);

        String res = sb.toString();
        return res;
    }


}
