package ch.makery.address.controller;

import ch.makery.address.model.Booking;
import ch.makery.address.model.Client;
import ch.makery.address.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class BookingEditController {

    @FXML
    private ComboBox comboHab;
    private boolean okClicked = false;
    private Stage dialogStage;
    private Model model;
    private Booking booking;



    @FXML
    private void initialize() {
      ObservableList<String> list = FXCollections.observableArrayList("Doble de uso individual", "Doble", "Junior Suite", "Suite");
      comboHab.setItems(list);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }
}
