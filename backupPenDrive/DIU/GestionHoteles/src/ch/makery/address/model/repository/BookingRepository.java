package ch.makery.address.model.repository;

import ch.makery.address.model.BookingVO;
import ch.makery.address.model.ClientVO;
import ch.makery.address.model.ExcepcionBooking;
import ch.makery.address.model.ExcepcionClient;

import java.util.ArrayList;

public interface BookingRepository {

    void guardar(BookingVO booking) throws ExcepcionBooking;

    void eliminar(int cod) throws ExcepcionBooking;

    void actualizar(BookingVO booking) throws ExcepcionBooking;

    ArrayList<BookingVO> cargar(int idCliente) throws ExcepcionBooking;

    int lastCod() throws ExcepcionBooking;

}
