package pruebaMVC1;

public class MVC {
	public static void main(String args[]) {
		Modelo modelo = Modelo.getSingletonInstance();
		Modelo modelo2 = Modelo.getSingletonInstance();
		Vista vista = new Vista(modelo);
		Vista vista2 = new Vista(modelo2);
		modelo.addObserver(vista);
		modelo2.addObserver(vista2);
		vista.activar();
		vista2.sumar.setBounds(0, 0, 0, 0);
		vista2.activar();
	}
}
