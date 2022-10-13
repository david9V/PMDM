package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ContadorVentanaPulsacionesContr {
    @FXML
    private Button botonPulsame;

    @FXML
    private Label pulsacionesLabel;

    private int numPulsaciones = 0;

    public ContadorVentanaPulsacionesContr() {

    }

    @FXML
    private void botonPulsado() {
        this.numPulsaciones++;
        if (this.numPulsaciones == 1){
            this.pulsacionesLabel.setText("El botón se ha pulsado una vez");
        } else this.pulsacionesLabel.setText(("El botón se ha pulsado " + this.numPulsaciones + " veces"));
    }
}
