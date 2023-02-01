package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;

public class EasyFragment extends Fragment implements View.OnClickListener {

    int[][] idRecuadros;
    List<Integer> minas;
    int[] idFila1;
    int[] idFila2;
    int[] idFila3;
    int[] idFila4;
    int[] idFila5;
    int[] idFila6;
    int[] idFila7;
    int[] idFila8;
    boolean puedeJugar;

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //binding.buttonSecond.setOnClickListener(view1 -> NavHostFragment.findNavController(EasyFragment.this)
        //      .navigate(R.id.action_SecondFragment_to_FirstFragment));
        //CODIGO NUEVO AQUÍ NO ENO ONCREATEVIEW

        puedeJugar = true;
        implementarListeners();
        rellenarIds();
        rellenarConMinas();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void rellenarIds() {
        idRecuadros = new int[8][8];
        idFila1 = new int[]{R.id.f1b1, R.id.f1b2, R.id.f1b3, R.id.f1b4, R.id.f1b5, R.id.f1b6, R.id.f1b7, R.id.f1b8};
        idFila2 = new int[]{R.id.f2b1, R.id.f2b2, R.id.f2b3, R.id.f2b4, R.id.f2b5, R.id.f2b6, R.id.f2b7, R.id.f2b8};
        idFila3 = new int[]{R.id.f3b1, R.id.f3b2, R.id.f3b3, R.id.f3b4, R.id.f3b5, R.id.f3b6, R.id.f3b7, R.id.f3b8};
        idFila4 = new int[]{R.id.f4b1, R.id.f4b2, R.id.f4b3, R.id.f4b4, R.id.f4b5, R.id.f4b6, R.id.f4b7, R.id.f4b8};
        idFila5 = new int[]{R.id.f5b1, R.id.f5b2, R.id.f5b3, R.id.f5b4, R.id.f5b5, R.id.f5b6, R.id.f5b7, R.id.f5b8};
        idFila6 = new int[]{R.id.f6b1, R.id.f6b2, R.id.f6b3, R.id.f6b4, R.id.f6b5, R.id.f6b6, R.id.f6b7, R.id.f6b8};
        idFila7 = new int[]{R.id.f7b1, R.id.f7b2, R.id.f7b3, R.id.f7b4, R.id.f7b5, R.id.f7b6, R.id.f7b7, R.id.f7b8};
        idFila8 = new int[]{R.id.f8b1, R.id.f8b2, R.id.f8b3, R.id.f8b4, R.id.f8b5, R.id.f8b6, R.id.f8b7, R.id.f8b8};

        idRecuadros[0] = idFila1;
        idRecuadros[1] = idFila2;
        idRecuadros[2] = idFila3;
        idRecuadros[3] = idFila4;
        idRecuadros[4] = idFila5;
        idRecuadros[5] = idFila6;
        idRecuadros[6] = idFila7;
        idRecuadros[7] = idFila8;

    }

