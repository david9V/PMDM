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

    /**
     * @param fechaEntrada
     */
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

    /**
     * @param cod
     * @param fechEntrada
     * @param fechSalida
     * @param nHab
     * @param tipoHab
     * @param fumador
     * @param regimen
     * @param idCliente
     */
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

    /**
     * @return
     */
    public int getCod() {
        return cod.get();
    }

    /**
     * @return
     */
    public IntegerProperty codProperty() {
        return cod;
    }

    /**
     * @param cod
     */
    public void setCod(int cod) {
        this.cod.set(cod);
    }


    /**
     * @return
     */
    public LocalDate getFechEntrada() {
        return fechEntrada.get();
    }

    /**
     * @return
     */
    public ObjectProperty<LocalDate> fechEntradaProperty() {
        return fechEntrada;
    }

    /**
     * @param fechEntrada
     */
    public void setFechEntrada(LocalDate fechEntrada) {
        this.fechEntrada.set(fechEntrada);
    }

    /**
     * @return
     */
    public LocalDate getFechSalida() {
        return fechSalida.get();
    }

    /**
     * @return
     */
    public ObjectProperty<LocalDate> fechSalidaProperty() {
        return fechSalida;
    }

    /**
     * @param fechSalida
     */
    public void setFechSalida(LocalDate fechSalida) {
        this.fechSalida.set(fechSalida);
    }

    /**
     * @return
     */
    public int getnHab() {
        return nHab.get();
    }

    /**
     * @return
     */
    public IntegerProperty nHabProperty() {
        return nHab;
    }

    /**
     * @param nHab
     */
    public void setnHab(int nHab) {
        this.nHab.set(nHab);
    }

    /**
     * @return
     */
    public TipoHabitacion getTipoHab() {
        return tipoHab.get();
    }

    /**
     * @return
     */
    public ObjectProperty<TipoHabitacion> tipoHabProperty() {
        return tipoHab;
    }

    /**
     * @param tipoHab
     */
    public void setTipoHab(TipoHabitacion tipoHab) {
        this.tipoHab.set(tipoHab);
    }

    /**
     * @return
     */
    public boolean isFumador() {
        return fumador.get();
    }

    /**
     * @return
     */
    public BooleanProperty fumadorProperty() {
        return fumador;
    }

    /**
     * @param fumador
     */
    public void setFumador(boolean fumador) {
        this.fumador.set(fumador);
    }

    /**
     * @return
     */
    public Regimen getRegimen() {
        return regimen.get();
    }

    /**
     * @return
     */
    public ObjectProperty<Regimen> regimenProperty() {
        return regimen;
    }

    /**
     * @param regimen
     */
    public void setRegimen(Regimen regimen) {
        this.regimen.set(regimen);
    }

    /**
     * @return
     */
    public int getIdCliente() {
        return idCliente.get();
    }

    /**
     * @return
     */
    public IntegerProperty idClienteProperty() {
        return idCliente;
    }

    /**
     * @param idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente.set(idCliente);
    }
}
