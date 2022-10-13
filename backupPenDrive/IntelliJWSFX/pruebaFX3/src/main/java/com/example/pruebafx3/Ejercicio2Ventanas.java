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


public class Ejercicio2Ventanas {

    public static void main(String[] args) {
        VentanaPulsadorPrueba v1 = new VentanaPulsadorPrueba();
        VentanaPulsadorPrueba v2 = new VentanaPulsadorPrueba();
        Stage s1 = new Stage();
        Stage s2 = new Stage();

        Scene escena = new Scene(v1.getCaja(), 450, 150);
        s1.setTitle("Pulsaciones del botón");
        s1.setScene(escena);
        s1.show();

        Scene escena2 = new Scene(v2.getCaja(), 450, 150);
        s2.setTitle("Pulsaciones del botón 2");
        s2.setScene(escena);
        s2.show();
    }
}
