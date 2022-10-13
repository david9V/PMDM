package com.example.pruebafx3;

import javafx.application.Application;
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

public class VentanaPulsadorPrueba{

    private Button boton;

    private Label etiqueta;

    private IntegerProperty numPulsaciones = (IntegerProperty) new SimpleIntegerProperty(0);

    public void botonPulsado() {
        if (numPulsaciones.getValue() == 0) {
            numPulsaciones.setValue(numPulsaciones.getValue() + 1);
            etiqueta.setText("El botón se ha pulsado 1 vez");
        } else
            numPulsaciones.setValue(numPulsaciones.getValue() + 1);
        etiqueta.setText("El botón se ha pulsado " + numPulsaciones.getValue() + " veces");
    }

    public VBox getCaja(){
        VBox caja1 = new VBox(30);
        caja1.setPadding(new Insets(10));
        caja1.setAlignment(Pos.CENTER);

        boton = new Button("Púlsame!!!");
        boton.setFont(Font.font("Arial", 16));
        boton.setOnAction(e -> botonPulsado());

        etiqueta = new Label("El botón aún no se ha pulsado");
        etiqueta.setFont(Font.font("Arial", 24));

        caja1.getChildren().addAll(boton, etiqueta);

        return caja1;
    }
}
