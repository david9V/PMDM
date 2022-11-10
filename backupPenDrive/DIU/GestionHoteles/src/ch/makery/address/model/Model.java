package ch.makery.address.model;

import ch.makery.address.model.repository.ClientRepository;

import java.util.ArrayList;

public class Model {
    private ClientRepository clientRep;

    public void setClientRep(ClientRepository r){
        this.clientRep = r;
    }

    public ClientRepository getClientRep(){
        return this.clientRep;
    }

    public void addClient(ClientVO client) throws ExcepcionClient {
        this.clientRep.guardar(client);
    }

    public void deleteClient(int id) throws ExcepcionClient {
        this.clientRep.eliminar(id);
    }

    public void editClient(ClientVO client) throws ExcepcionClient {
        this.clientRep.actualizar(client);
    }

    public ArrayList<ClientVO> loadClientList() throws ExcepcionClient {
        return this.clientRep.cargar();
    }

    public int getLastId() throws ExcepcionClient {
        return this.clientRep.lastId();
    }

}
