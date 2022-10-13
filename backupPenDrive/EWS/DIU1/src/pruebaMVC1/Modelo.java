package pruebaMVC1;

import java.util.Observable;

public class Modelo extends Observable{
	int valor;
	private static Modelo unico;
	
	private Modelo(){
		valor = 0;
	}
	
	void sumar() {
		System.out.println("Procedemos a incrementar el contador");
		valor++;
		setChanged();
		notifyObservers();
	}
	
	int obtenerValor() {
		return valor;
	}
	
	public static Modelo getSingletonInstance() {
		if (unico == null) {
			unico = new Modelo();
		} else {
			System.out.println("No se pudo crear porque ya hay una instancia de esta clase");
		}
		
		return unico;
	}
}
