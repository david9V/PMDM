package models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Compartimento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;
	private String descripcion;
	private Empleado empleadoResidente;
	
	public Compartimento(String descripcion, Empleado empleadoResidente) {
		this.descripcion = descripcion;
		this.empleadoResidente = empleadoResidente;
	}
	
	public Compartimento() {
		
	}

	public long getIdc() {
		return idc;
	}

	public void setIdc(long idc) {
		this.idc = idc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToOne(mappedBy="compartimentoAsignado")
	public Empleado getEmpleadoResidente() {
		return empleadoResidente;
	}

	public void setEmpleadoResidente(Empleado empleadoResidente) {
		this.empleadoResidente = empleadoResidente;
	}

	@Override
	public String toString() {
		return "Compartimento [idc=" + idc + ", descripcion=" + descripcion + ", empleadoResidente=" + empleadoResidente
				+ "]";
	}
	
	
}