    public void implementarListeners() {
        ImageButton f1b1, f1b2, f1b3, f1b4, f1b5, f1b6, f1b7, f1b8, f2b1, f2b2, f2b3, f2b4, f2b5, f2b6, f2b7, f2b8, f3b1, f3b2, f3b3, f3b4, f3b5, f3b6, f3b7, f3b8, f4b1, f4b2, f4b3, f4b4, f4b5, f4b6, f4b7, f4b8, f5b1, f5b2, f5b3, f5b4, f5b5, f5b6, f5b7, f5b8, f6b1, f6b2, f6b3, f6b4, f6b5, f6b6, f6b7, f6b8, f7b1, f7b2, f7b3, f7b4, f7b5, f7b6, f7b7, f7b8, f8b1, f8b2, f8b3, f8b4, f8b5, f8b6, f8b7, f8b8;

        f1b1 = requireView().findViewById(R.id.f1b1);
        f1b2 = requireView().findViewById(R.id.f1b2);
        f1b3 = requireView().findViewById(R.id.f1b3);
        f1b4 = requireView().findViewById(R.id.f1b4);
        f1b5 = requireView().findViewById(R.id.f1b5);
        f1b6 = requireView().findViewById(R.id.f1b6);
        f1b7 = requireView().findViewById(R.id.f1b7);
        f1b8 = requireView().findViewById(R.id.f1b8);

        f2b1 = requireView().findViewById(R.id.f2b1);
        f2b2 = requireView().findViewById(R.id.f2b2);
        f2b3 = requireView().findViewById(R.id.f2b3);
        f2b4 = requireView().findViewById(R.id.f2b4);
        f2b5 = requireView().findViewById(R.id.f2b5);
        f2b6 = requireView().findViewById(R.id.f2b6);
        f2b7 = requireView().findViewById(R.id.f2b7);
        f2b8 = requireView().findViewById(R.id.f2b8);

        f3b1 = requireView().findViewById(R.id.f3b1);
        f3b2 = requireView().findViewById(R.id.f3b2);
        f3b3 = requireView().findViewById(R.id.f3b3);
        f3b4 = requireView().findViewById(R.id.f3b4);
        f3b5 = requireView().findViewById(R.id.f3b5);
        f3b6 = requireView().findViewById(R.id.f3b6);
        f3b7 = requireView().findViewById(R.id.f3b7);
        f3b8 = requireView().findViewById(R.id.f3b8);

        f4b1 = requireView().findViewById(R.id.f4b1);
        f4b2 = requireView().findViewById(R.id.f4b2);
        f4b3 = requireView().findViewById(R.id.f4b3);
        f4b4 = requireView().findViewById(R.id.f4b4);
        f4b5 = requireView().findViewById(R.id.f4b5);
        f4b6 = requireView().findViewById(R.id.f4b6);
        f4b7 = requireView().findViewById(R.id.f4b7);
        f4b8 = requireView().findViewById(R.id.f4b8);

        f5b1 = requireView().findViewById(R.id.f5b1);
        f5b2 = requireView().findViewById(R.id.f5b2);
        f5b3 = requireView().findViewById(R.id.f5b3);
        f5b4 = requireView().findViewById(R.id.f5b4);
        f5b5 = requireView().findViewById(R.id.f5b5);
        f5b6 = requireView().findViewById(R.id.f5b6);
        f5b7 = requireView().findViewById(R.id.f5b7);
        f5b8 = requireView().findViewById(R.id.f5b8);

        f6b1 = requireView().findViewById(R.id.f6b1);
        f6b2 = requireView().findViewById(R.id.f6b2);
        f6b3 = requireView().findViewById(R.id.f6b3);
        f6b4 = requireView().findViewById(R.id.f6b4);
        f6b5 = requireView().findViewById(R.id.f6b5);
        f6b6 = requireView().findViewById(R.id.f6b6);
        f6b7 = requireView().findViewById(R.id.f6b7);
        f6b8 = requireView().findViewById(R.id.f6b8);

        f7b1 = requireView().findViewById(R.id.f7b1);
        f7b2 = requireView().findViewById(R.id.f7b2);
        f7b3 = requireView().findViewById(R.id.f7b3);
        f7b4 = requireView().findViewById(R.id.f7b4);
        f7b5 = requireView().findViewById(R.id.f7b5);
        f7b6 = requireView().findViewById(R.id.f7b6);
        f7b7 = requireView().findViewById(R.id.f7b7);
        f7b8 = requireView().findViewById(R.id.f7b8);

        f8b1 = requireView().findViewById(R.id.f8b1);
        f8b2 = requireView().findViewById(R.id.f8b2);
        f8b3 = requireView().findViewById(R.id.f8b3);
        f8b4 = requireView().findViewById(R.id.f8b4);
        f8b5 = requireView().findViewById(R.id.f8b5);
        f8b6 = requireView().findViewById(R.id.f8b6);
        f8b7 = requireView().findViewById(R.id.f8b7);
        f8b8 = requireView().findViewById(R.id.f8b8);

        f1b1.setOnClickListener(this);
        f1b2.setOnClickListener(this);
        f1b3.setOnClickListener(this);
        f1b4.setOnClickListener(this);
        f1b5.setOnClickListener(this);
        f1b6.setOnClickListener(this);
        f1b7.setOnClickListener(this);
        f1b8.setOnClickListener(this);

        f2b1.setOnClickListener(this);
        f2b2.setOnClickListener(this);
        f2b3.setOnClickListener(this);
        f2b4.setOnClickListener(this);
        f2b5.setOnClickListener(this);
        f2b6.setOnClickListener(this);
        f2b7.setOnClickListener(this);
        f2b8.setOnClickListener(this);

        f3b1.setOnClickListener(this);
        f3b2.setOnClickListener(this);
        f3b3.setOnClickListener(this);
        f3b4.setOnClickListener(this);
        f3b5.setOnClickListener(this);
        f3b6.setOnClickListener(this);
        f3b7.setOnClickListener(this);
        f3b8.setOnClickListener(this);

        f4b1.setOnClickListener(this);
        f4b2.setOnClickListener(this);
        f4b3.setOnClickListener(this);
        f4b4.setOnClickListener(this);
        f4b5.setOnClickListener(this);
        f4b6.setOnClickListener(this);
        f4b7.setOnClickListener(this);
        f4b8.setOnClickListener(this);

        f5b1.setOnClickListener(this);
        f5b2.setOnClickListener(this);
        f5b3.setOnClickListener(this);
        f5b4.setOnClickListener(this);
        f5b5.setOnClickListener(this);
        f5b6.setOnClickListener(this);
        f5b7.setOnClickListener(this);
        f5b8.setOnClickListener(this);

        f6b1.setOnClickListener(this);
        f6b2.setOnClickListener(this);
        f6b3.setOnClickListener(this);
        f6b4.setOnClickListener(this);
        f6b5.setOnClickListener(this);
        f6b6.setOnClickListener(this);
        f6b7.setOnClickListener(this);
        f6b8.setOnClickListener(this);

        f7b1.setOnClickListener(this);
        f7b2.setOnClickListener(this);
        f7b3.setOnClickListener(this);
        f7b4.setOnClickListener(this);
        f7b5.setOnClickListener(this);
        f7b6.setOnClickListener(this);
        f7b7.setOnClickListener(this);
        f7b8.setOnClickListener(this);

        f8b1.setOnClickListener(this);
        f8b2.setOnClickListener(this);
        f8b3.setOnClickListener(this);
        f8b4.setOnClickListener(this);
        f8b5.setOnClickListener(this);
        f8b6.setOnClickListener(this);
        f8b7.setOnClickListener(this);
        f8b8.setOnClickListener(this);
    }

