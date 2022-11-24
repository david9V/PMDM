package ch.makery.address;

import ch.makery.address.controller.*;
import ch.makery.address.model.*;
import ch.makery.address.model.repository.impl.BookingRepositoryImpl;
import ch.makery.address.model.repository.impl.ClientRepositoryImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import static ch.makery.address.util.BookingConverter.BookingVOtoBookingConverter;
import static ch.makery.address.util.ClientConverter.ClientVOtoClientConverter;

public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    private Model model;

    private ClientRepositoryImpl clientRepository;
    private BookingRepositoryImpl bookingRepository;

    private int hDu = 0;//Doble de uso individual
    private int d = 0;//Doble
    private int jS = 0;//Junior Suite
    private int s = 0;//Suite

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

            RootLayoutController rootLayoutController = loader.getController();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();
            rootLayoutController.setMain(this);
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
            clientData = null;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha podido conectar con la base de datos");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get().equals(ButtonType.OK)) {
                alert.close();
            }
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

            if (bookingOverviewController.getModel().loadBookingList(client.getId()).size() == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Cliente sin reservas");
                alert.setHeaderText("El cliente seleccionado no tiene ninguna reserva asociada");
                alert.setContentText("Introduzca sus reservas");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get().equals(ButtonType.OK)) {
                    alert.close();
                }
            }

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

    public void showOccupationStatistics() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/OccupationStatistics.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(personOverview);

            OccupationStatisticsController occupationStatisticsController = loader.getController(); // Load controller
            occupationStatisticsController.setModel(model); // Model injection
            occupationStatisticsController.getModel().setBookingRep(bookingRepository);
            occupationStatisticsController.cargar();
            occupationStatisticsController.setData(occupationStatisticsController.getLista());
            occupationStatisticsController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExcepcionBooking e) {
            throw new RuntimeException(e);
        }
    }

    public void showRoomTypes() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RoomTypes.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Habitaciones");
            dialogStage.initModality(Modality.NONE);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(personOverview);
            dialogStage.setScene(scene);

            RoomTypesController roomTypesController = loader.getController(); // Load controller
            roomTypesController.setModel(model);
            roomTypesController.getModel().setBookingRep(bookingRepository);
            roomTypesController.inicializar();
            dialogStage.showAndWait();

            //roomTypesController.setModel(model); // Model injection
            //roomTypesController.getModel().setBookingRep(bookingRepository);
            //occupationStatisticsController.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExcepcionBooking e) {
            throw new RuntimeException(e);
        }
    }

    public void showJavaDoc() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/JavaDoc.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("JavaDoc");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(personOverview);
            dialogStage.setScene(scene);

            JavaDocController javaDocController = loader.getController(); // Load controller
            dialogStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private ObservableList<Client> clientData = FXCollections.observableArrayList();

    public Main() {
    }

    public ObservableList<Client> getClientData() {
        return clientData;
    }

    public int gethDu() {
        return hDu;
    }

    public void sethDu(int hDu) {
        this.hDu = hDu;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getjS() {
        return jS;
    }

    public void setjS(int jS) {
        this.jS = jS;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public static void main(String[] args) throws ExcepcionClient {
        launch(args);
        //c.guardar(new ClientVO("s", "s", "s", "s", "s", "s"));
        //c.eliminar(1);
        //c.actualizar(new ClientVO(2, "s", "s", "s", "s", "s", "edit"));
    }
}
