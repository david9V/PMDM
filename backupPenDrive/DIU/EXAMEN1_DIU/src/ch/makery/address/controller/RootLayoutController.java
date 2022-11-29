package ch.makery.address.controller;

import ch.makery.address.Main;
import javafx.fxml.FXML;

public class RootLayoutController {

    public Main main;

    @FXML
    private void initialize() {
    }

    /**
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     *
     */
    @FXML
    private void handleShowNoModal(){
        main.showNoModal();
    }
}
