package ch.makery.address.controller;

import ch.makery.address.model.ExcepcionBooking;
import ch.makery.address.model.Model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class RoomTypesController{

    @FXML
    private ComboBox comboHab;
    @FXML
    private ImageView img;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label nProgress;
    private List<Image> du; //Doble de uso individual
    private List<Image> d; //Doble
    private List<Image> jS; //Junior Suite
    private List<Image> s; //Suite

    private List<Image> imagenActual;
    private int i = 0; // iterador que va a recorrer el array
    private IntegerProperty cantidadBarra = new SimpleIntegerProperty();
    private Model model;

    public void inicializar() throws ExcepcionBooking {
        ObservableList<String> list = FXCollections.observableArrayList("Doble de uso individual", "Doble", "Junior Suite", "Suite");
        this.comboHab.setItems(list);
        this.comboHab.getSelectionModel().select(0);

        this.du = new ArrayList<>();
        this.d = new ArrayList<>();
        this.jS = new ArrayList<>();
        this.s = new ArrayList<>();

        this.imagenActual = new ArrayList<>();
        loadImages();
        actualizarAdU();

        /*
        this.cantidadBarra.addListener((observable, oldValue, newValue) -> {
            if (this.comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Doble de uso individual") == 0 ) {
                try {
                    actualizarAdU();
                } catch (ExcepcionBooking e) {
                    throw new RuntimeException(e);
                }
                setProgress_dU();
                setNProgress_dU();
            }
            if (this.comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Doble") == 0 ){
                try {
                    actualizarAd();
                } catch (ExcepcionBooking e) {
                    throw new RuntimeException(e);
                }
                setProgress_d();
                setNProgress_d();
            }
            if (this.comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Junior Suite") == 0 ){
                try {
                    actualizarAjS();
                } catch (ExcepcionBooking e) {
                    throw new RuntimeException(e);
                }
                setProgress_jS();
                setNProgress_jS();
            }
            if (this.comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Suite") == 0 ){
                try {
                    actualizarAs();
                } catch (ExcepcionBooking e) {
                    throw new RuntimeException(e);
                }
                setProgress_s();
                setNProgress_s();
            }

        });
         */
        this.comboHab.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (this.comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Doble de uso individual") == 0 ){

                try {
                    actualizarAdU();
                } catch (ExcepcionBooking e) {
                    throw new RuntimeException(e);
                }

                this.imagenActual = this.du;
                img.setImage(imagenActual.get(0));
            }
            if (this.comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Doble") == 0 ){

                try {
                    actualizarAd();
                } catch (ExcepcionBooking e) {
                    throw new RuntimeException(e);
                }

                this.imagenActual = this.d;
                img.setImage(imagenActual.get(0));
            }
            if (this.comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Junior Suite") == 0 ){

                try {
                    actualizarAjS();
                } catch (ExcepcionBooking e) {
                    throw new RuntimeException(e);
                }

                this.imagenActual = this.jS;
                img.setImage(imagenActual.get(0));
            }
            if (this.comboHab.getSelectionModel().getSelectedItem().toString().compareTo("Suite") == 0 ){

                try {
                    actualizarAs();
                } catch (ExcepcionBooking e) {
                    throw new RuntimeException(e);
                }

                this.imagenActual = this.s;
                img.setImage(imagenActual.get(0));
            }
        });
    }

    private void loadImages(){
        this.du.add(new Image("/res/du1.jpg"));
        this.du.add(new Image("/res/du2.jpg"));
        this.du.add(new Image("/res/du3.jpg"));
        this.du.add(new Image("/res/du4.jpg"));

        this.d.add(new Image("/res/d1.jpg"));
        this.d.add(new Image("/res/d2.jpg"));
        this.d.add(new Image("/res/d3.jpg"));
        this.d.add(new Image("/res/d4.jpg"));

        this.jS.add(new Image("/res/jS1.jpg"));
        this.jS.add(new Image("/res/jS2.jpg"));
        this.jS.add(new Image("/res/jS3.jpg"));
        this.jS.add(new Image("/res/jS4.jpg"));

        this.s.add(new Image("/res/s1.jpg"));
        this.s.add(new Image("/res/s2.jpg"));
        this.s.add(new Image("/res/s3.jpg"));
        this.s.add(new Image("/res/s4.jpg"));

        this.imagenActual = this.du;
    }

    @FXML
    private void handleNext(){
        if (i < 3) i++;
        else i = 0;
        img.setImage(imagenActual.get(this.i));
    }

    @FXML
    private void handlePrevious(){
        if (i > 0) i--;
        else i = 3;
        img.setImage(imagenActual.get(this.i));
    }

    public void actualizarAdU() throws ExcepcionBooking {
        this.model.setHabActuales_dU();
        this.cantidadBarra.unbind();
        this.cantidadBarra.bindBidirectional(this.model.getHabActuales_dU());
        setProgress_dU();
        setNProgress_dU();
    }

    public void actualizarAd() throws ExcepcionBooking {
        this.model.setHabActuales_d();
        this.cantidadBarra.unbind();
        this.cantidadBarra.bindBidirectional(this.model.getHabActuales_d());
        setProgress_d();
        setNProgress_d();
    }

    public void actualizarAjS() throws ExcepcionBooking {
        this.model.setHabActuales_jS();
        this.cantidadBarra.unbind();
        this.cantidadBarra.bindBidirectional(this.model.getHabActuales_jS());
        setProgress_jS();
        setNProgress_jS();
    }

    public void actualizarAs() throws ExcepcionBooking {
        this.model.setHabActuales_s();
        this.cantidadBarra.unbind();
        this.cantidadBarra.bindBidirectional(this.model.getHabActuales_s());
        setProgress_s();
        setNProgress_s();
    }

    private void setProgress_dU(){
        double l = (double) this.cantidadBarra.getValue() / 20;
        this.progressBar.setProgress(l);
    }

    public void setNProgress_dU(){
        this.nProgress.setText((this.cantidadBarra.getValue() * 100/20) + "%");
    }

    private void setProgress_d(){
        double l = (double) this.cantidadBarra.getValue() / 80;
        this.progressBar.setProgress(l);
    }

    public void setNProgress_d(){
        this.nProgress.setText((this.cantidadBarra.getValue() * 100/80) + "%");
    }

    private void setProgress_jS(){
        double l = (double) this.cantidadBarra.getValue() / 15;
        this.progressBar.setProgress(l);
    }

    public void setNProgress_jS(){
        this.nProgress.setText((this.cantidadBarra.getValue() * 100/15) + "%");
    }

    private void setProgress_s(){
        double l = (double) this.cantidadBarra.getValue() / 5;
        this.progressBar.setProgress(l);
    }

    public void setNProgress_s(){
        this.nProgress.setText((this.cantidadBarra.getValue() * 100/5) + "%");
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
