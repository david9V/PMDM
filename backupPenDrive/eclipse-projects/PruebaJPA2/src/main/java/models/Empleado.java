package models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_completo", unique = true)
	private String nombre;
	private String nif;
	private Integer edad;
	
	//@OneToOne
	//private Compartimento compartimentoAsignado;
	
	@ManyToOne
	private Departamento departamento;

	public Empleado(String nombre, String nif, Integer edad) {
		this.nombre = nombre;
		this.nif = nif;
		this.edad = edad;
	}
	
	public Empleado() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	

//	public Compartimento getCompartimentoAsignado() {
//		return compartimentoAsignado;
//	}
//
//	public void setCompartimentoAsignado(Compartimento compartimentoAsignado) {
//		this.compartimentoAsignado = compartimentoAsignado;
//	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", nif=" + nif + ", edad=" + edad + ", departamento="
				+ departamento + "]";
	}

	

	
}
