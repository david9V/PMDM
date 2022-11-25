package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ASIGNATURA database table.
 * 
 */
@Entity
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;

	private BigDecimal creditos;

	private String titulo;

	//bi-directional many-to-one association to Matriculacion
	@OneToMany(mappedBy="asignatura")
	private List<Matriculacion> matriculacions;

	public Asignatura() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getCreditos() {
		return this.creditos;
	}

	public void setCreditos(BigDecimal creditos) {
		this.creditos = creditos;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Matriculacion> getMatriculacions() {
		return this.matriculacions;
	}

	public void setMatriculacions(List<Matriculacion> matriculacions) {
		this.matriculacions = matriculacions;
	}

	public Matriculacion addMatriculacion(Matriculacion matriculacion) {
		getMatriculacions().add(matriculacion);
		matriculacion.setAsignatura(this);

		return matriculacion;
	}

	public Matriculacion removeMatriculacion(Matriculacion matriculacion) {
		getMatriculacions().remove(matriculacion);
		matriculacion.setAsignatura(null);

		return matriculacion;
	}

}