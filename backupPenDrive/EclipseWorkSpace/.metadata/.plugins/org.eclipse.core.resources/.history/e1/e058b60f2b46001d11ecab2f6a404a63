package pruebaXMSLTDH;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// Define que el elemento raíz del objeto Java se llamará empleado.
@XmlRootElement(name = "empleado")
@XmlType(propOrder = { "dni", "nombre", "edad", "puesto" })
public class Empleado {
	private String dni;
	private String nombre;
	private int edad;
	private String puesto;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@XmlElement(name = "cargo")
	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
}