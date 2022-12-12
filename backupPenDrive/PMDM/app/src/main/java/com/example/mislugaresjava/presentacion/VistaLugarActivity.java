package com.example.mislugaresjava.presentacion;


import android.os.Bundle;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mislugaresjava.Aplicacion;
import com.example.mislugaresjava.Lugar;
import com.example.mislugaresjava.RepositorioLugares;
import com.example.mislugaresjava.casos_uso.CasosUsoLugar;

import java.text.DateFormat;
import java.util.Date;

public class VistaLugarActivity extends AppCompatActivity {
    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;
    private int pos;
    private Lugar lugar;
    private VistaLugarBinding binding;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = VistaLugarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("pos", 0);
        lugares = ((Aplicacion) getApplication()).lugares;
        usoLugar = new CasosUsoLugar(this, lugares);
        lugar = lugares.elemento(pos);
        actualizaVistas();
    }

    public void actualizaVistas() {
        lugar = lugares.elemento(pos);
        binding.nombre.setText(lugar.getNombre());
        binding.logoTipo.setImageResource(lugar.getTipo().getRecurso());
        binding.tipo.setText(lugar.getTipo().getTexto());
        binding.direccion.setText(lugar.getDireccion());
        binding.telefono.setText(Integer.toString(lugar.getTelefono()));
        binding.url.setText(lugar.getUrl());
        binding.comentario.setText(lugar.getComentario());
        binding.fecha.setText(DateFormat.getDateInstance().format(
                new Date(lugar.getFecha())));
        binding.hora.setText(DateFormat.getTimeInstance().format(
                new Date(lugar.getFecha())));
        binding.valoracion.setRating(lugar.getValoracion());
        binding.valoracion.setOnRatingBarChangeListener(
                (RatingBar.OnRatingBarChangeListener) (ratingBar, valor, fromUser) -> lugar.setValoracion(valor));
    }
}

