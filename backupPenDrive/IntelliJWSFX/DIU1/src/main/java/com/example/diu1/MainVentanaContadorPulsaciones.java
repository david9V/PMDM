package com.example.diu1;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainVentanaContadorPulsaciones extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;

    public MainVentanaContadorPulsaciones() {
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ContadorPulsaciones");
        this.initRootLayout();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainVentanaContadorPulsaciones.class.getResource("/com/example/diu1/ContadorVentanaPulsaciones.fxml"));
            this.rootLayout = (AnchorPane)loader.load();
            Scene scene = new Scene(this.rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}