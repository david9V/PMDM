package ch.makery.address;

import ch.makery.address.model.MonedaModelo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Iterator;
import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.impl.MonedaRepositoryImpl;
import java.util.Iterator;

public class Main extends Application {

    @Override

    public void start(Stage primaryStage) throws Exception{
        MonedaRepositoryImpl repositorio = new MonedaRepositoryImpl();
        MonedaModelo m = new MonedaModelo();
        m.setRep(repositorio);
        //MonedaVO monedaNueva = new MonedaVO("Libra", 2.5F,4);
        //repositorio.addMoneda(monedaNueva);

        Iterator iteratorMonedas = m.obtenerMonedas().iterator();
        do {
            System.out.println("$$$$$$$" + ((MonedaVO) iteratorMonedas.next()).getNombre());
        } while (iteratorMonedas.hasNext());
        Parent root;
        root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
