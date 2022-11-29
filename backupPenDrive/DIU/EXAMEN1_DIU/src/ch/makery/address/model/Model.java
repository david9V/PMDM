package ch.makery.address.model;

import ch.makery.address.model.repository.MonedaRepository;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Model {
    private MonedaRepository repository;

    private IntegerProperty n = new SimpleIntegerProperty();

    public ArrayList<MonedaVO> obtenerMonedas() throws ExcepcionMoneda {
        return this.repository.ObtenerListaMonedas();
    }

    public void addMoneda(MonedaVO monedaVO) throws ExcepcionMoneda {
        this.repository.addMoneda(monedaVO);
        this.n.setValue(this.n.getValue() + 1);
    }

    public void deleteMoneda(Integer codigo) throws ExcepcionMoneda {
        this.repository.deleteMoneda(codigo);
        this.n.setValue(this.n.getValue() - 1);

    }

    public void editMoneda(MonedaVO monedaVO) throws ExcepcionMoneda {
        this.repository.editMoneda(monedaVO);
    }

    public int lastId() throws ExcepcionMoneda {
        return this.repository.lastId();
    }

    public void setRep(MonedaRepository r){
        this.repository = r;
    }

    public MonedaRepository getRep(){
        return this.repository;
    }

    public void setN() {
        //this.n.setValue(this.repository.getN());
    }

    public IntegerProperty getN(){
        return this.n;
    }

}