package com.example.prueba2.proyectoCalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button n0, n1, n2, n3, n4, n5, n6,  n7, n8, n9, nIgual, nRestar, nSumar, nDividir, nMultiplicar;
    Button nBorrar, nRaiz, nPorcentaje, nPunto;
    TextView resultado;
    Boolean suma;
    Boolean resta;
    Boolean multiplicacion;
    Boolean division;
    Boolean raiz;
    Boolean porcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculadora);

        suma = false;
        resta = false;
        multiplicacion = false;
        division = false;
        raiz = false;
        porcentaje = false;

        resultado = findViewById(R.id.res);
        resultado.setText("0");

        n0 = findViewById(R.id.b0);
        n0.setOnClickListener(this);
        n1 = findViewById(R.id.b1);
        n1.setOnClickListener(this);
        n2 = findViewById(R.id.b2);
        n2.setOnClickListener(this);
        n3 = findViewById(R.id.b3);
        n3.setOnClickListener(this);
        n4 = findViewById(R.id.b4);
        n4.setOnClickListener(this);
        n5 = findViewById(R.id.b5);
        n5.setOnClickListener(this);
        n6 = findViewById(R.id.b6);
        n6.setOnClickListener(this);
        n7 = findViewById(R.id.b7);
        n7.setOnClickListener(this);
        n8 = findViewById(R.id.b8);
        n8.setOnClickListener(this);
        n9 = findViewById(R.id.b9);
        n9.setOnClickListener(this);
        nIgual = findViewById(R.id.bIgual);
        nIgual.setOnClickListener(this);
        nRestar = findViewById(R.id.bRes);
        nRestar.setOnClickListener(this);
        nSumar = findViewById(R.id.bSum);
        nSumar.setOnClickListener(this);
        nDividir = findViewById(R.id.bDiv);
        nDividir.setOnClickListener(this);
        nMultiplicar = findViewById(R.id.bMult);
        nMultiplicar.setOnClickListener(this);
        nBorrar = findViewById(R.id.bC);
        nBorrar.setOnClickListener(this);
        nRaiz = findViewById(R.id.bRaiz);
        nRaiz.setOnClickListener(this);
        nPorcentaje = findViewById(R.id.bPercent);
        nPorcentaje.setOnClickListener(this);
        nPunto = findViewById(R.id.bDot);
        nPunto.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String check;

        if (id == R.id.b0){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("0");
            } else resultado.append("0");
        }
        if (id == R.id.b1){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("1");
            } else resultado.append("1");
        }
        if (id == R.id.b2){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("2");
            } else resultado.append("2");
        }
        if (id == R.id.b3){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("3");
            }else resultado.append("3");
        }
        if (id == R.id.b4){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("4");
            } else  resultado.append("4");
        }
        if (id == R.id.b5){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("5");
            } else resultado.append("5");
        }
        if (id == R.id.b6){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("6");
            } else resultado.append("6");
        }
        if (id == R.id.b7){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("7");
            } else resultado.append("7");
        }
        if (id == R.id.b8){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("8");
            } resultado.append("8");
        }
        if (id == R.id.b9){
            if (sustituirNumInicial(resultado.getText().toString())){
                resultado.setText("9");
            } else resultado.append("9");
        }
        if (id == R.id.bIgual){
            if (suma){
                resultado.setText(String.valueOf(calcularSuma((resultado.getText().toString()))));
            } else if (resta){
                resultado.setText(String.valueOf(calcularResta((resultado.getText().toString()))));
            } else if(multiplicacion){
                resultado.setText(String.valueOf(calcularMultiplicacion((resultado.getText().toString()))));
            } else if (division){
                resultado.setText(String.valueOf(calcularDivision((resultado.getText().toString()))));
            } else if (raiz) {
                resultado.setText(String.valueOf(calcularRaiz((resultado.getText().toString()))));
            } else if (porcentaje){
                resultado.setText(String.valueOf(calcularPorcentaje((resultado.getText().toString()))));
            }

            suma = false;
            resta = false;
            multiplicacion = false;
            division = false;
            raiz = false;
            porcentaje = false;
        }
        if (id == R.id.bSum && !sustituirNumInicial(resultado.getText().toString())){
            check = resultado.getText().toString();
            if (check.charAt(check.length() - 1) != '+'){
                if(check.charAt(check.length() - 1) == 'x' || check.charAt(check.length() - 1) == '/' || check.charAt(check.length() - 1) == '-' || check.charAt(check.length() - 1) == '%' || check.charAt(check.length() - 1) == '√'){
                    String aux = check.substring(0, check.length() - 1);
                    aux += "+";
                    resultado.setText(aux);
                }  else { // se pone el mas
                    resultado.append("+");
                }
            }

            suma = true;
            resta = false;
            multiplicacion = false;
            division = false;
            raiz = false;
            porcentaje = false;
        }
        if (id == R.id.bRes && !sustituirNumInicial(resultado.getText().toString())){
            check = resultado.getText().toString();
            if (check.charAt(check.length() - 1) != '-'){
                if(check.charAt(check.length() - 1) == 'x' || check.charAt(check.length() - 1) == '/' || check.charAt(check.length() - 1) == '+' || check.charAt(check.length() - 1) == '%' || check.charAt(check.length() - 1) == '√'){
                    String aux = check.substring(0, check.length() - 1);
                    aux += "-";
                    resultado.setText(aux);
                }  else { // se pone el mas
                    resultado.append("-");
                }
            }

            suma = false;
            resta = true;
            multiplicacion = false;
            division = false;
            raiz = false;
            porcentaje = false;
        }
        if (id == R.id.bDiv && !sustituirNumInicial(resultado.getText().toString())){
            check = resultado.getText().toString();
            if (check.charAt(check.length() - 1) != '/'){
                if(check.charAt(check.length() - 1) == 'x' || check.charAt(check.length() - 1) == '+' || check.charAt(check.length() - 1) == '-' || check.charAt(check.length() - 1) == '%' || check.charAt(check.length() - 1) == '√'){
                    String aux = check.substring(0, check.length() - 1);
                    aux += "/";
                    resultado.setText(aux);
                }  else { // se pone el mas
                    resultado.append("/");
                }
            }

            suma = false;
            resta = false;
            multiplicacion = false;
            division = true;
            raiz = false;
            porcentaje = false;
        }
        if (id == R.id.bMult && !sustituirNumInicial(resultado.getText().toString())){
            check = resultado.getText().toString();
            if (check.charAt(check.length() - 1) != 'x'){
                if(check.charAt(check.length() - 1) == '+' || check.charAt(check.length() - 1) == '/' || check.charAt(check.length() - 1) == '-' || check.charAt(check.length() - 1) == '%' || check.charAt(check.length() - 1) == '√'){
                    String aux = check.substring(0, check.length() - 1);
                    aux += "x";
                    resultado.setText(aux);
                }  else { // se pone el mas
                    resultado.append("x");
                }
            }

            suma = false;
            resta = false;
            multiplicacion = true;
            division = false;
            raiz = false;
            porcentaje = false;
        }
        if (id == R.id.bC){
            check = resultado.getText().toString();
            if(check.length() > 0){
                String aux = check.substring(0, check.length() - 1);
                resultado.setText(aux);
            }
        }
        if (id == R.id.bRaiz && !sustituirNumInicial(resultado.getText().toString())){
            check = resultado.getText().toString();
            if (check.charAt(check.length() - 1) != '√'){
                if(check.charAt(check.length() - 1) == '+' || check.charAt(check.length() - 1) == '/' || check.charAt(check.length() - 1) == '-' || check.charAt(check.length() - 1) == '%' || check.charAt(check.length() - 1) == 'x'){
                    String aux = check.substring(0, check.length() - 1);
                    aux += "√";
                    resultado.setText(aux);
                }  else { // se pone el mas
                    resultado.append("√");
                }
            }

            suma = false;
            resta = false;
            multiplicacion = false;
            division = false;
            raiz = true;
            porcentaje = false;
        }

        if (id == R.id.bPercent && !sustituirNumInicial(resultado.getText().toString())){
            check = resultado.getText().toString();
            if (check.charAt(check.length() - 1) != '%'){
                if(check.charAt(check.length() - 1) == '+' || check.charAt(check.length() - 1) == '/' || check.charAt(check.length() - 1) == '-' || check.charAt(check.length() - 1) == '√' || check.charAt(check.length() - 1) == 'x'){
                    String aux = check.substring(0, check.length() - 1);
                    aux += "%";
                    resultado.setText(aux);
                }  else { // se pone el mas
                    resultado.append("%");
                }
            }

            suma = false;
            resta = false;
            multiplicacion = false;
            division = false;
            raiz = false;
            porcentaje = true;
        }
        if (id == R.id.bDot && !sustituirNumInicial(resultado.getText().toString())){
            check = resultado.getText().toString();
            if (check.charAt(check.length() - 1) != '.'){
                if(check.charAt(check.length() - 1) == '+' || check.charAt(check.length() - 1) == '/' || check.charAt(check.length() - 1) == '-' || check.charAt(check.length() - 1) == '√' || check.charAt(check.length() - 1) == 'x' || check.charAt(check.length() - 1) == '%'){
                    String aux = check.substring(0, check.length() - 1);
                    aux += ".";
                    resultado.setText(aux);
                }  else { // se pone el mas
                    resultado.append(".");
                }
            }
        }
    }

    public boolean sustituirNumInicial(String s){
        return s.equals("0");
    }

    public double calcularSuma(String s){
        double res = 0;

        boolean numero = false; //para buscar primero un num y luego otro

        String num1 = "";
        String num2 = "";

        for(int i = 0; i < s.length(); i++){
            if (!numero){
                if(s.charAt(i) != '+'){
                    num1 += s.charAt(i);
                } else{
                    numero = true;
                }
            } else{
                if(s.charAt(i) != '+'){
                    num2 += s.charAt(i);
                }
            }
        }

        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);

        res = numero1 + numero2;

        return res;
    }

    public double calcularResta(String s){
        double res = 0;

        boolean numero = false; //para buscar primero un num y luego otro

        String num1 = "";
        String num2 = "";

        for(int i = 0; i < s.length(); i++){
            if (!numero){
                if(s.charAt(i) != '-'){
                    num1 += s.charAt(i);
                } else{
                    numero = true;
                }
            } else{
                if(s.charAt(i) != '-'){
                    num2 += s.charAt(i);
                }
            }
        }

        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);

        res = numero1 - numero2;

        return res;
    }

    public double calcularMultiplicacion(String s){
        double res = 0;

        boolean numero = false; //para buscar primero un num y luego otro

        String num1 = "";
        String num2 = "";

        for(int i = 0; i < s.length(); i++){
            if (!numero){
                if(s.charAt(i) != 'x'){
                    num1 += s.charAt(i);
                } else{
                    numero = true;
                }
            } else{
                if(s.charAt(i) != 'x'){
                    num2 += s.charAt(i);
                }
            }
        }

        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);

        res = numero1 * numero2;

        return res;
    }

    public double calcularDivision(String s){
        double res = 0;

        boolean numero = false; //para buscar primero un num y luego otro

        String num1 = "";
        String num2 = "";

        for(int i = 0; i < s.length(); i++){
            if (!numero){
                if(s.charAt(i) != '/'){
                    num1 += s.charAt(i);
                } else{
                    numero = true;
                }
            } else{
                if(s.charAt(i) != '/'){
                    num2 += s.charAt(i);
                }
            }
        }

        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);

        res = numero1 / numero2;

        return res;
    }

    public double calcularRaiz(String s){
        double res = 0;


        String num = "";

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '√') {
                num += s.charAt(i);
            }
        }

        double numero = Double.parseDouble(num);

        res = Math.sqrt(numero);

        return res;
    }

    public double calcularPorcentaje(String s){
        double res = 0;

        String num = "";

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '√') {
                num += s.charAt(i);
            }
        }

        double numero = Double.parseDouble(num);

        res = numero / 100;

        return res;
    }
}

/*
String cadena = myTextView.getText().ToString()
myTextView.append("4")
 */