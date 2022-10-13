package com.example.pruebafx3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ActividadGirdPane extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        try {
            GridPane raiz = new GridPane();
            raiz.setHgap(20);
            raiz.setVgap(20);
            raiz.setPadding(new Insets(20));

            Label lbElige1;
            lbElige1 = new Label("Elige el tamaño:");
            lbElige1.setFont(Font.font(20));

            Label lbElige2;
            lbElige2 = new Label("Elige los extras:");
            lbElige2.setFont(Font.font(20));

            Label lbElige3;
            lbElige3 = new Label("Elige los extras:");
            lbElige3.setFont(Font.font(20));

            Label lbElige4;
            lbElige4 = new Label("Elige los extras:");
            lbElige4.setFont(Font.font(20));

            ToggleButton tbNavegador, tbManosLibres, tbLunas;
            ToggleButton tbNavegador2, tbManosLibres2, tbLunas2;
            tbNavegador = new ToggleButton("Navegador");
            tbManosLibres = new ToggleButton("Manos libres");
            tbLunas = new ToggleButton("Lunas tintadas");
            tbNavegador2 = new ToggleButton("Navegador2");
            tbManosLibres2 = new ToggleButton("Manos libres2");
            tbLunas2 = new ToggleButton("Lunas tintadas2");

            RadioButton rbGrande, rbMediano, rbPequeno;
            rbGrande = new RadioButton("Grande");
            rbMediano = new RadioButton("Mediano");
            rbMediano.setSelected(true);
            rbPequeno = new RadioButton("Pequeño");

            ToggleGroup tamanos = new ToggleGroup();
            rbGrande.setToggleGroup(tamanos);
            rbMediano.setToggleGroup(tamanos);
            rbPequeno.setToggleGroup(tamanos);

            CheckBox cbNavegador, cbManosLibres, cbLunas;
            cbNavegador = new CheckBox("Navegador");
            cbManosLibres = new CheckBox("Manos libres");
            cbLunas = new CheckBox("Lunas tintadas");

            ChoiceBox<String> cbExtras1 = new ChoiceBox<String>();
            cbExtras1.setItems(FXCollections.observableArrayList("Navegador", "Manos libres", "Lunas tintadas"));

            ComboBox<String> cbExtras2 = new ComboBox<String>();
            cbExtras2.setVisibleRowCount(2);
            cbExtras2.setItems(FXCollections.observableArrayList("Navegador", "Manos libres", "Lunas tintadas"));

            HBox panelBotones1 = new HBox();
            panelBotones1.setSpacing(10);
            panelBotones1.getChildren().addAll(tbNavegador, tbManosLibres, tbLunas);
            panelBotones1.setAlignment(Pos.CENTER);

            HBox panelBotones2 = new HBox();
            panelBotones2.setSpacing(10);
            panelBotones2.getChildren().addAll(tbNavegador2, tbManosLibres2, tbLunas2);
            panelBotones2.setAlignment(Pos.CENTER);

            HBox panelEtiquetas = new HBox();
            panelEtiquetas.setSpacing(10);
            panelEtiquetas.getChildren().addAll(lbElige1,lbElige2,lbElige3,lbElige4);
            panelEtiquetas.setSpacing(30);

            HBox panel1 = new HBox();
            panel1.setSpacing(95);
            panel1.getChildren().addAll(rbPequeno,cbNavegador,cbExtras1,cbExtras2);

            HBox panel2 = new HBox();
            panel2.setSpacing(95);
            panel2.getChildren().addAll(rbMediano,cbManosLibres);

            HBox panel3 = new HBox();
            panel3.setSpacing(95);
            panel3.getChildren().addAll(rbGrande,cbLunas);

            raiz.add(panelBotones1,0,0);
            raiz.add(panelBotones2,0,1);
            raiz.add(panelEtiquetas,0,2);
            raiz.add(panel1,0,3);
            raiz.add(panel2,0,4);
            raiz.add(panel3,0,5);
            GridPane.setColumnSpan(panelBotones2, 1);

            Scene escena = new Scene(raiz, 820, 350);
            escenarioPrincipal.setTitle("Ejemplo 1");
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