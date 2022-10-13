package pruebaXMSLTDH;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empresa")
public class Empresa {
	private String cif;
	private String nombre;
	private ArrayList<Empleado> empleados;

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

// Para crear un wrapper llamado empleados que englobe la estructura XML
//de los objetos Empleado.
	@XmlElementWrapper(name = "empleados")
	@XmlElement(name = "empleado")
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}
}