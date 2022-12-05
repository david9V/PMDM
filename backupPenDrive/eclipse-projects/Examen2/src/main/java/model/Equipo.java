package model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the EQUIPOS database table.
 * 
 */
@Entity
@Table(name="EQUIPOS")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NOMBRE_EQUIPO")
	private String nombreEquipo;

	private String ciudad;

	private String division;

	//bi-directional many-to-one association to Jugadore
	@OneToMany(mappedBy="equipo")
	private List<Jugadore> jugadores;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipo1")
	private List<Partido> partidos1;

	//bi-directional many-to-one association to Partido
	@OneToMany(mappedBy="equipo2")
	private List<Partido> partidos2;

	public Equipo() {
	}

	public String getNombreEquipo() {
		return this.nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public List<Jugadore> getJugadores() {
		return this.jugadores;
	}

	public void setJugadores(List<Jugadore> jugadores) {
		this.jugadores = jugadores;
	}

	public Jugadore addJugadore(Jugadore jugadore) {
		getJugadores().add(jugadore);
		jugadore.setEquipo(this);

		return jugadore;
	}

	public Jugadore removeJugadore(Jugadore jugadore) {
		getJugadores().remove(jugadore);
		jugadore.setEquipo(null);

		return jugadore;
	}

	public List<Partido> getPartidos1() {
		return this.partidos1;
	}

	public void setPartidos1(List<Partido> partidos1) {
		this.partidos1 = partidos1;
	}

	public Partido addPartidos1(Partido partidos1) {
		getPartidos1().add(partidos1);
		partidos1.setEquipo1(this);

		return partidos1;
	}

	public Partido removePartidos1(Partido partidos1) {
		getPartidos1().remove(partidos1);
		partidos1.setEquipo1(null);

		return partidos1;
	}

	public List<Partido> getPartidos2() {
		return this.partidos2;
	}

	public void setPartidos2(List<Partido> partidos2) {
		this.partidos2 = partidos2;
	}

	public Partido addPartidos2(Partido partidos2) {
		getPartidos2().add(partidos2);
		partidos2.setEquipo2(this);

		return partidos2;
	}

	public Partido removePartidos2(Partido partidos2) {
		getPartidos2().remove(partidos2);
		partidos2.setEquipo2(null);

		return partidos2;
	}

	@Override
	public String toString() {
		return "Equipo [nombreEquipo=" + nombreEquipo + ", ciudad=" + ciudad + ", division=" + division + "]\n";
	}
	
	

}