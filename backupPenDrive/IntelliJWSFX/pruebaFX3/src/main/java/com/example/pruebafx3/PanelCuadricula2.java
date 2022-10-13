package com.example.pruebafx3;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelCuadricula2 extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            GridPane raiz = new GridPane();
            raiz.setHgap(20);
            raiz.setVgap(20);
            raiz.setPadding(new Insets(20));

            Label lbNombre, lbApellidos, lbDni;
            lbNombre = new Label("Nombre:");
            lbApellidos = new Label("Apellidos:");
            lbDni = new Label("DNI:");
            TextField tfNombre, tfApellidos, tfDni;
            tfNombre = new TextField();
            tfApellidos = new TextField();
            tfDni = new TextField();

            raiz.add(lbNombre, 0, 0);
            GridPane.setHalignment(lbNombre, HPos.RIGHT);
            raiz.add(tfNombre, 1, 0);
            raiz.add(lbApellidos, 0, 1);
            GridPane.setHalignment(lbApellidos, HPos.RIGHT);
            raiz.add(tfApellidos, 1, 1);
            raiz.add(lbDni, 0, 2);
            GridPane.setHalignment(lbDni, HPos.RIGHT);
            raiz.add(tfDni, 1, 2);

            Scene escena = new Scene(raiz, 300, 160);
            escenarioPrincipal.setTitle("Panel en cuadrícula");
            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}