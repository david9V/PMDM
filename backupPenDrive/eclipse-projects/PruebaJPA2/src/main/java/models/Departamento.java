package models;

import java.util.Collection;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombre;
	
	@OneToMany(mappedBy="departamento", cascade=CascadeType.REMOVE)
	private Collection<Empleado> empleados = new HashSet();
	
	public Departamento(String nombre, Collection<Empleado> empleados) {
		this.nombre = nombre;
		this.empleados = empleados;
	}
	
	public Departamento() {
		
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
	public Collection<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Collection<Empleado> empleados) {
		this.empleados = empleados;
	}
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", empleados=" + empleados + "]";
	}
	
	
}
/*
TypedQuery<Departamento> departamentos = em.createQuery("select d from Departamento d", Departamento.class);
for (Departamento d : departamentos.getResultList()) {
	System.out.println("Departamento: " + d.getNombre());
	for (Empleado e : d.getEmpleados()) {
		System.out.println("Empleado : " + e.getNombre());
	}
}
*/
