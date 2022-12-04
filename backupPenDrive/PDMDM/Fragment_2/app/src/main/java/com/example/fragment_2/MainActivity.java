package com.example.fragment_2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fragment_2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    boolean cargarFragmento2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            // Modificar el Fragmento que sale en la pantalla
            // dentro del container

            Fragment f = null;

            if (cargarFragmento2) {
                f = new FirstFragment();
            } else {
                f = new SecondFragment();
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, f)
                    .commit();

            cargarFragmento2 = !cargarFragmento2;

        });

        // Rescatamos el contenedor y le vamos a cargar un fragmento
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new FirstFragment())
                .commit();


    }
}
