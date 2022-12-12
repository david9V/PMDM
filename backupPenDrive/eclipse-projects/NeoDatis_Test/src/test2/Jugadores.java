package test2;

public class Jugadores {
	
	String pais;

	public Jugadores() {
		super();
	}

	public Jugadores(String pais) {
		this.pais = pais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return pais;
	}
	
	
}
