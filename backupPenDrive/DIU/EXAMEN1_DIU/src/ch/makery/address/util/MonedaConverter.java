package ch.makery.address.util;

import ch.makery.address.model.Moneda;
import ch.makery.address.model.MonedaVO;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class MonedaConverter {

    public  static ObservableList<Moneda> MonedaVOtoMonedaList(ArrayList<MonedaVO> lista){
        ObservableList<Moneda> p = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++){
            StringProperty nom  = new SimpleStringProperty(lista.get(i).getNombre());
            IntegerProperty cod = new SimpleIntegerProperty(lista.get(i).getCodigo());
            FloatProperty mult = new SimpleFloatProperty(lista.get(i).getMultiplicador());
            Moneda moneda = new Moneda(nom, cod, mult);
            p.add(moneda);
        }
        return p;
    }

    public static MonedaVO MonedaToMonedaVO(Moneda moneda){
        int cod = moneda.getCodigo();
        String nom = moneda.getNombre();
        float mult = moneda.getMultiplicador();

        return new MonedaVO(nom, mult, cod);
    }
}
