package ch.makery.address.util;

import ch.makery.address.model.Booking;
import ch.makery.address.model.BookingVO;
import ch.makery.address.model.Client;
import ch.makery.address.model.ClientVO;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookingConverter {

    public  static ObservableList<Booking> BookingVOtoBookingConverter(ArrayList<BookingVO> lista){
        ObservableList<Booking> p = FXCollections.observableArrayList();
        for (int i = 0; i < lista.size(); i++){
            IntegerProperty cod = new SimpleIntegerProperty(lista.get(i).getCod());
            ObjectProperty<LocalDate> fEntr  = new SimpleObjectProperty<>(lista.get(i).getFechEntrada().toLocalDate());
            ObjectProperty<LocalDate> fSal  = new SimpleObjectProperty<>(lista.get(i).getFechSalida().toLocalDate());
            IntegerProperty nHab  = new SimpleIntegerProperty(lista.get(i).getnHab());
            ObjectProperty<TipoHabitacion> tipoHab  = new SimpleObjectProperty(lista.get(i).getTipoHab());
            BooleanProperty fumador  = new SimpleBooleanProperty(lista.get(i).isFumador());
            ObjectProperty<Regimen> regimen  = new SimpleObjectProperty(lista.get(i).getRegimen());
            IntegerProperty idClie = new SimpleIntegerProperty(lista.get(i).getIdCliente());

            Booking booking = new Booking(cod, fEntr, fSal, nHab, tipoHab, fumador, regimen, idClie);
            p.add(booking);
        }
        return p;
    }

    public static BookingVO BookingToBookingVOConverter(Booking booking){
        int cod = booking.getCod();
        Date fEntr = Date.valueOf(booking.getFechEntrada());
        Date fSal = Date.valueOf(booking.getFechSalida());
        int nHab = booking.getnHab();
        TipoHabitacion tipo = booking.getTipoHab();
        boolean fumador = booking.isFumador();
        Regimen regimen = booking.getRegimen();
        int idClie = booking.getIdCliente();
        BookingVO b = new BookingVO(cod, fEntr, fSal, nHab, tipo, fumador, regimen, idClie);

        return b;
    }
}
