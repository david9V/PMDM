package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListaPersona {
	List<Cpersona> lista = new ArrayList<Cpersona>();
	
	ListaPersona(){
		
	}
	
	public  String dato() {
		String dato = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			dato = flujoE.readLine();
		} catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return dato;
	}
	
	public long datoLong() {
		try {
			return Long.parseLong(dato());
		} catch(NumberFormatException e) {
			return Long.MIN_VALUE;
		}
	}
	
	public void buscarPersona() {
		System.out.println("Introduzca el nombre de la persona: ");
		String nombrePersona = dato();
		for (Cpersona p : lista) {
			if (p.getNombre().equals(nombrePersona)) {
				System.out.println("Nombre: " + p.nombre);
				System.out.println("Dirección: " + p.direccion);
				System.out.println("Teléfono: " + p.telefono);
			}
		}
	}
	
	public void buscarTodasPersonas() {
		System.out.println("Introduzca el nombre de la persona: ");
		String nombrePersona = dato();
		String nombres = "";
		for (Cpersona p : lista) {
			if (p.getNombre().equals(nombrePersona)) {
				nombres += p.getNombre() + "\n";
			}
		}
		
		if (nombres.isEmpty()) {
			System.out.println("No se ha encontrado ninguna persona con ese nombre");
		} else {
			System.out.println("Personas con ese nombre: " + nombres);
		}
	}
	
	public void altaPersona() {
		System.out.println("Introduzca el nombre de la persona: ");
		String nombrePersona = dato();
		System.out.println("Introduzca la dirección de la persona: ");
		String direccion = dato();
		System.out.println("Introduzca el teléfono de la persona: ");
		long telefono = datoLong();
		Cpersona p = new Cpersona(nombrePersona, direccion, telefono);
		if(lista.add(p)) {
			System.out.println("Persona añadida correctamente");
		} else {
			System.out.println("Error");
		}
	}
	
	public void mostarPersonas() {
		System.out.println("Listado de personas: ");
		for(Cpersona p : lista) {
			System.out.println(p);
		}
	}
	
	public void eliminarPersona() {
		
	}
	
}
