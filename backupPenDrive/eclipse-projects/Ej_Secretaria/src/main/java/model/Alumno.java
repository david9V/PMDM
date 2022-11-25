package model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ALUMNO database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dni;

	private String apellidos;

	private String domicilio;

	private String nombre;

	private String telefono;

	private BigDecimal tipoacceso;

	//bi-directional many-to-one association to Matriculacion
	@OneToMany(mappedBy="alumno")
	private List<Matriculacion> matriculacions;

	public Alumno() {
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public BigDecimal getTipoacceso() {
		return this.tipoacceso;
	}

	public void setTipoacceso(BigDecimal tipoacceso) {
		this.tipoacceso = tipoacceso;
	}

	public List<Matriculacion> getMatriculacions() {
		return this.matriculacions;
	}

	public void setMatriculacions(List<Matriculacion> matriculacions) {
		this.matriculacions = matriculacions;
	}

	public Matriculacion addMatriculacion(Matriculacion matriculacion) {
		getMatriculacions().add(matriculacion);
		matriculacion.setAlumno(this);

		return matriculacion;
	}

	public Matriculacion removeMatriculacion(Matriculacion matriculacion) {
		getMatriculacions().remove(matriculacion);
		matriculacion.setAlumno(null);

		return matriculacion;
	}

}