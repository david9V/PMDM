package ch.makery.address.model;

import Modelo.ExcepcionMoneda;
import Modelo.MonedaVO;
import Modelo.repository.MonedaRepository;
import Modelo.repository.impl.MonedaRepositoryImpl;

import java.util.ArrayList;

public class MonedaModelo {
    private MonedaRepository repository;

    public MonedaModelo(){
    }

    public ArrayList<MonedaVO> obtenerMonedas() throws ExcepcionMoneda {
        return this.repository.ObtenerListaMonedas();
    }

    public void setRep(MonedaRepository r){
        this.repository = r;
    }

    public MonedaRepository getRep(){
        return this.repository;
    }

}
