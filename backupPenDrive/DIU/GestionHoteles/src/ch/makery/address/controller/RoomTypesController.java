package ch.makery.address.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

public class RoomTypesController{

    @FXML
    private ComboBox comboHab;
    @FXML
    private ImageView img;

    @FXML
    private void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("Doble de uso individual", "Doble", "Junior Suite", "Suite");
        comboHab.setItems(list);
        comboHab.getSelectionModel().select(0);
        comboHab.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Doble de uso individual") == 0 ){

            }
            if (comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Doble") == 0 ){

            }
            if (comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Junior Suite") == 0 ){

            }
            if (comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Suite") == 0 ){

            }
        });
    }


}
