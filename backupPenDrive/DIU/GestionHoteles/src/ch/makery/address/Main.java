package ch.makery.address;

import ch.makery.address.controller.BookingEditController;
import ch.makery.address.controller.BookingOverviewController;
import ch.makery.address.controller.ClientEditController;
import ch.makery.address.controller.ClientOverviewController;
import ch.makery.address.model.*;
import ch.makery.address.model.repository.impl.BookingRepositoryImpl;
import ch.makery.address.model.repository.impl.ClientRepositoryImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static ch.makery.address.util.BookingConverter.BookingVOtoBookingConverter;
import static ch.makery.address.util.ClientConverter.ClientVOtoClientConverter;

public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    private Model model;

    private ClientRepositoryImpl clientRepository;
    private BookingRepositoryImpl bookingRepository;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hotel Vilches");

        this.model = new Model();
        this.clientRepository = new ClientRepositoryImpl();
        this.bookingRepository = new BookingRepositoryImpl();

        initRootLayout();

        showClientOverview();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showClientOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ClientOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            ClientOverviewController clientOverviewController = loader.getController(); // Load controller
            clientOverviewController.setModel(model); // Model injection
            clientOverviewController.getModel().setClientRep(clientRepository); // Client repo injection
            clientOverviewController.getModel().setBookingRep(bookingRepository);
            clientData = ClientVOtoClientConverter(clientOverviewController.getModel().loadClientList()); // Load client list from database
            clientOverviewController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExcepcionClient e) {
            throw new RuntimeException(e);
        }
    }

    public boolean showClientEdit(Client client) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/ClientEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Detalles cliente");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            ClientEditController controller = loader.getController(); // Load controller
            controller.setModel(model); // Model injection
            controller.setDialogStage(dialogStage);
            controller.setClient(client);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showBookingOverview(Client client) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/BookingOverview.fxml"));
            AnchorPane bookingOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(bookingOverview);

            BookingOverviewController bookingOverviewController = loader.getController(); // Load controller
            bookingOverviewController.setClientId(client.getId());
            bookingOverviewController.setModel(model); // Model injection
            bookingOverviewController.getModel().setBookingRep(bookingRepository); // Client repo injection
            bookingOverviewController.setBookingData(BookingVOtoBookingConverter(bookingOverviewController.getModel().loadBookingList(client.getId())));
            bookingOverviewController.initializeTable();
            bookingOverviewController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExcepcionBooking e) {
            throw new RuntimeException(e);
        }
    }

    public boolean showBookingEdit(Booking booking) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/BookingEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Detalles reserva");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            BookingEditController controller = loader.getController(); // Load controller

            controller.setModel(model); // Model injection
            controller.setDialogStage(dialogStage);
            controller.setBooking(booking);
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    private ObservableList<Client> clientData = FXCollections.observableArrayList();

    public Main(){
    }

    public ObservableList<Client> getClientData() {
        return clientData;
    }
    public static void main(String[] args) throws ExcepcionClient {
        launch(args);
        //c.guardar(new ClientVO("s", "s", "s", "s", "s", "s"));
        //c.eliminar(1);
        //c.actualizar(new ClientVO(2, "s", "s", "s", "s", "s", "edit"));
    }
}
