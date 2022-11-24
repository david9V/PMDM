package ch.makery.address.model.repository;

import ch.makery.address.model.ClientVO;
import ch.makery.address.model.ExcepcionClient;

import java.util.ArrayList;

public interface ClientRepository {
    /**
     * @param client
     * @throws ExcepcionClient
     */
    void guardar(ClientVO client) throws ExcepcionClient;

    /**
     * @param id
     * @throws ExcepcionClient
     */
    void eliminar(int id) throws ExcepcionClient;

    /**
     * @param client
     * @throws ExcepcionClient
     */
    void actualizar(ClientVO client) throws ExcepcionClient;

    /**
     * @return
     * @throws ExcepcionClient
     */
    ArrayList<ClientVO> cargar() throws ExcepcionClient;

    /**
     * @return
     * @throws ExcepcionClient
     */
    int lastId() throws ExcepcionClient;
}
