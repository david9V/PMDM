package ch.makery.address.model;

import ch.makery.address.util.Regimen;
import ch.makery.address.util.TipoHabitacion;

import java.time.LocalDate;
import java.util.Date;

public class BookingVO {
    private int cod;
    private Date fechEntrada;
    private Date fechSalida;
    private int nHab;
    private TipoHabitacion tipoHab;
    private boolean fumador;
    private Regimen regimen;
    private int idCliente;

    public BookingVO(int cod, Date fechEntrada, Date fechSalida, int nHab, TipoHabitacion tipoHab, boolean fumador, Regimen regimen, int idCliente) {
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
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getFechEntrada() {
        return fechEntrada;
    }

    public void setFechEntrada(Date fechEntrada) {
        this.fechEntrada = fechEntrada;
    }

    public Date getFechSalida() {
        return fechSalida;
    }

    public void setFechSalida(Date fechSalida) {
        this.fechSalida = fechSalida;
    }

    public int getnHab() {
        return nHab;
    }

    public void setnHab(int nHab) {
        this.nHab = nHab;
    }

    public TipoHabitacion getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(TipoHabitacion tipoHab) {
        this.tipoHab = tipoHab;
    }

    public boolean isFumador() {
        return fumador;
    }

    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
