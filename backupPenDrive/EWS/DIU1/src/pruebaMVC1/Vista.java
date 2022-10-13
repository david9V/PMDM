package pruebaMVC1;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Vista extends JFrame implements Observer{
	JTextField valor;
	JButton sumar;
	ActionListener controlador;
	
	public Vista(Modelo modelo) {
		setLayout(null);
		sumar = new JButton("Finalizar");
		valor = new JTextField("0", 20);
		sumar.setBounds(300, 250, 100, 30);
		valor.setBounds(200, 100, 100, 30);
		add(sumar);
		add(valor);
		controlador = new Controlador(modelo);
		sumar.addActionListener(controlador);
	}

	@Override
	public void update(Observable o, Object arg) {
		Modelo modelo = (Modelo) o;
		Integer i = new Integer(modelo.obtenerValor());
		valor.setText(i.toString());
		System.out.println("He recibido la actualización");
	}
	
	public void activar() {
		setVisible(true);
	}
}
