package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ESTADISTICAS database table.
 * 
 */
@Entity
@Table(name="ESTADISTICAS")
@NamedQuery(name="Estadistica.findAll", query="SELECT e FROM Estadistica e")
public class Estadistica implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EstadisticaPK id;

	@Column(name="ASISTENCIAS_POR_PARTIDO")
	private BigDecimal asistenciasPorPartido;

	@Column(name="PUNTOS_POR_PARTIDO")
	private BigDecimal puntosPorPartido;

	@Column(name="REBOTES_POR_PARTIDO")
	private BigDecimal rebotesPorPartido;

	@Column(name="TAPONES_POR_PARTIDO")
	private BigDecimal taponesPorPartido;

	//bi-directional many-to-one association to Jugadore
	@ManyToOne
	@JoinColumn(name="ID_JUGADOR", insertable=false, updatable=false)
	private Jugadore jugadore;

	public Estadistica() {
	}

	public EstadisticaPK getId() {
		return this.id;
	}

	public void setId(EstadisticaPK id) {
		this.id = id;
	}

	public BigDecimal getAsistenciasPorPartido() {
		return this.asistenciasPorPartido;
	}

	public void setAsistenciasPorPartido(BigDecimal asistenciasPorPartido) {
		this.asistenciasPorPartido = asistenciasPorPartido;
	}

	public BigDecimal getPuntosPorPartido() {
		return this.puntosPorPartido;
	}

	public void setPuntosPorPartido(BigDecimal puntosPorPartido) {
		this.puntosPorPartido = puntosPorPartido;
	}

	public BigDecimal getRebotesPorPartido() {
		return this.rebotesPorPartido;
	}

	public void setRebotesPorPartido(BigDecimal rebotesPorPartido) {
		this.rebotesPorPartido = rebotesPorPartido;
	}

	public BigDecimal getTaponesPorPartido() {
		return this.taponesPorPartido;
	}

	public void setTaponesPorPartido(BigDecimal taponesPorPartido) {
		this.taponesPorPartido = taponesPorPartido;
	}

	public Jugadore getJugadore() {
		return this.jugadore;
	}

	public void setJugadore(Jugadore jugadore) {
		this.jugadore = jugadore;
	}

}