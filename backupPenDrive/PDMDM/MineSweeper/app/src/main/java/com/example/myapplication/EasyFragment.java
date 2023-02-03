package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EasyFragment extends Fragment implements View.OnClickListener,View.OnLongClickListener {

    Integer[][] idRecuadros;
    List<List<Integer>> idComoLista;
    List<Integer> minas;
    Integer[] idFila1;
    Integer[] idFila2;
    Integer[] idFila3;
    Integer[] idFila4;
    Integer[] idFila5;
    Integer[] idFila6;
    Integer[] idFila7;
    Integer[] idFila8;
    boolean puedeJugar;
    boolean ganar;
    boolean primerMovimiento;
    Condicion condicion;
    int p = 0;
    int nCasillasParaGanar = 0;
    ImageView cara;

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

        condicion = new Condicion();
        puedeJugar = true;
        ganar = false;
        primerMovimiento = true;
        implementarListeners();
        rellenarIds();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void rellenarIds() {
        idRecuadros = new Integer[8][8];
        idFila1 = new Integer[]{R.id.f1b1, R.id.f1b2, R.id.f1b3, R.id.f1b4, R.id.f1b5, R.id.f1b6, R.id.f1b7, R.id.f1b8};
        idFila2 = new Integer[]{R.id.f2b1, R.id.f2b2, R.id.f2b3, R.id.f2b4, R.id.f2b5, R.id.f2b6, R.id.f2b7, R.id.f2b8};
        idFila3 = new Integer[]{R.id.f3b1, R.id.f3b2, R.id.f3b3, R.id.f3b4, R.id.f3b5, R.id.f3b6, R.id.f3b7, R.id.f3b8};
        idFila4 = new Integer[]{R.id.f4b1, R.id.f4b2, R.id.f4b3, R.id.f4b4, R.id.f4b5, R.id.f4b6, R.id.f4b7, R.id.f4b8};
        idFila5 = new Integer[]{R.id.f5b1, R.id.f5b2, R.id.f5b3, R.id.f5b4, R.id.f5b5, R.id.f5b6, R.id.f5b7, R.id.f5b8};
        idFila6 = new Integer[]{R.id.f6b1, R.id.f6b2, R.id.f6b3, R.id.f6b4, R.id.f6b5, R.id.f6b6, R.id.f6b7, R.id.f6b8};
        idFila7 = new Integer[]{R.id.f7b1, R.id.f7b2, R.id.f7b3, R.id.f7b4, R.id.f7b5, R.id.f7b6, R.id.f7b7, R.id.f7b8};
        idFila8 = new Integer[]{R.id.f8b1, R.id.f8b2, R.id.f8b3, R.id.f8b4, R.id.f8b5, R.id.f8b6, R.id.f8b7, R.id.f8b8};

        idRecuadros[0] = idFila1;
        idRecuadros[1] = idFila2;
        idRecuadros[2] = idFila3;
        idRecuadros[3] = idFila4;
        idRecuadros[4] = idFila5;
        idRecuadros[5] = idFila6;
        idRecuadros[6] = idFila7;
        idRecuadros[7] = idFila8;

        idComoLista = new ArrayList<>();
        idComoLista.add(Arrays.asList(idFila1));
        idComoLista.add(Arrays.asList(idFila2));
        idComoLista.add(Arrays.asList(idFila3));
        idComoLista.add(Arrays.asList(idFila4));
        idComoLista.add(Arrays.asList(idFila5));
        idComoLista.add(Arrays.asList(idFila6));
        idComoLista.add(Arrays.asList(idFila7));
        idComoLista.add(Arrays.asList(idFila8));
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

        f1b1.setOnLongClickListener(this);
        f1b2.setOnLongClickListener(this);
        f1b3.setOnLongClickListener(this);
        f1b4.setOnLongClickListener(this);
        f1b5.setOnLongClickListener(this);
        f1b6.setOnLongClickListener(this);
        f1b7.setOnLongClickListener(this);
        f1b8.setOnLongClickListener(this);

        f2b1.setOnLongClickListener(this);
        f2b2.setOnLongClickListener(this);
        f2b3.setOnLongClickListener(this);
        f2b4.setOnLongClickListener(this);
        f2b5.setOnLongClickListener(this);
        f2b6.setOnLongClickListener(this);
        f2b7.setOnLongClickListener(this);
        f2b8.setOnLongClickListener(this);

        f3b1.setOnLongClickListener(this);
        f3b2.setOnLongClickListener(this);
        f3b3.setOnLongClickListener(this);
        f3b4.setOnLongClickListener(this);
        f3b5.setOnLongClickListener(this);
        f3b6.setOnLongClickListener(this);
        f3b7.setOnLongClickListener(this);
        f3b8.setOnLongClickListener(this);

        f4b1.setOnLongClickListener(this);
        f4b2.setOnLongClickListener(this);
        f4b3.setOnLongClickListener(this);
        f4b4.setOnLongClickListener(this);
        f4b5.setOnLongClickListener(this);
        f4b6.setOnLongClickListener(this);
        f4b7.setOnLongClickListener(this);
        f4b8.setOnLongClickListener(this);

        f5b1.setOnLongClickListener(this);
        f5b2.setOnLongClickListener(this);
        f5b3.setOnLongClickListener(this);
        f5b4.setOnLongClickListener(this);
        f5b5.setOnLongClickListener(this);
        f5b6.setOnLongClickListener(this);
        f5b7.setOnLongClickListener(this);
        f5b8.setOnLongClickListener(this);

        f6b1.setOnLongClickListener(this);
        f6b2.setOnLongClickListener(this);
        f6b3.setOnLongClickListener(this);
        f6b4.setOnLongClickListener(this);
        f6b5.setOnLongClickListener(this);
        f6b6.setOnLongClickListener(this);
        f6b7.setOnLongClickListener(this);
        f6b8.setOnLongClickListener(this);

        f7b1.setOnLongClickListener(this);
        f7b2.setOnLongClickListener(this);
        f7b3.setOnLongClickListener(this);
        f7b4.setOnLongClickListener(this);
        f7b5.setOnLongClickListener(this);
        f7b6.setOnLongClickListener(this);
        f7b7.setOnLongClickListener(this);
        f7b8.setOnLongClickListener(this);

        f8b1.setOnLongClickListener(this);
        f8b2.setOnLongClickListener(this);
        f8b3.setOnLongClickListener(this);
        f8b4.setOnLongClickListener(this);
        f8b5.setOnLongClickListener(this);
        f8b6.setOnLongClickListener(this);
        f8b7.setOnLongClickListener(this);
        f8b8.setOnLongClickListener(this);

        cara = requireView().findViewById(R.id.cara);
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
        if (primerMovimiento){
            limpiarEspacio(id);
            primerMovimiento = false;
        }
        else if (puedeJugar){
            if (comprobarSiHayMina(id)){
                minaExplotada(id);
            }
            else{
                limpiarEspacio(id);
            }

        }
    }

    public boolean comprobarSiHayMina(int id){
        return minas.contains(id);
    }

    public void minaExplotada(int id){
        ImageButton imageButton = requireView().findViewById(id);
        imageButton.setBackgroundResource(R.drawable.redbomb);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);

        puedeJugar = false;

        minas.remove((Integer) id);

        for (int i = 0; i < minas.size(); i++){
            imageButton = requireView().findViewById(minas.get(i));
            imageButton.setBackgroundResource(R.drawable.bomb);
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        cara.setBackgroundResource(R.drawable.caralose);
    }

    public void limpiarEspacio(int id){
        if (!ganar){
            cara.setBackgroundResource(R.drawable.cara2);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!ganar)
                        cara.setBackgroundResource(R.drawable.cara1);
                }
            }, 300);
        }


        ImageButton imageButton = requireView().findViewById(id);
        imageButton.setBackgroundResource(R.drawable.empty);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);

        if (primerMovimiento){
            rellenarConMinas();
        }
        int k = 0;
        int y = 0;
        int x = 0;

        for (List<Integer> fila : idComoLista){
            if (fila.contains(id)){
                y = k;
                x = fila.indexOf(id);
            }
            else
                k++;

        }
        //Toast.makeText(getContext(),"pos x" + x + "pos y" + y,Toast.LENGTH_SHORT).show();
        //CHECKEAR CUANTAS MINAS HAY ALREDEDOR
        limpiarEspacioAutomatico(x, y);
        p=0;
        if (nCasillasParaGanar == 56){
            puedeJugar = false;
            ganar = true;
        }

        if (ganar)
            ganar();
    }

    public void ganar(){
        cara.setBackgroundResource(R.drawable.carawin);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle("¡Has ganado!");
        builder.setMessage("¡Felicidades!");
        builder.setPositiveButton("Aceptar",
                (dialog, which) -> {
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void limpiarEspacioAutomatico(int x, int y){
        int minasCercanas = 0;
        int xX = x;
        int yY = y;
        String pos = "";
        if (x > 0 && x < 7 && y > 0 && y < 7){ // centro
            pos = "centro";
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }
        else if(x < 1 && y < 1){ // esquina superior izda
            pos = "arribaizquierda";
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }
        else if (x > 6 & y < 1){// esquina superior dcha
            pos = "arribaderecha";
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }
        else if (x < 1 && y > 6){ // esquina inferior izda
            pos = "abajoizquierda";
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }
        else if (x > 6 && y > 6){// esquina inferior dcha
            pos = "abajoderecha";
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }
        else if (x == 0){ // borde izdo
            pos = "izquierda";
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y--;y--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }
        else if (x == 7){ // borde dcho
            pos = "derecha";
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y--;y--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }
        else if (y == 0){ //borde superior
            pos = "arriba";
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }
        else if (y == 7){ // borde inferior
            pos = "abajo";
            x--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y--;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            x++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
            y++;
            if (minas.contains(idRecuadros[y][x])){
                minasCercanas++;
            }
        }

        y = yY;
        x = xX;

        ImageButton imageButton = requireView().findViewById(idRecuadros[y][x]);
        if (minasCercanas == 0 && imageButton.isEnabled()){
            imageButton.setBackgroundResource(R.drawable.empty);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else if (minasCercanas == 1 && imageButton.isEnabled()){
            imageButton.setBackgroundResource(R.drawable.mine1);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else if (minasCercanas == 2 && imageButton.isEnabled()){
            imageButton.setBackgroundResource(R.drawable.mine2);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else if (minasCercanas == 3 && imageButton.isEnabled()){
            imageButton.setBackgroundResource(R.drawable.mine3);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else if (minasCercanas == 4 && imageButton.isEnabled()){
            imageButton.setBackgroundResource(R.drawable.mine4);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else if (minasCercanas == 5 && imageButton.isEnabled()){
            imageButton.setBackgroundResource(R.drawable.mine5);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else if (minasCercanas == 6 && imageButton.isEnabled()){
            imageButton.setBackgroundResource(R.drawable.mine6);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else if (minasCercanas == 7 && imageButton.isEnabled()){
            imageButton.setBackgroundResource(R.drawable.mine7);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else if (imageButton.isEnabled()) {
            imageButton.setBackgroundResource(R.drawable.mine8);
            imageButton.setEnabled(false);
            nCasillasParaGanar++;
            imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        System.out.println(nCasillasParaGanar);
        p++;
        if (minasCercanas == 0 && p < 30){
            switch (pos) {
                case "centro":
                    if (!condicion.isArribaDerecha()){
                        limpiarEspacioAutomatico(x + 1, y - 1);
                        condicion.setArribaDerecha(true);
                    }
                    if (!condicion.isDerecha()){
                        limpiarEspacioAutomatico(x + 1, y);
                        condicion.setDerecha(true);
                    }
                    if (!condicion.isArriba()){
                        limpiarEspacioAutomatico(x, y - 1);
                        condicion.setArriba(true);
                    }
                    if (!condicion.isIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y);
                        condicion.setIzquierda(true);
                    }
                    if (!condicion.isAbajo()){
                        limpiarEspacioAutomatico(x, y + 1);
                        condicion.setAbajo(true);
                    }
                    if (!condicion.isArribaIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y - 1);
                        condicion.setArribaIzquierda(true);
                    }
                    if (!condicion.isAbajoDerecha()){
                        limpiarEspacioAutomatico(x + 1, y + 1);
                        condicion.setAbajoDerecha(true);
                    }
                    if (!condicion.isAbajoIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y + 1);
                        condicion.setAbajoIzquierda(true);
                    }
                    break;
                case "arribaderecha":
                    if (!condicion.isAbajo()){
                        limpiarEspacioAutomatico(x, y + 1);
                        condicion.setAbajo(true);
                    }
                    if (!condicion.isIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y);
                        condicion.setIzquierda(true);
                    }
                    if (!condicion.isAbajoIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y + 1);
                        condicion.setAbajoIzquierda(true);
                    }
                    break;
                case "arribaizquierda":
                    if (!condicion.isAbajo()){
                        limpiarEspacioAutomatico(x, y + 1);
                        condicion.setAbajo(true);
                    }
                    if (!condicion.isDerecha()){
                        limpiarEspacioAutomatico(x + 1, y);
                        condicion.setDerecha(true);
                    }
                    if (!condicion.isAbajoDerecha()){
                        limpiarEspacioAutomatico(x + 1, y + 1);
                        condicion.setAbajoDerecha(true);
                    }
                    break;
                case "abajoderecha":
                    if (!condicion.isArriba()){
                        limpiarEspacioAutomatico(x, y - 1);
                        condicion.setArriba(true);
                    }
                    if (!condicion.isIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y);
                        condicion.setIzquierda(true);
                    }
                    if (!condicion.isArribaIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y - 1);
                        condicion.setArribaIzquierda(true);
                    }
                    break;
                case "abajoizquierda":
                    if (!condicion.isArriba()){
                        limpiarEspacioAutomatico(x, y - 1);
                        condicion.setArriba(true);
                    }
                    if (!condicion.isDerecha()){
                        limpiarEspacioAutomatico(x + 1, y);
                        condicion.setDerecha(true);
                    }
                    if (!condicion.isArribaDerecha()){
                        limpiarEspacioAutomatico(x + 1, y - 1);
                        condicion.setArribaDerecha(true);
                    }
                    break;
                case "derecha":
                    if (!condicion.isArriba()){
                        limpiarEspacioAutomatico(x, y - 1);
                        condicion.setArriba(true);
                    }
                    if (!condicion.isIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y);
                        condicion.setIzquierda(true);
                    }
                    if (!condicion.isAbajo()){
                        limpiarEspacioAutomatico(x, y + 1);
                        condicion.setAbajo(true);
                    }
                    if (!condicion.isAbajoIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y + 1);
                        condicion.setAbajoIzquierda(true);
                    }
                    if (!condicion.isArribaIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y - 1);
                        condicion.setArribaIzquierda(true);
                    }
                    break;
                case "izquierda":
                    if (!condicion.isArriba()){
                        limpiarEspacioAutomatico(x, y - 1);
                        condicion.setArriba(true);
                    }
                    if (!condicion.isDerecha()){
                        limpiarEspacioAutomatico(x + 1, y);
                        condicion.setDerecha(true);
                    }
                    if (!condicion.isAbajo()){
                        limpiarEspacioAutomatico(x, y + 1);
                        condicion.setAbajo(true);
                    }
                    if (!condicion.isArribaDerecha()){
                        limpiarEspacioAutomatico(x + 1, y - 1);
                        condicion.setArribaDerecha(true);
                    }
                    if (!condicion.isAbajoDerecha()){
                        limpiarEspacioAutomatico(x + 1, y + 1);
                        condicion.setAbajoDerecha(true);
                    }
                    break;
                case "arriba":
                    if (!condicion.isDerecha()){
                        limpiarEspacioAutomatico(x + 1, y);
                        condicion.setDerecha(true);
                    }
                    if (!condicion.isAbajo()){
                        limpiarEspacioAutomatico(x, y + 1);
                        condicion.setAbajo(true);
                    }
                    if (!condicion.isIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y);
                        condicion.setIzquierda(true);
                    }
                    if (!condicion.isAbajoIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y + 1);
                        condicion.setAbajoIzquierda(true);
                    }
                    if (!condicion.isAbajoDerecha()){
                        limpiarEspacioAutomatico(x + 1, y + 1);
                        condicion.setAbajoDerecha(true);
                    }
                    break;
                case "abajo":
                    if (!condicion.isDerecha()){
                        limpiarEspacioAutomatico(x + 1, y);
                        condicion.setDerecha(true);
                    }
                    if (!condicion.isIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y);
                        condicion.setIzquierda(true);
                    }
                    if (!condicion.isArribaDerecha()){
                        limpiarEspacioAutomatico(x + 1, y - 1);
                        condicion.setArribaDerecha(true);
                    }
                    if (!condicion.isArriba()){
                        limpiarEspacioAutomatico(x, y - 1);
                        condicion.setArriba(true);
                    }
                    if (!condicion.isArribaIzquierda()){
                        limpiarEspacioAutomatico(x - 1, y - 1);
                        condicion.setArribaIzquierda(true);
                    }
                    break;
            }
        }
        condicion.reset();
    }

    public boolean noTieneFondo(int id) {
        ImageButton imageButton = requireView().findViewById(id);
        return imageButton.isEnabled();
    }

    public void ponerBandera(int id) {
        ImageButton imageButton = requireView().findViewById(id);
        imageButton.setBackgroundResource(R.drawable.flag2);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onLongClick(View v) {
        int id = v.getId();
        if (noTieneFondo(id))
            ponerBandera(id);
        return true;
    }

}