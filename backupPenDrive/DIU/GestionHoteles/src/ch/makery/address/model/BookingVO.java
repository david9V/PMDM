package ch.makery.address.model;

import ch.makery.address.util.Regimen;
import ch.makery.address.util.TipoHabitacion;

import java.sql.Date;
import java.time.LocalDate;

public class BookingVO {
    private int cod;
    private Date fechEntrada;
    private Date fechSalida;
    private int nHab;
    private TipoHabitacion tipoHab;
    private boolean fumador;
    private Regimen regimen;
    private int idCliente;

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

    /**
     * @return
     */
    public int getCod() {
        return cod;
    }


    /**
     * @return
     */
    public Date getFechEntrada() {
        return fechEntrada;
    }


    /**
     * @return
     */
    public Date getFechSalida() {
        return fechSalida;
    }


    /**
     * @return
     */
    public int getnHab() {
        return nHab;
    }


    /**
     * @return
     */
    public TipoHabitacion getTipoHab() {
        return tipoHab;
    }


    /**
     * @return
     */
    public boolean isFumador() {
        return fumador;
    }


    /**
     * @return
     */
    public Regimen getRegimen() {
        return regimen;
    }


    /**
     * @return
     */
    public int getIdCliente() {
        return idCliente;
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        return "BookingVO{" +
                "cod=" + cod +
                ", fechEntrada=" + fechEntrada +
                ", fechSalida=" + fechSalida +
                ", nHab=" + nHab +
                ", tipoHab='" + tipoHab + '\'' +
                ", fumador=" + fumador +
                ", regimen='" + regimen + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }
}
