package act;

public class Cafe {

	private String cafe_nombre;
	private int prov_id;
	private double precio;
	private int ventas;
	private int total;
	
	public Cafe(String cafe_nombre, int prov_id, double precio, int ventas, int total) {
		this.cafe_nombre = cafe_nombre;
		this.prov_id = prov_id;
		this.precio = precio;
		this.ventas = ventas;
		this.total = total;
	}

	public String getCafe_nombre() {
		return cafe_nombre;
	}

	public void setCafe_nombre(String cafe_nombre) {
		this.cafe_nombre = cafe_nombre;
	}

	public int getProv_id() {
		return prov_id;
	}

	public void setProv_id(int prov_id) {
		this.prov_id = prov_id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
