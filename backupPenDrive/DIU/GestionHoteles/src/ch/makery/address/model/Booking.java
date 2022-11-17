package ch.makery.address.model;

import ch.makery.address.util.Regimen;
import ch.makery.address.util.TipoHabitacion;
import javafx.beans.property.*;

import java.time.LocalDate;

public class Booking {

    private final IntegerProperty cod;
    private final ObjectProperty<LocalDate> fechEntrada;
    private final ObjectProperty<LocalDate> fechSalida;
    private final IntegerProperty nHab;
    private final ObjectProperty<TipoHabitacion> tipoHab;
    private final BooleanProperty fumador;
    private final ObjectProperty<Regimen> regimen;
    private final IntegerProperty idCliente;

    public Booking(){
        this(null);
    }

    public Booking(LocalDate fechaEntrada){
        this.cod = new SimpleIntegerProperty();
        this.fechEntrada = new SimpleObjectProperty<>();
        this.fechSalida = new SimpleObjectProperty<>();
        this.nHab = new SimpleIntegerProperty();
        this.tipoHab = new SimpleObjectProperty<>(null);
        this.fumador = new SimpleBooleanProperty();
        this.regimen = new SimpleObjectProperty<>(null);
        this.idCliente = new SimpleIntegerProperty();
    }

    public Booking(IntegerProperty cod, ObjectProperty<LocalDate> fechEntrada, ObjectProperty<LocalDate> fechSalida, IntegerProperty nHab, ObjectProperty<TipoHabitacion> tipoHab, BooleanProperty fumador, ObjectProperty<Regimen> regimen, IntegerProperty idCliente) {
        this.cod = cod;
        this.fechEntrada = fechEntrada;
        this.fechSalida = fechSalida;
        this.nHab = nHab;
        this.tipoHab = tipoHab;
        this.fumador = fumador;
        this.regimen = regimen;
        this.idCliente = idCliente;
    }

    public int getCod() {
        return cod.get();
    }

    public IntegerProperty codProperty() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod.set(cod);
    }


    public LocalDate getFechEntrada() {
        return fechEntrada.get();
    }

    public ObjectProperty<LocalDate> fechEntradaProperty() {
        return fechEntrada;
    }

    public void setFechEntrada(LocalDate fechEntrada) {
        this.fechEntrada.set(fechEntrada);
    }

    public LocalDate getFechSalida() {
        return fechSalida.get();
    }

    public ObjectProperty<LocalDate> fechSalidaProperty() {
        return fechSalida;
    }

    public void setFechSalida(LocalDate fechSalida) {
        this.fechSalida.set(fechSalida);
    }

    public int getnHab() {
        return nHab.get();
    }

    public IntegerProperty nHabProperty() {
        return nHab;
    }

    public void setnHab(int nHab) {
        this.nHab.set(nHab);
    }

    public TipoHabitacion getTipoHab() {
        return tipoHab.get();
    }

    public ObjectProperty<TipoHabitacion> tipoHabProperty() {
        return tipoHab;
    }

    public void setTipoHab(TipoHabitacion tipoHab) {
        this.tipoHab.set(tipoHab);
    }

    public boolean isFumador() {
        return fumador.get();
    }

    public BooleanProperty fumadorProperty() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador.set(fumador);
    }

    public Regimen getRegimen() {
        return regimen.get();
    }

    public ObjectProperty<Regimen> regimenProperty() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen.set(regimen);
    }

    public int getIdCliente() {
        return idCliente.get();
    }

    public IntegerProperty idClienteProperty() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente.set(idCliente);
    }
}
