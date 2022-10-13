package com.example.diu1;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.Optional;


public class MainTablaJunto extends Application {

    public static class Personaje {
        private final SimpleStringProperty nombre;
        private final SimpleStringProperty apellidos;

        private Personaje(String nombre, String apellidos) {
            this.nombre = new SimpleStringProperty(nombre);
            this.apellidos = new SimpleStringProperty(apellidos);
        }

        public String getNombre() {
            return nombre.get();
        }

        public void setNombre(String nombre) {
            this.nombre.set(nombre);
        }

        public String getApellidos() {
            return apellidos.get();
        }

        public void setApellidos(String apellidos) {
            this.apellidos.set(apellidos);
        }

    }

    private TableView<Personaje> tvPersonajes;
    final ObservableList<Personaje> personajes = FXCollections.observableArrayList(
            new Personaje("Pepito", "Grillo"),
            new Personaje("Bob", "Esponja"),
            new Personaje("Juan", "Sin Miedo"),
            new Personaje("Perico", "De Los Palotes"),
            new Personaje("Juana", "La Loca"));

    TableColumn<Personaje, String> columnaNombre = new TableColumn<Personaje, String>("Nombre");

    TableColumn<Personaje, String> columnaApellidos = new TableColumn<Personaje, String>("Apellidos");

    SimpleDoubleProperty numPersonajesProperty = new SimpleDoubleProperty();


    TextField tc1;
    TextField tc2;

    @Override
    public void start(Stage escenarioPrincipal) {
        numPersonajesProperty.set(personajes.size() * 0.1);
        try {
            VBox caja1 = new VBox();
            caja1.setPadding(new Insets(40));
            caja1.setSpacing(10);

            VBox caja2 = new VBox();
            caja2.setPadding(new Insets(40));
            caja2.setSpacing(10);

            GridPane raiz = new GridPane();
            raiz.add(caja1, 0, 0);
            raiz.add(caja2, 1, 0);

            Label lbPersonajes = new Label("Personajes:");
            tvPersonajes = new TableView<Personaje>();
            tvPersonajes.getColumns().add(columnaNombre);
            tvPersonajes.getColumns().add(columnaApellidos);
            tvPersonajes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            columnaNombre.setMinWidth(100);
            columnaNombre.setCellValueFactory(new PropertyValueFactory<Personaje, String>("Nombre"));
            columnaApellidos.setMinWidth(100);
            columnaApellidos.setCellValueFactory(new PropertyValueFactory<Personaje, String>("Apellidos"));
            tvPersonajes.setMaxWidth(250);
            tvPersonajes.setItems(personajes);

            HBox progresoTabla = new HBox(10);
            progresoTabla.setAlignment(Pos.BOTTOM_CENTER);
            //Label pt1 = new Label(String.valueOf(tvPersonajes.getItems().size() * 10) + "%");
            ProgressBar pb1 = new ProgressBar();
            pb1.progressProperty().bind(numPersonajesProperty);
            ProgressIndicator pi1 = new ProgressIndicator();
            pi1.progressProperty().bind(numPersonajesProperty);
            progresoTabla.getChildren().addAll(pb1, pi1);

            HBox botones = new HBox(50);
            botones.setAlignment(Pos.BOTTOM_CENTER);
            Button aceptar = new Button();
            aceptar.setText("Aceptar");
            aceptar.setId("btnAceptar");
            aceptar.setOnAction(e -> añadirPersona());
            Button eliminar = new Button();
            eliminar.setText("Eliminar");
            eliminar.setId("btnEliminar");
            eliminar.setOnAction(e -> eliminarPersona());
            botones.getChildren().addAll(aceptar, eliminar);

            HBox campo1 = new HBox(10);
            Label lc1 = new Label("Nombre");
            tc1 = new TextField();
            campo1.getChildren().addAll(lc1, tc1);

            HBox campo2 = new HBox(10);
            Label lc2 = new Label("Apellidos");
            tc2  = new TextField();
            campo2.getChildren().addAll(lc2, tc2);

            caja1.getChildren().addAll(lbPersonajes, tvPersonajes, progresoTabla, botones);
            caja2.getChildren().addAll(campo1, campo2);

            Scene escena = new Scene(raiz, 700, 600);
            escena.getStylesheets().add(getClass().getResource("/com/example/diu1/css/mod_tabla.css").toExternalForm());
            escenarioPrincipal.setTitle("Actividad Modificación Tabla");

            escena.setOnKeyPressed(new EventHandler<KeyEvent>(){
                public void handle(KeyEvent keyevent){
                    if(keyevent.getCode() == KeyCode.ENTER){
                        añadirPersona();
                    }
                }
            });
            tvPersonajes.setOnKeyPressed(new EventHandler<KeyEvent>(){
                public void handle(KeyEvent keyevent){
                    if(keyevent.getCode() == KeyCode.ENTER){
                        añadirPersona();
                    }
                }
            });

            escenarioPrincipal.setScene(escena);
            escenarioPrincipal.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    public void añadirPersona(){
        if (!camposRellenos()){
            if (personajes.size() >= 10){
                Alert dialogo = new Alert(Alert.AlertType.ERROR);
                dialogo.setTitle("Error");
                dialogo.setHeaderText(null);
                dialogo.setContentText("No se pueden introducir más personajes");

                dialogo.showAndWait();
            } else {
                personajes.add(new Personaje(tc1.getText().toString(), tc2.getText().toString()));
                numPersonajesProperty.setValue(numPersonajesProperty.getValue() + 0.1);
            }
        }

    }

    public boolean camposRellenos(){
        if (tc1.getText().isEmpty() || tc2.getText().isEmpty()){
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setTitle("Error");
            dialogo.setHeaderText(null);
            dialogo.setContentText("Rellene todos los campos");

            dialogo.showAndWait();
            return true;
        }
        else return false;
    }

    public void eliminarPersona(){
        if(tvPersonajes.getSelectionModel().getSelectedItem() != null){
            //Dialogo confirmacion
            Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
            dialogo.setTitle("Confirmar");
            dialogo.setHeaderText(null);
            dialogo.setContentText("Estás seguro de que quieres eliminar el personaje seleccionado?");

            Optional<ButtonType> respuesta = dialogo.showAndWait();
            if (respuesta.get() == ButtonType.OK){
                personajes.remove(tvPersonajes.getSelectionModel().getSelectedItem());
                numPersonajesProperty.setValue(numPersonajesProperty.getValue() - 0.1);
            } else {
                System.out.println("No se ha borrado el personaje");
            }
        }else{
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setTitle("Error");
            dialogo.setHeaderText(null);
            dialogo.setContentText("No se ha seleccionado un personaje.");

            dialogo.showAndWait();
        }

    }



    public static void main(String[] args) {
        launch(args);
    }

}