package ch.makery.address.model.repository;

import ch.makery.address.model.ClientVO;
import ch.makery.address.model.ExcepcionClient;

import java.util.ArrayList;

public interface ClientRepository {
    void guardar(ClientVO client) throws ExcepcionClient;

    void eliminar(int id) throws ExcepcionClient;

    void actualizar(ClientVO client) throws ExcepcionClient;

    ArrayList<ClientVO> cargar() throws ExcepcionClient;

    int lastId() throws ExcepcionClient;
}
