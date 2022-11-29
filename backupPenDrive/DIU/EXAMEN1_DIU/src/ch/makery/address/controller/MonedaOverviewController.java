package ch.makery.address.controller;

import ch.makery.address.model.Moneda;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MonedaOverviewController {
    @FXML
    private TableView<Moneda> monedaTable;
    @FXML
    private TableColumn<Moneda, String> monedaColumn;

    @FXML
    private void initialize() {
        monedaColumn.setCellValueFactory(
                cellData -> cellData.getValue().nombreProperty());

        showMonedaDetails(null);

        monedaTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMonedaDetails(newValue));
    }

    private void showMonedaDetails(Moneda moneda) {
        if (moneda != null) {
            //nombreLabel.setText(client.getFirstName());


        } else {

            //firstNameLabel.setText("");
            //lastNameLabel.setText("");
            //dniLabel.setText("");

        }
    }
}
