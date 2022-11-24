package ch.makery.address.model;

import ch.makery.address.model.repository.BookingRepository;
import ch.makery.address.model.repository.ClientRepository;
import ch.makery.address.util.TipoHabitacion;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Model {
    private ClientRepository clientRep;
    private BookingRepository bookingRep;

    private int duMax = 20;
    private int dMax = 80;
    private int jSMax = 15;
    private int sMax = 5;

    private IntegerProperty habActuales_dU = new SimpleIntegerProperty();
    private IntegerProperty habActuales_d = new SimpleIntegerProperty();
    private IntegerProperty habActuales_jS = new SimpleIntegerProperty();
    private IntegerProperty habActuales_s = new SimpleIntegerProperty();

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

        if (booking.getTipoHab() == TipoHabitacion.DOBLE_DE_USO_INDIVIDUAL)
            this.habActuales_dU.setValue(this.habActuales_dU.getValue() + 1);
        if (booking.getTipoHab() == TipoHabitacion.DOBLE)
            this.habActuales_d.setValue(this.habActuales_d.getValue() + 1);
        if (booking.getTipoHab() == TipoHabitacion.JUNIOR_SUITE)
            this.habActuales_jS.setValue(this.habActuales_jS.getValue() + 1);
        if (booking.getTipoHab() == TipoHabitacion.SUITE)
            this.habActuales_s.setValue(this.habActuales_s.getValue() + 1);
    }

    public void editBooking(BookingVO booking) throws ExcepcionBooking{
        this.bookingRep.actualizar(booking);
    }

    public void deleteBooking(int cod) throws ExcepcionBooking{
        if (this.bookingRep.getTipoHab(cod) == TipoHabitacion.DOBLE_DE_USO_INDIVIDUAL)
            this.habActuales_dU.setValue(this.habActuales_dU.getValue() - 1);
        if (this.bookingRep.getTipoHab(cod) == TipoHabitacion.DOBLE)
            this.habActuales_d.setValue(this.habActuales_d.getValue() - 1);
        if (this.bookingRep.getTipoHab(cod) == TipoHabitacion.JUNIOR_SUITE)
            this.habActuales_jS.setValue(this.habActuales_jS.getValue() - 1);
        if (this.bookingRep.getTipoHab(cod) == TipoHabitacion.SUITE)
            this.habActuales_s.setValue(this.habActuales_s.getValue() - 1);

        this.bookingRep.eliminar(cod);
    }

    // INFO METHODS

    public ArrayList<BookingVO>loadFullBookingList() throws ExcepcionBooking{
        return this.bookingRep.cargarTodo();
    }

    public void setHabActuales_dU() throws ExcepcionBooking {
        this.habActuales_dU.setValue(this.bookingRep.getNdU());
    }

    public void setHabActuales_d() throws ExcepcionBooking {
        this.habActuales_dU.setValue(this.bookingRep.getNd());
    }

    public void setHabActuales_jS() throws ExcepcionBooking {
        this.habActuales_dU.setValue(this.bookingRep.getNjS());
    }

    public void setHabActuales_s() throws ExcepcionBooking {
        this.habActuales_dU.setValue(this.bookingRep.getNs());
    }

    public IntegerProperty getHabActuales_dU(){
        return this.habActuales_dU;
    }

    public IntegerProperty getHabActuales_d(){
        return this.habActuales_d;
    }

    public IntegerProperty getHabActuales_jS(){
        return this.habActuales_jS;
    }

    public IntegerProperty getHabActuales_s(){
        return this.habActuales_s;
    }
}
