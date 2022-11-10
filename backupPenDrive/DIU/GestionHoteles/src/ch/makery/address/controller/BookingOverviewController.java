package ch.makery.address.controller;

import ch.makery.address.Main;
import ch.makery.address.model.Booking;
import ch.makery.address.model.Client;
import ch.makery.address.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

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

    private ClientOverviewController c;

    BookingOverviewController(){
    }

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

    public void setController(ClientOverviewController c) { // To get the booking List
        this.c = c;

        bookingTable.setItems(c.getBookingData());
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
}
