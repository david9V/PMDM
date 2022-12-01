package ch.makery.address.controller;

import Modelo.ExcepcionMoneda;
import ch.makery.address.model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NoModalController {
    @FXML
    Label labelCantidad;

    private Model model;

    private IntegerProperty cantidad = new SimpleIntegerProperty();

    public void setModel(Model model){
        this.model = model;
    }

    public Model getModel(){
        return this.model;
    }

    public void inicializar() throws ExcepcionMoneda {
        this.model.setN();
        this.cantidad.bindBidirectional(this.model.getN());
        actualizar();
        this.cantidad.addListener((observable, oldValue, newValue) -> {
            actualizar();
        });

    }

    private void actualizar(){
        this.labelCantidad.setText(this.cantidad.getValue().toString());
    }
}
