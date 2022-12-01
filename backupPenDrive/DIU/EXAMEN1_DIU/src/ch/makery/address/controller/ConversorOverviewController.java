package ch.makery.address.controller;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import ch.makery.address.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Optional;

public class ConversorOverviewController {
    @FXML
    private ComboBox<MonedaVO> comboLista;
    @FXML
    private TextField textFieldEuro;
    @FXML
    private TextField textFieldSel;
    @FXML
    private Label labelSel;

    private Model model;

    ObservableList<MonedaVO> list;

    @FXML
    private void initialize() {

    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return this.model;
    }

    public void cargarLista(ArrayList<MonedaVO> listaMoneda) {
        this.list = FXCollections.observableArrayList(listaMoneda);
        this.comboLista.setItems(this.list);

        this.comboLista.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.labelSel.setText(this.comboLista.getSelectionModel().getSelectedItem().getNombre());
            this.textFieldSel.setText("");
            this.textFieldEuro.setText("");
        });

        this.comboLista.getSelectionModel().select(0);

    }

    @FXML
    private void handleConvertir() { // PULSANDO EL BOTÓN CONVERTIR
        if (!this.textFieldEuro.getText().isEmpty()) { // EURO A X MONEDA
            if (Float.parseFloat(this.textFieldEuro.getText()) < 0) {
               mostrarWarning("Las cantidades a convertir deben de ser positivas");
            } else {
                float mult = this.comboLista.getSelectionModel().getSelectedItem().getMultiplicador();
                float n = Float.parseFloat(this.textFieldEuro.getText());
                String res = (String.valueOf(this.model.convertirA_B(n, mult)));
                this.textFieldSel.setText(res);
            }

        } else if (!this.textFieldSel.getText().isEmpty()) { // X MONEDA A EUROS
            if (Float.parseFloat(this.textFieldSel.getText()) < 0) {
                mostrarWarning("Las cantidades a convertir deben de ser positivas");
            } else {
                float mult = this.comboLista.getSelectionModel().getSelectedItem().getMultiplicador();
                float n = Float.parseFloat(this.textFieldSel.getText());
                String res = String.valueOf(this.model.convertirB_A(n, mult));
                this.textFieldEuro.setText(res);
            }
        } else { // VACIO
           mostrarWarning("No ha rellenado ningún campo");
        }
    }

    @FXML
    private void handleConvertir1() { // AL DARLE ENTER
        if (!this.textFieldEuro.getText().isEmpty()) { // NO ESTÁ VACIO
            if (Float.parseFloat(this.textFieldEuro.getText()) < 0) {
               mostrarWarning("Las cantidades a convertir deben de ser positivas");
            } else {
                float mult = this.comboLista.getSelectionModel().getSelectedItem().getMultiplicador();
                float n = Float.parseFloat(this.textFieldEuro.getText());
                String res = (String.valueOf(this.model.convertirA_B(n, mult)));
                this.textFieldSel.setText(res);
            }
        }
        else {
            mostrarWarning("Introduzca un valor en este campo");
        }

    }

    @FXML
    private void handleConvertir2() { // AL DARLE ENTER
        if (!this.textFieldSel.getText().isEmpty()) { // NO ESTÁ VACIO
            if (Float.parseFloat(this.textFieldSel.getText()) < 0) {
                mostrarWarning("Las cantidades a convertir deben de ser positivas");
            } else {
                float mult = this.comboLista.getSelectionModel().getSelectedItem().getMultiplicador();
                float n = Float.parseFloat(this.textFieldSel.getText());
                String res = String.valueOf(this.model.convertirB_A(n, mult));
                this.textFieldEuro.setText(res);
            }
        }
        else {
            mostrarWarning("Introduzca un valor en este campo");
        }
    }

    @FXML
    private void handleBorrar() throws ExcepcionMoneda {
        int i = this.comboLista.getSelectionModel().getSelectedIndex();
        int cod = this.comboLista.getSelectionModel().getSelectedItem().getCodigo();
        model.deleteMoneda(cod);
        this.comboLista.getItems().remove(i);
    }

    @FXML
    private void handleLimpiar() {
        textFieldEuro.setText("");
        textFieldSel.setText("");
    }

    private void mostrarWarning(String msg){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(msg);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get().equals(ButtonType.OK)) {
            alert.close();
        }
    }
}
