package com.example.mislugaresdavid.presentacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mislugaresdavid.Aplicacion;
import com.example.mislugaresdavid.R;
import com.example.mislugaresdavid.casos_uso.CasosUsoLugar;
import com.example.mislugaresdavid.datos.LugaresBD;

public class SelectorFragment extends Fragment {
   private LugaresBD lugares;
   private AdaptadorLugaresBD adaptador;
   private CasosUsoLugar usoLugar;
   private RecyclerView recyclerView;

   @Override
   public View onCreateView(LayoutInflater inflador, ViewGroup contenedor,
                            Bundle savedInstanceState) {
      View vista = inflador.inflate(R.layout.fragment_selector,
              contenedor, false);
      recyclerView = vista.findViewById(R.id.recyclerView);
      return vista;
   }

   @Override
   public void onActivityCreated(Bundle state) {
      super.onActivityCreated(state);
      lugares = ((Aplicacion) getActivity().getApplication()).lugares;
      adaptador = ((Aplicacion) getActivity().getApplication()).adaptador;
      usoLugar = new CasosUsoLugar(getActivity(), this, lugares, adaptador);
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      recyclerView.setAdapter(adaptador);
      adaptador.setOnItemClickListener(new View.OnClickListener() {
         @Override public void onClick(View v) {
            int pos = (Integer)(v.getTag());
            usoLugar.mostrar(pos);
         }
      });

   }
}
