package test2;

public class Pais {

	int id;
	String nombrePais;
	
	public Pais() {
		super();
	}

	public Pais(int id, String nombrePais) {
		this.id = id;
		this.nombrePais = nombrePais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	@Override
	public String toString() {
		return nombrePais;
	}
	
	
}
