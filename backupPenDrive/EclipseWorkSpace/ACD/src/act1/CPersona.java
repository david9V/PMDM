package act1;

import java.io.Serializable;

public class CPersona implements Serializable{
	String nombre;
	String direccion;
	long telefono;
	
	public CPersona(String nombre, String direccion, long telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean equals(Object obj) {
		CPersona p = (CPersona) obj;
		if (p.getNombre().equals(this.nombre)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "[nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
}
	