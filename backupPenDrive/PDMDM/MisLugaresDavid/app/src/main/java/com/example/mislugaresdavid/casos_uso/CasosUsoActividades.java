package com.example.mislugaresdavid.casos_uso;

import android.app.Activity;
import android.content.Intent;

import com.example.mislugaresdavid.presentacion.AcercaDeActivity;
import com.example.mislugaresdavid.presentacion.PreferenciasActivity;

public class CasosUsoActividades {

   protected Activity actividad;

   public CasosUsoActividades(Activity actividad) {
      this.actividad = actividad;
   }

   public void lanzarAcercaDe() {
      actividad.startActivity(
         new Intent(actividad, AcercaDeActivity.class));
   }

   public void lanzarPreferencias(int codidoSolicitud) {
      actividad.startActivityForResult(
         new Intent(actividad, PreferenciasActivity.class), codidoSolicitud);
   }


}