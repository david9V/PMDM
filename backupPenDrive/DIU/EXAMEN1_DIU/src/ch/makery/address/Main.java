package ch.makery.address;

import ch.makery.address.controller.MonedaOverviewController;
import ch.makery.address.controller.NoModalController;
import ch.makery.address.controller.RootLayoutController;
import ch.makery.address.model.ExcepcionMoneda;
import ch.makery.address.model.Model;
import ch.makery.address.model.MonedaVO;
import ch.makery.address.model.repository.impl.MonedaRepositoryImpl;
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
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EXAMEN");

        this.model = new Model();
        this.monedaRepository = new MonedaRepositoryImpl();

        initRootLayout();
        showMonedaOverview();
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

    public void showMonedaOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MonedaOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            MonedaOverviewController monedaOverviewController = loader.getController();
            //monedaOverviewController.setModel(model);
            //monedaOverviewController.getModel().setClientRep(monedaRepository);
            //monedaData = ClientVOtoClientConverter(clientOverviewController.getModel().loadClientList()); // Load client list from database
            //monedaOverviewController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (ExcepcionMoneda e) {
            monedaData = null;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha podido conectar con la base de datos");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get().equals(ButtonType.OK)) {
                alert.close();
            }
        }
        */
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

            NoModalController noModalController = loader.getController(); // Load controller
            //noModalController.setModel(model);
            //noModalController.getModel().setBookingRep(monedaRepository);
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExcepcionMoneda {
        launch(args);
        MonedaRepositoryImpl monedaRepository1 = new MonedaRepositoryImpl();
        monedaRepository1.deleteMoneda(monedaRepository1.lastId());
    }
}
