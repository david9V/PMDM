package com.example.mislugaresdavid.casos_uso;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.mislugaresdavid.R;
import com.example.mislugaresdavid.datos.LugaresBD;
import com.example.mislugaresdavid.modelo.Lugar;
import com.example.mislugaresdavid.presentacion.AdaptadorLugaresBD;
import com.example.mislugaresdavid.presentacion.DialogoSelectorFecha;
import com.example.mislugaresdavid.presentacion.DialogoSelectorHora;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class CasosUsoLugarFecha extends CasosUsoLugar
                 implements TimePickerDialog.OnTimeSetListener,
                            DatePickerDialog.OnDateSetListener {

   int pos =-1;
   Lugar lugar;

   public CasosUsoLugarFecha(FragmentActivity actividad,
                             Fragment fragment,
                             LugaresBD lugares,
                             AdaptadorLugaresBD adaptador) {
      super(actividad, fragment, lugares, adaptador);
   }

   public void cambiarHora(int pos) {
      lugar = adaptador.lugarPosicion(pos);
      this.pos = pos;
      DialogoSelectorHora dialogo = new DialogoSelectorHora();
      dialogo.setOnTimeSetListener(this);
      Bundle args = new Bundle();
      args.putLong("fecha", lugar.getFecha());
      dialogo.setArguments(args);
      dialogo.show(actividad.getSupportFragmentManager(), "selectorHora");
   }

   @Override public void onTimeSet(TimePicker vista, int hora, int minuto) {
      Calendar calendario = Calendar.getInstance();
      calendario.setTimeInMillis(lugar.getFecha());
      calendario.set(Calendar.HOUR_OF_DAY, hora);
      calendario.set(Calendar.MINUTE, minuto);
      lugar.setFecha(calendario.getTimeInMillis());
      actualizaPosLugar(pos, lugar);
      TextView textView = actividad.findViewById(R.id.hora);
      textView.setText(DateFormat.getTimeInstance().format(
              new Date(lugar.getFecha())));
   }

   public void cambiarFecha(int pos) {
      lugar = adaptador.lugarPosicion(pos);
      this.pos = pos;
      DialogoSelectorFecha dialogo = new DialogoSelectorFecha();
      dialogo.setOnDateSetListener(this);
      Bundle args = new Bundle();
      args.putLong("fecha", lugar.getFecha());
      dialogo.setArguments(args);
      dialogo.show(actividad.getSupportFragmentManager(),"selectorFecha");
   }

   @Override
   public void onDateSet(DatePicker view, int año, int mes, int dia) {
      Calendar calendario = Calendar.getInstance();
      calendario.setTimeInMillis(lugar.getFecha());
      calendario.set(Calendar.YEAR, año);
      calendario.set(Calendar.MONTH, mes);
      calendario.set(Calendar.DAY_OF_MONTH, dia);
      lugar.setFecha(calendario.getTimeInMillis());
      actualizaPosLugar(pos, lugar);
      TextView textView = actividad.findViewById(R.id.fecha);
      textView.setText(DateFormat.getDateInstance().format(
              new Date(lugar.getFecha())));
   }

}