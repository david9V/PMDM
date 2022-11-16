package ch.makery.address.controller;

import ch.makery.address.Main;
import ch.makery.address.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

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
            bookingData.add(tempBooking);
            //tempBooking.setId(model.getLastId() + 1);
            //model.addClient(ClienttoClientVOConverter(tempClient));
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
