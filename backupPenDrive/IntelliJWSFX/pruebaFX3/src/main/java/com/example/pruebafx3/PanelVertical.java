package com.example.pruebafx3;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelVertical extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            VBox raiz = new VBox(10);
            raiz.setPadding(new Insets(10));
            raiz.setAlignment(Pos.CENTER);

            Button bt1, bt2, bt3;
            bt1 = new Button("Botón 1");
            bt2 = new Button("Botón 2");
            bt3 = new Button("Botón 3");

            raiz.getChildren().addAll(bt1, bt2, bt3);

            Scene escena = new Scene(raiz, 250, 150);
            escenarioPrincipal.setTitle("Panel vertical");
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