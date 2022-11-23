package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.WindowEvent;

import java.awt.*;

public class RootLayoutController {

    public Main main;

    @FXML
    private void initialize() {
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void handleOpenStatistics(){
        main.showOccupationStatistics();
    }

    @FXML
    private void handleOpenRoomTypes(){
        main.showRoomTypes();
    }

    @FXML
    private void handleExit() {
        main.exit();
    }
}
