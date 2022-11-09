package ch.makery.address.controller;

import ch.makery.address.Main;
import ch.makery.address.model.Client;
import ch.makery.address.model.ExcepcionClient;
import ch.makery.address.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

import static ch.makery.address.util.ClientConverter.ClienttoClientVOConverter;

public class ClientOverviewController {
    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> firstNameColumn;
    @FXML
    private TableColumn<Client, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label dniLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label provinceLabel;

    private Model model;

    private Main main;

    public ClientOverviewController() {
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());

        // Clear client details.
        showClientDetails(null);

        // Listen for selection changes and show the client details when changed.
        clientTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showClientDetails(newValue));
    }

    public void setMain(Main main) {
        this.main = main;

        clientTable.setItems(main.getClientData());
    }

    private void showClientDetails(Client client) {
        if (client != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(client.getFirstName());
            lastNameLabel.setText(client.getLastName());
            dniLabel.setText(client.getDni());
            addressLabel.setText(client.getAdress());
            cityLabel.setText(client.getCity());
            provinceLabel.setText(client.getProvince());

        } else {
            // Client is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            dniLabel.setText("");
            addressLabel.setText("");
            cityLabel.setText("");
            provinceLabel.setText("");
        }
    }

    @FXML
    private void handleDeleteClient() {
        int selectedIndex = clientTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            clientTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No ha seleccionado ningún cliente");
            alert.setContentText("Por favor, elija un cliente");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get().equals(ButtonType.OK)) {
                alert.close();
            }
        }
    }

    @FXML
    private void handleNewClient() throws ExcepcionClient {
        Client tempClient = new Client();
        boolean okClicked = main.showClientEdit(tempClient);
        if (okClicked) {
            main.getClientData().add(tempClient);
            tempClient.setId(model.getLastId() + 1);
            model.addClient(ClienttoClientVOConverter(tempClient));
        }
    }

    @FXML
    private void handleEditClient() throws ExcepcionClient {
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            boolean okClicked = main.showClientEdit(selectedClient);
            if (okClicked) {
                model.editClient(ClienttoClientVOConverter(selectedClient));
                showClientDetails(selectedClient);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No ha seleccionado ningún cliente");
            alert.setContentText("Por favor, elija un cliente");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get().equals(ButtonType.OK)) {
                alert.close();
            }
        }
    }

    public void setModel(Model m){
        this.model = m;
    }

    public Model getModel(){
        return this.model;
    }
}
