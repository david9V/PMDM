package pruebaXML2;

public class Coche {
	private String id;
	private String marca;
	private String modelo;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nId: "+id);
		sb.append("\nMarca: "+marca);
		sb.append("\nModelo: "+modelo);
		return sb.toString();
	}
	
}
