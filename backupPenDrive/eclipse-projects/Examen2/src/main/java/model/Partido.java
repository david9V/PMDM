package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PARTIDOS database table.
 * 
 */
@Entity
@Table(name="PARTIDOS")
@NamedQuery(name="Partido.findAll", query="SELECT p FROM Partido p")
public class Partido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PARTIDO")
	private long idPartido;

	@Column(name="PUNTOS_LOCAL")
	private BigDecimal puntosLocal;

	@Column(name="PUNTOS_VISITANTE")
	private BigDecimal puntosVisitante;

	private String temporada;

	//bi-directional many-to-one association to Equipo
	@ManyToOne()
	@JoinColumn(name="NOMBRE_EQUIPO_VISITANTE")
	private Equipo equipo1;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="NOMBRE_EQUIPO_LOCAL")
	private Equipo equipo2;

	public Partido() {
	}

	public long getIdPartido() {
		return this.idPartido;
	}

	public void setIdPartido(long idPartido) {
		this.idPartido = idPartido;
	}

	public BigDecimal getPuntosLocal() {
		return this.puntosLocal;
	}

	public void setPuntosLocal(BigDecimal puntosLocal) {
		this.puntosLocal = puntosLocal;
	}

	public BigDecimal getPuntosVisitante() {
		return this.puntosVisitante;
	}

	public void setPuntosVisitante(BigDecimal puntosVisitante) {
		this.puntosVisitante = puntosVisitante;
	}

	public String getTemporada() {
		return this.temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public Equipo getEquipo1() {
		return this.equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return this.equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

}