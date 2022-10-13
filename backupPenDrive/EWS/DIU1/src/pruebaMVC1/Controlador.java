package pruebaMVC1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
	private Modelo modelo;

	public Controlador(Modelo modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("El botón ha sido pulsado");
		modelo.sumar();
	}
}
