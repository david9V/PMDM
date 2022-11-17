package ch.makery.address.controller;

import ch.makery.address.Main;
import ch.makery.address.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import static ch.makery.address.util.BookingConverter.BookingToBookingVOConverter;
import static ch.makery.address.util.ClientConverter.ClienttoClientVOConverter;

public class BookingOverviewController {

    @FXML
    private TableView<Booking> bookingTable;
    @FXML
    private TableColumn<Booking, Number> codeColumn;
    @FXML
    private TableColumn<Booking, LocalDate> dateColumn;
    @FXML
    private Label fechEntradaLabel;
    @FXML
    private Label fechSalidaLabel;
    @FXML
    private Label numHabLabel;
    @FXML
    private Label tipoHabLabel;
    @FXML
    private Label smokeLabel;
    @FXML
    private Label regimenLabel;


    private Model model;
    private Main main;
    int idCliente;

    @FXML
    private void initialize() {
        codeColumn.setCellValueFactory(
                cellData -> cellData.getValue().codProperty());
        dateColumn.setCellValueFactory(
                cellData -> cellData.getValue().fechEntradaProperty());

        showBookingDetails(null);

        bookingTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookingDetails(newValue));
    }

    public void setClientId(int id){
        this.idCliente = id;
    }

    public void initializeTable(){
        bookingTable.setItems(bookingData);
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setModel(Model m){
        this.model = m;
    }

    public Model getModel(){
        return this.model;
    }

    private void showBookingDetails(Booking booking) {
        if (booking != null) {
            // Fill the labels with info from the person object.
            fechEntradaLabel.setText(booking.getFechEntrada().toString());
            fechSalidaLabel.setText(booking.getFechSalida().toString());
            numHabLabel.setText(String.valueOf(booking.getnHab()));
            tipoHabLabel.setText(booking.getTipoHab().toString());
            smokeLabel.setText(booking.isFumador() == false ? "No" : "Sí");
            regimenLabel.setText(booking.getRegimen().toString());

        } else {
            // Client is null, remove all the text.
            fechEntradaLabel.setText("");
            fechSalidaLabel.setText("");
            numHabLabel.setText("");
            tipoHabLabel.setText("");
            smokeLabel.setText("");
            regimenLabel.setText("");
        }
    }

    @FXML
    private void handleNewBooking() throws ExcepcionBooking {
        Booking tempBooking = new Booking();
        boolean okClicked = main.showBookingEdit(tempBooking);
        if (okClicked) {
            tempBooking.setCod(model.getLastCod() + 1);
            bookingData.add(tempBooking);
            tempBooking.setIdCliente(idCliente);
            model.addBooking(BookingToBookingVOConverter(tempBooking));
        }
    }

    @FXML
    private void handleDeleteBooking() throws ExcepcionBooking {
        int selectedIndex = bookingTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Booking b = bookingTable.getItems().get(selectedIndex);
            bookingTable.getItems().remove(selectedIndex);
            model.deleteBooking(b.getCod());
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
    private void handleEditBooking() throws ExcepcionClient {
        Booking selectedBooking = bookingTable.getSelectionModel().getSelectedItem();
        if (selectedBooking != null) {
            boolean okClicked = main.showBookingEdit(selectedBooking);
            if (okClicked) {
                model.editClient(ClienttoClientVOConverter(selectedClient));
                bookingTable(selectedBooking);
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

    @FXML
    private void handleGoBack(){
        main.showClientOverview();
    }

    private ObservableList<Booking> bookingData = FXCollections.observableArrayList();

    public void setBookingData(ObservableList<Booking> l){
        this.bookingData = l;
    }
}
