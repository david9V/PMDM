package com.example.prueba2.pruebaWidgetsSeleccion;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

public class PruebaListView extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_test1);

        String[] elementos = {"Destornillador", "Cuerda", "Gancho", "Pelota", "Saco"};

        ArrayAdapter<String> adaptador;

        ListView l = findViewById(R.id.lista);

        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, elementos);

        l.setAdapter(adaptador);
        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView t = findViewById(R.id.eleccion);
        String seleccionado=new String();
        ListView lv = findViewById(R.id.lista);
        SparseBooleanArray checked = lv.getCheckedItemPositions();

        for(int j = 0; j < checked.size(); j++)
            if(checked.valueAt(j)){
                seleccionado=seleccionado+
                        adapterView.getItemAtPosition(checked.keyAt(j)).toString()
                        +";";
            }
        t.setText(seleccionado);    }
}
