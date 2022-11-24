package ch.makery.address.model.repository;

import ch.makery.address.model.BookingVO;
import ch.makery.address.model.ClientVO;
import ch.makery.address.model.ExcepcionBooking;
import ch.makery.address.model.ExcepcionClient;
import ch.makery.address.util.TipoHabitacion;

import java.util.ArrayList;

public interface BookingRepository {

    void guardar(BookingVO booking) throws ExcepcionBooking;

    void eliminar(int cod) throws ExcepcionBooking;

    void actualizar(BookingVO booking) throws ExcepcionBooking;

    ArrayList<BookingVO> cargar(int idBooking) throws ExcepcionBooking;

    int lastCod() throws ExcepcionBooking;

    public ArrayList<BookingVO> cargarTodo() throws ExcepcionBooking;

    public int getNdU() throws ExcepcionBooking;

    public int getNd() throws ExcepcionBooking;

    public int getNjS() throws ExcepcionBooking;

    public int getNs() throws ExcepcionBooking;

    public TipoHabitacion getTipoHab(int cod) throws ExcepcionBooking;


}
