package com.example.pruebafx3;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.beans.binding.NumberBinding;


public class IntegerPropertyEjemplo2 extends Application {

    private Button boton;
    private Button boton2;

    private Label etiqueta1;
    private Label etiqueta2;

    private IntegerProperty numPulsaciones1 = (IntegerProperty) new SimpleIntegerProperty(0);
    private IntegerProperty numPulsaciones2 = (IntegerProperty) new SimpleIntegerProperty(0);

    private void botonPulsado() {
        if (numPulsaciones1.getValue() == 0){
            numPulsaciones1.setValue(numPulsaciones1.getValue() + 1);
            etiqueta1.setText("El botón se ha pulsado 1 vez");
        }
        else
            numPulsaciones1.setValue(numPulsaciones1.getValue() + 1);
            etiqueta1.setText("El botón se ha pulsado " + numPulsaciones1.getValue() + " veces");
    }

    private void botonPulsado2() {
        if (numPulsaciones2.getValue() == 0){
            numPulsaciones2.setValue(numPulsaciones2.getValue() + 1);
            etiqueta2.setText("El botón se ha pulsado 1 vez");
        }
        else
            numPulsaciones2.setValue(numPulsaciones2.getValue() + 1);
            etiqueta2.setText("El botón se ha pulsado " + numPulsaciones2.getValue() + " veces");
    }

    @Override
    public void start(Stage escenarioPrincipal) {

        try {
            VBox caja1 = new VBox(30);
            caja1.setPadding(new Insets(10));
            caja1.setAlignment(Pos.CENTER);

            boton = new Button("Púlsame!!!");
            boton.setFont(Font.font("Arial", 16));
            boton.setOnAction(e -> botonPulsado());

            etiqueta1 = new Label("El botón aún no se ha pulsado");
            etiqueta1.setFont(Font.font("Arial", 24));

            caja1.getChildren().addAll(boton, etiqueta1);

            VBox caja2 = new VBox(30);
            caja2.setPadding(new Insets(10));
            caja2.setAlignment(Pos.CENTER);

            boton2 = new Button("Púlsame!!!");
            boton2.setFont(Font.font("Arial", 16));
            boton2.setOnAction(e -> botonPulsado2());

            etiqueta2 = new Label("El botón aún no se ha pulsado");
            etiqueta2.setFont(Font.font("Arial", 24));

            caja2.getChildren().addAll(boton2, etiqueta2);

            Scene escena = new Scene(caja1, 450, 150);
            escenarioPrincipal.setTitle("Pulsaciones del botón");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();

            Stage escenarioSecundario = new Stage();
            Scene escena2 = new Scene(caja2, 450, 150);
            escenarioSecundario.setTitle("Pulsaciones del botón2");
            escenarioSecundario.setScene(escena2);
            escenarioSecundario.show();

            numPulsaciones1.bindBidirectional(numPulsaciones2);

            numPulsaciones1.addListener(new ChangeListener(){
                @Override public void changed(ObservableValue o,Object oldVal,
                                              Object newVal){
                    etiqueta2.setText("El botón se ha pulsado " + numPulsaciones1.getValue() + " veces");
                }
            });
            numPulsaciones2.addListener(new ChangeListener(){
                @Override public void changed(ObservableValue o,Object oldVal,
                                              Object newVal){
                    etiqueta1.setText("El botón se ha pulsado " + numPulsaciones2.getValue() + " veces");
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }






    public static void main(String[] args) {
        launch(args);
    }
}
