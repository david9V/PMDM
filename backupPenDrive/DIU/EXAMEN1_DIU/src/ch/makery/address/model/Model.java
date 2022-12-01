package ch.makery.address.model;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.MonedaRepository;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Model {
    private MonedaRepository repository;
    private IntegerProperty n = new SimpleIntegerProperty();

    private Conversor conversor;

    public Model(){

    }

    public void setConversor(Conversor conversor){ // INYECTAR EL CONVERSOR QUE NECESITEMOS
        this.conversor = conversor;
    } // INYECTAR CONVERSOR

    public float convertirA_B(float n, float mult){
        return this.conversor.convertirA_B(n, mult);
    }

    public float convertirB_A(float n, float mult){
        return this.conversor.convertirB_A(n, mult);
    }

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

    public void setN() throws ExcepcionMoneda {
        this.n.setValue(this.repository.ObtenerListaMonedas().size());
    }

    public IntegerProperty getN(){
        return this.n;
    }

}