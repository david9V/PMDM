package com.example.pruebafx3;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;

public class PropertiesEjemplo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        IntegerProperty numPulsacionesProperties= (IntegerProperty) new SimpleIntegerProperty(0);
        BotonesProperties botonesProperties1 = new BotonesProperties();
        botonesProperties1.setNumPulsacionesProperties(numPulsacionesProperties);

        botonesProperties1.setStage(primaryStage);
        Stage stage2=new Stage();
        BotonesProperties botonesProperties2 = new BotonesProperties();
        botonesProperties2.setNumPulsacionesProperties(numPulsacionesProperties);
        botonesProperties2.setStage(stage2);
        //primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
