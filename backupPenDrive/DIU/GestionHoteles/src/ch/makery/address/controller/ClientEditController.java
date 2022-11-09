package ch.makery.address.controller;

import ch.makery.address.model.Client;
import ch.makery.address.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class ClientEditController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField dniField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField provinceField;

    private Stage dialogStage;
    private Client client;
    private boolean okClicked = false;

    private Model model;

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setClient(Client client) {
        this.client = client;

        firstNameField.setText(client.getFirstName());
        lastNameField.setText(client.getLastName());
        dniField.setText(client.getDni());
        addressField.setText(client.getAdress());
        cityField.setText(client.getCity());
        provinceField.setText(client.getProvince());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            client.setFirstName(firstNameField.getText());
            client.setLastName(lastNameField.getText());
            client.setDni(dniField.getText());
            client.setAddress(addressField.getText());
            client.setCity(cityField.getText());
            client.setProvince(provinceField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "Nombre no válido\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "Apellido no válido\n";
        }
        if (dniField.getText() == null || dniField.getText().length() == 0) {
            errorMessage += "DNI no válido\n";
        }
        if (addressField.getText() == null || addressField.getText().length() == 0) {
            errorMessage += "Dirección no válida\n";
        }
        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "Localidad no válida\n";
        }
        if (provinceField.getText() == null || provinceField.getText().length() == 0) {
            errorMessage += "Provincia no válida\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos inválidos");
            alert.setContentText(errorMessage);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get().equals(ButtonType.OK)) {
                alert.close();
            }
            return false;
        }
    }

    public Model getModel(){
        return this.model;
    }

    public void setModel(Model model){
        this.model = model;
    }
}
