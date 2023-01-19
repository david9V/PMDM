package com.example.mislugaresdavid.presentacion;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mislugaresdavid.Aplicacion;
import com.example.mislugaresdavid.R;
import com.example.mislugaresdavid.casos_uso.CasosUsoActividades;
import com.example.mislugaresdavid.casos_uso.CasosUsoLocalizacion;
import com.example.mislugaresdavid.casos_uso.CasosUsoLugar;
import com.example.mislugaresdavid.datos.LugaresBD;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final int SOLICITUD_PERMISO_LOCALIZACION = 1;
    static final int RESULTADO_PREFERENCIAS = 0;

    private LugaresBD lugares;
    public AdaptadorLugaresBD adaptador;
    private CasosUsoLugar usoLugar;
    private CasosUsoActividades usoActividades;
    private CasosUsoLocalizacion usoLocalizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lugares = ((Aplicacion) getApplication()).lugares;
        adaptador = ((Aplicacion) getApplication()).adaptador;
        usoLugar = new CasosUsoLugar(this, null, lugares, adaptador);
        usoActividades = new CasosUsoActividades(this);
        usoLocalizacion  = new CasosUsoLocalizacion(this, SOLICITUD_PERMISO_LOCALIZACION);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usoLugar.nuevo();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            usoActividades.lanzarPreferencias(RESULTADO_PREFERENCIAS);
            return true;
        }
        if (id == R.id.acercaDe) {
            usoActividades.lanzarAcercaDe();
            return true;
        }
        if (id == R.id.menu_buscar) {
            lanzarVistaLugar(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public void onRequestPermissionsResult(int requestCode,
                                                     String[] permissions, int[] grantResults) {
        if (requestCode == SOLICITUD_PERMISO_LOCALIZACION
                && grantResults.length == 1
                && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            usoLocalizacion.permisoConcedido();
    }

    public void lanzarVistaLugar(View view){
        final EditText entrada = new EditText(this);
        entrada.setText("0");
        new AlertDialog.Builder(this)
                .setTitle("Selección de lugar")
                .setMessage("indica su id:")
                .setView(entrada)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        int id = Integer.parseInt(entrada.getText().toString());
                        usoLugar.mostrar(id);

                    }})
                .setNegativeButton("Cancelar", null)
                .show();
    }


    @Override protected void onActivityResult(int requestCode, int resultCode,
                                              Intent data) {
        super.onActivityResult(requestCode,resultCode, data);
        if (requestCode == RESULTADO_PREFERENCIAS) {
           adaptador.setCursor(lugares.extraeCursor());
           adaptador.notifyDataSetChanged();
           if (usoLugar.obtenerFragmentVista() != null)
              usoLugar.mostrar(0);

        }
    }

   @Override protected void onResume() {
      super.onResume();
      usoLocalizacion.activar();
   }

   @Override protected void onPause() {
      super.onPause();
      usoLocalizacion.desactivar();
   }
}
