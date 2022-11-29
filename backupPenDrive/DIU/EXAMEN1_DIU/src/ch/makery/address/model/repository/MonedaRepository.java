package ch.makery.address.model.repository;


import ch.makery.address.model.ExcepcionMoneda;
import ch.makery.address.model.MonedaVO;

import java.util.ArrayList;

public interface MonedaRepository {
    ArrayList<MonedaVO> ObtenerListaMonedas() throws ExcepcionMoneda;

    void addMoneda(MonedaVO var1) throws ExcepcionMoneda;

    void deleteMoneda(Integer var1) throws ExcepcionMoneda;

    void editMoneda(MonedaVO var1) throws ExcepcionMoneda;

    int lastId() throws ExcepcionMoneda;
}