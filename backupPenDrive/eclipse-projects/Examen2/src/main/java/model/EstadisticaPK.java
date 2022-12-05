package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the ESTADISTICAS database table.
 * 
 */
@Embeddable
public class EstadisticaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String temporada;

	@Column(name="ID_JUGADOR", insertable=false, updatable=false)
	private long idJugador;

	public EstadisticaPK() {
	}
	public String getTemporada() {
		return this.temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public long getIdJugador() {
		return this.idJugador;
	}
	public void setIdJugador(long idJugador) {
		this.idJugador = idJugador;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EstadisticaPK)) {
			return false;
		}
		EstadisticaPK castOther = (EstadisticaPK)other;
		return 
			this.temporada.equals(castOther.temporada)
			&& (this.idJugador == castOther.idJugador);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.temporada.hashCode();
		hash = hash * prime + ((int) (this.idJugador ^ (this.idJugador >>> 32)));
		
		return hash;
	}
}