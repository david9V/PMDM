package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the JUGADORES database table.
 * 
 */
@Entity
@Table(name="JUGADORES")
@NamedQuery(name="Jugadore.findAll", query="SELECT j FROM Jugadore j")
public class Jugadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_JUGADOR")
	private long idJugador;

	private BigDecimal altura;

	private String nombre;

	private BigDecimal peso;

	private String posicion;

	private String procedencia;

	//bi-directional many-to-one association to Estadistica
	@OneToMany(mappedBy="jugadore")
	private List<Estadistica> estadisticas;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="NOMBRE_EQUIPO")
	private Equipo equipo;

	public Jugadore() {
	}

	public long getIdJugador() {
		return this.idJugador;
	}

	public void setIdJugador(long idJugador) {
		this.idJugador = idJugador;
	}

	public BigDecimal getAltura() {
		return this.altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getProcedencia() {
		return this.procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public List<Estadistica> getEstadisticas() {
		return this.estadisticas;
	}

	public void setEstadisticas(List<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

	public Estadistica addEstadistica(Estadistica estadistica) {
		getEstadisticas().add(estadistica);
		estadistica.setJugadore(this);

		return estadistica;
	}

	public Estadistica removeEstadistica(Estadistica estadistica) {
		getEstadisticas().remove(estadistica);
		estadistica.setJugadore(null);

		return estadistica;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return this.idJugador + ", " + this.nombre + ": " + this.altura;
	}
	
	

}