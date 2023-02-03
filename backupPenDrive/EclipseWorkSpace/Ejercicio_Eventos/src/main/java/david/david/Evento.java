package david.david;

public class Evento {

	String id;
	
	String nombre;
	
	String fecha;
	
	String ciudad;
	
	int precio;

	public Evento(String id, String nombre, String fecha, String ciudad, int precio) {
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.precio = precio;
	}
	
	
	public Evento() {
		
	}
}
