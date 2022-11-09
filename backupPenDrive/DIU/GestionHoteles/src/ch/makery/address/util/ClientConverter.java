package ch.makery.address.util;

import ch.makery.address.model.Client;
import ch.makery.address.model.ClientVO;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClientConverter {
    public  static ObservableList<Client> ClientVOtoClientConverter(ArrayList<ClientVO> lista){
        ObservableList<Client> p = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++){
            IntegerProperty id = new SimpleIntegerProperty(lista.get(i).getId());
            StringProperty fn  = new SimpleStringProperty(lista.get(i).getFirstName());
            StringProperty ln  = new SimpleStringProperty(lista.get(i).getLastName());
            StringProperty dni  = new SimpleStringProperty(lista.get(i).getDni());
            StringProperty address  = new SimpleStringProperty(lista.get(i).getAddress());
            StringProperty city  = new SimpleStringProperty(lista.get(i).getCity());
            StringProperty province  = new SimpleStringProperty(lista.get(i).getProvince());

            Client client = new Client(id, fn, ln, dni, address, city, province);
            p.add(client);
        }
        return p;
    }

    public static ClientVO ClienttoClientVOConverter(Client client){
        int id = client.getId();
        String fn = client.getFirstName();
        String ln = client.getLastName();
        String dni = client.getDni();
        String address = client.getAdress();
        String city = client.getCity();
        String province = client.getProvince();
        ClientVO clientVO = new ClientVO(id, fn, ln, dni, address, city, province);

        return clientVO;
    }
}
