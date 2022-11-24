package ch.makery.address.controller;

import ch.makery.address.model.Booking;
import ch.makery.address.model.Client;
import ch.makery.address.model.Model;
import ch.makery.address.util.Regimen;
import ch.makery.address.util.TipoHabitacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

/**
 *
 */
public class BookingEditController {

    @FXML
    private ComboBox comboHab;
    @FXML
    private DatePicker fechEntrada;
    @FXML
    private DatePicker fechSalida;
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private CheckBox fumador;
    @FXML
    private Label fumadorLabel;
    @FXML
    private RadioButton rButton1, rButton2, rButton3;

    SpinnerValueFactory<Integer> valueFactory;
    private boolean okClicked = false;
    private Stage dialogStage;
    private Model model;

    private Booking booking;

    /**
     *
     */
    @FXML
    private void initialize() {
      ObservableList<String> list = FXCollections.observableArrayList("Doble de uso individual", "Doble", "Junior Suite", "Suite");
      comboHab.setItems(list);

        this.valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1,0);
        spinner.setValueFactory(valueFactory);

        fumador.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (fumador.isSelected()){
                fumadorLabel.setText("En virtud de la ley de sanidad,\n" +
                        "se informa a los clientes de que\n" +
                        "solo podrán fumar en las habitaciones \n" +
                        "reservadas para tal coxis.");
            } else fumadorLabel.setText("");
        });
    }

    /**
     * @param booking
     */
    public void setBooking(Booking booking) {
        this.booking = booking;

        int indiceCombo = -1;
        if (booking.getTipoHab() != null) indiceCombo = calcularIndiceCombo(booking);

        fechEntrada.setValue(booking.getFechEntrada());
        fechSalida.setValue(booking.getFechSalida());
        valueFactory.setValue(booking.getnHab());
        if (indiceCombo != -1) comboHab.getSelectionModel().select(indiceCombo);

        if(booking.getRegimen() == Regimen.ALOJAMIENTO_Y_DESAYUNO) rButton1.setSelected(true);
        else if(booking.getRegimen() == Regimen.MEDIA_PENSION) rButton2.setSelected(true);
        else if(booking.getRegimen() == Regimen.PENSION_COMPLETA) rButton3.setSelected(true);

        fumador.setSelected(booking.isFumador());
    }

    /**
     * @param booking
     * @return
     */
    public int calcularIndiceCombo(Booking booking){
        if (booking.getTipoHab().toString().equals("Doble de uso individual")) return 0;
        else if (booking.getTipoHab().toString().equals("Doble")) return 1;
        else if (booking.getTipoHab().toString().equals("Junior Suite")) return 2;
        else if (booking.getTipoHab().toString().equals("Suite")) return 3;
        else return -1;
    }

    /**
     * @return
     */
    public String calcularRegimenElegido(){
        String r = "";
        if (rButton1.isSelected()) r = rButton1.getText();
        else if (rButton2.isSelected()) r = rButton2.getText();
        else if (rButton3.isSelected()) r = rButton3.getText();
        return r;
    }

    /**
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            booking.setFechEntrada(fechEntrada.getValue());
            booking.setFechSalida(fechSalida.getValue());
            booking.setnHab(spinner.getValue());
            booking.setTipoHab((TipoHabitacion.valueOf(comboHab.getSelectionModel().getSelectedItem().toString().replaceAll(" ", "_").toUpperCase())));
            booking.setRegimen(Regimen.valueOf(calcularRegimenElegido().replaceAll(" ", "_").toUpperCase().replaceFirst("Ó", "O")));
            booking.setFumador(fumador.isSelected());
            okClicked = true;
            dialogStage.close();
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (fechEntrada.getValue() == null) {
            errorMessage += "Fecha de entrada no válida\n";
        }
        if (fechSalida.getValue() == null) {
            errorMessage += "Fecha de salida no válida\n";
        }
        if (spinner.getValue() == null || spinner.getValue() == 0 ) {
            errorMessage += "Número de habitaciones no válido\n";
        }
        if (comboHab.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Tipo de habitación no válida\n";
        }
        if (!rButton1.isSelected() && !rButton2.isSelected() && !rButton3.isSelected()) {
            errorMessage += "Régimen no válido\n";
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

    /**
     * @return
     */
    public Model getModel(){
        return this.model;
    }

    /**
     * @param model
     */
    public void setModel(Model model){
        this.model = model;
    }
}
