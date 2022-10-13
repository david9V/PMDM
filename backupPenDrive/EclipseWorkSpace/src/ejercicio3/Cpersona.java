package ejercicio3;

public class Cpersona {
	String nombre;
	String direccion;
	long telefono;
	
	public Cpersona(String nombre, String direccion, long telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean equals(Object obj) {
		Cpersona p = (Cpersona) obj;
		if (p.getNombre().equals(this.nombre)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Cpersona [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
	
	
	
	
	
}