    public void rellenarConMinas() {
        minas = new ArrayList<>();
        while (minas.size() < 8) {
            int nHor = (int) (Math.random() * 8);
            int nVert = (int) (Math.random() * 8);
            int aux = idRecuadros[nHor][nVert];
            if (!minas.contains(aux)) minas.add(aux);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (puedeJugar){
            switch (id) {
                case R.id.f1b1:{
                    if (comprobarSiHayMina(R.id.f1b1)){
                        minaExplotada(0,0);
                    }
                    break;
                }
                case R.id.f1b2:{
                    if (comprobarSiHayMina(R.id.f1b2)){
                        minaExplotada(0,1);
                    }
                    break;
                }
                case R.id.f1b3:{
                    if (comprobarSiHayMina(R.id.f1b3)){
                        minaExplotada(0,2);
                    }
                    break;
                }
                case R.id.f1b4:{
                    if (comprobarSiHayMina(R.id.f1b4)){
                        minaExplotada(0,3);
                    }
                    break;
                }
                case R.id.f1b5:{
                    if (comprobarSiHayMina(R.id.f1b5)){
                        minaExplotada(0,4);
                    }
                    break;
                }
                case R.id.f1b6:{
                    if (comprobarSiHayMina(R.id.f1b6)){
                        minaExplotada(0,5);
                    }
                    break;
                }
                case R.id.f1b7:{
                    if (comprobarSiHayMina(R.id.f1b7)){
                        minaExplotada(0,6);
                    }
                    break;
                }
                case R.id.f1b8:{
                    if (comprobarSiHayMina(R.id.f1b8)){
                        minaExplotada(0,7);
                    }
                    break;
                }

            }
        }
    }

    public boolean comprobarSiHayMina(int id){
        return minas.contains(id);
    }

    public void minaExplotada(int y, int x){
        ImageButton imageButton = requireView().findViewById(idRecuadros[y][x]);
        imageButton.setBackgroundResource(R.drawable.redbomb);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        puedeJugar = false;
    }


}