package ch.makery.address;

import Modelo.ExcepcionMoneda;
import Modelo.repository.impl.MonedaRepositoryImpl;
import ch.makery.address.controller.ConversorOverviewController;
import ch.makery.address.controller.NoModalController;
import ch.makery.address.controller.RootLayoutController;
import ch.makery.address.model.ConversorMonedasImpl;
import ch.makery.address.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    private Model model;

    private MonedaRepositoryImpl monedaRepository;

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EXAMEN MONEDAS");

        this.model = new Model();
        this.monedaRepository = new MonedaRepositoryImpl();

        initRootLayout();
        showConversorOverview();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            RootLayoutController rootLayoutController = loader.getController();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();
            rootLayoutController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showConversorOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ConversorOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            ConversorOverviewController conversorOverviewController = loader.getController();
            conversorOverviewController.setModel(model);
            conversorOverviewController.getModel().setRep(monedaRepository);
            // Se implementa el conversor que se va a utilizar, en este caso el de las monedas.
            conversorOverviewController.getModel().setConversor(new ConversorMonedasImpl());
            conversorOverviewController.cargarLista(conversorOverviewController.getModel().obtenerMonedas());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExcepcionMoneda e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha podido conectar con la base de datos");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get().equals(ButtonType.OK)) {
                alert.close();
            }
        }
    }

    public void showNoModal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/NoModal.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("NO MODAL");
            dialogStage.initModality(Modality.NONE);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(personOverview);
            dialogStage.setScene(scene);

            NoModalController noModalController = loader.getController();
            noModalController.setModel(model);
            noModalController.getModel().setRep(monedaRepository);
            noModalController.inicializar();
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExcepcionMoneda e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
