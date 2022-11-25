package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MATRICULACION database table.
 * 
 */
@Entity
@NamedQuery(name="Matriculacion.findAll", query="SELECT m FROM Matriculacion m")
public class Matriculacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatriculacionPK id;

	private BigDecimal nota;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="DNI")
	private Alumno alumno;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="COD_ASIGNATURA")
	private Asignatura asignatura;

	public Matriculacion() {
	}

	public MatriculacionPK getId() {
		return this.id;
	}

	public void setId(MatriculacionPK id) {
		this.id = id;
	}

	public BigDecimal getNota() {
		return this.nota;
	}

	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

}