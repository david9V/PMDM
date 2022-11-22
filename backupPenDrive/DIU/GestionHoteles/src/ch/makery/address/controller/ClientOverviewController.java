package ch.makery.address.controller;

import ch.makery.address.Main;
import ch.makery.address.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    @FXML
    private TextField dniTextField;

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
    private void handleDeleteClient() throws ExcepcionClient {
        int selectedIndex = clientTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Client c = clientTable.getItems().get(selectedIndex);
            clientTable.getItems().remove(selectedIndex);
            model.deleteClient(c.getId());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
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
            Alert alert = new Alert(Alert.AlertType.WARNING);
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
    private void handleShowBookings() throws ExcepcionBooking {
        Client selectedClient = clientTable.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            if (model.loadBookingList(selectedClient.getId()).size() > 0)
                main.showBookingOverview(selectedClient);
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cliente sin reservas");
                alert.setHeaderText("El cliente seleccionado no tiene ninguna reserva asociada");
                alert.setContentText("Imposible mostrar reservas");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get().equals(ButtonType.OK)) {
                    alert.close();
                }
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
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
    private void handleSearchClient(){
        String dni = dniTextField.getText();
        int i = main.getClientData().indexOf(new Client(dni));
        if (i == -1){ // NO EXISTE UN CLIENTE CON ESE DNI
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Cliente no encontrado");
            alert.setContentText("Introduzca un DNI correcto");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get().equals(ButtonType.OK)) {
                alert.close();
            }
        } else
            main.showBookingOverview(main.getClientData().get(i));
    }

    public void setModel(Model m){
        this.model = m;
    }

    public Model getModel(){
        return this.model;
    }

}
