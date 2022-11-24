package ch.makery.address.model.repository;

import ch.makery.address.model.BookingVO;
import ch.makery.address.model.ClientVO;
import ch.makery.address.model.ExcepcionBooking;
import ch.makery.address.model.ExcepcionClient;
import ch.makery.address.util.TipoHabitacion;

import java.util.ArrayList;

public interface BookingRepository {

    /**
     * @param booking
     * @throws ExcepcionBooking
     */
    void guardar(BookingVO booking) throws ExcepcionBooking;

    /**
     * @param cod
     * @throws ExcepcionBooking
     */
    void eliminar(int cod) throws ExcepcionBooking;

    /**
     * @param booking
     * @throws ExcepcionBooking
     */
    void actualizar(BookingVO booking) throws ExcepcionBooking;

    /**
     * @param idBooking
     * @return
     * @throws ExcepcionBooking
     */
    ArrayList<BookingVO> cargar(int idBooking) throws ExcepcionBooking;

    /**
     * @return
     * @throws ExcepcionBooking
     */
    int lastCod() throws ExcepcionBooking;

    /**
     * @return
     * @throws ExcepcionBooking
     */
    ArrayList<BookingVO> cargarTodo() throws ExcepcionBooking;

    /**
     * @return
     * @throws ExcepcionBooking
     */
    int getNdU() throws ExcepcionBooking;

    /**
     * @return
     * @throws ExcepcionBooking
     */
    int getNd() throws ExcepcionBooking;

    /**
     * @return
     * @throws ExcepcionBooking
     */
    int getNjS() throws ExcepcionBooking;

    /**
     * @return
     * @throws ExcepcionBooking
     */
    int getNs() throws ExcepcionBooking;

    /**
     * @param cod
     * @return
     * @throws ExcepcionBooking
     */
    TipoHabitacion getTipoHab(int cod) throws ExcepcionBooking;


}
