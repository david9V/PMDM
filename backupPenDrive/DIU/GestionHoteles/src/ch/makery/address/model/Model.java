package ch.makery.address.model;

import ch.makery.address.model.repository.BookingRepository;
import ch.makery.address.model.repository.ClientRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Model {
    private ClientRepository clientRep;
    private BookingRepository bookingRep;

    public void setClientRep(ClientRepository r){
        this.clientRep = r;
    }

    public ClientRepository getClientRep(){
        return this.clientRep;
    }

    public void setBookingRep(BookingRepository b){
        this.bookingRep =  b;
    }

    public BookingRepository getBookingRep(){
        return this.bookingRep;
    }

    //CLIENTS METHODS

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

    // BOOKING METHODS

    public ArrayList<BookingVO> loadBookingList(int idCliente) throws ExcepcionBooking{
        return this.bookingRep.cargar(idCliente);
    }

    public int getLastCod() throws ExcepcionBooking{
        return this.bookingRep.lastCod();
    }

    public void addBooking(BookingVO booking) throws ExcepcionBooking {
        this.bookingRep.guardar(booking);
    }

    public void deleteBooking(int cod) throws ExcepcionBooking{
        this.bookingRep.eliminar(cod);
    }
}
