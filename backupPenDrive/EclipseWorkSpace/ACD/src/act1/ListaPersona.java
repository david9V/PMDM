package act1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaPersona implements Serializable{
	List<CPersona> lista = new ArrayList<CPersona>();
	
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
	
	public String buscarPersona() {
		boolean c = false;
		System.out.println("Introduzca el nombre de la persona: ");
		String nombrePersona = dato();
		
		for (CPersona p : lista) {
			if (p.getNombre().equals(nombrePersona) && c == false) {
				System.out.println("Nombre: " + p.nombre);
				System.out.println("Dirección: " + p.direccion);
				System.out.println("Teléfono: " + p.telefono);
				c = true;
			}
		}
		
		return nombrePersona;
	}
	
	public void buscarTodasPersonas(String nombrePersona) {
		if (nombrePersona.isBlank()) {
			System.out.println("No ha escrito ninguna persona");
		} else {
			System.out.println("Personas con ese nombre: ");
			for (CPersona p : lista) {
				if (p.getNombre().equals(nombrePersona)) {
					System.out.println(p);
				}
			}
		}
	}
	
	public void altaPersona() {
		System.out.println("Introduzca el nombre de la persona: ");
		String nombrePersona = dato();
		System.out.println("Introduzca la dirección de la persona: ");
		String direccion = dato();
		System.out.println("Introduzca el teléfono de la persona: ");
		long telefono = datoLong();
		CPersona p = new CPersona(nombrePersona, direccion, telefono);
		if(lista.add(p)) {
			System.out.println("Persona añadida correctamente");
		} else {
			System.out.println("Error");
		}
	}
	
	public void mostarPersonas() {
		System.out.println("Listado de personas: ");
		for(CPersona p : lista) {
			System.out.println(p);
		}
	}
	
	void eliminarPersona() {
		boolean encontrado = false;
		System.out.println("Introduzca el nombre de la persona: ");
		String nombrePersona = dato();
		int indice = 0;
		int i = 0;
		for (CPersona p : lista) {
			if (p.getNombre().equals(nombrePersona)) {
				encontrado = true;
				indice = i;
			}
			i++;
		}
		if (encontrado) {
			this.lista.remove(indice);
			System.out.println("Persona borrada");
		} else {
			System.out.println("No se ha encontrado ninguan persona con ese nombre");
		}
		
	}
	
	public void leerFichero() {
		ObjectInputStream in = null;
		try {
			File fichero = new File("act1.dat");
			in = new ObjectInputStream(new FileInputStream(fichero));
			if (fichero.exists()) {
				System.out.println("Se ha leído un fichero, guardando datos");
				this.lista = (ArrayList) in.readObject();
			} else {
				System.out.println("No se ha encontrado ningún fichero, se creará uno nuevo");
			}
			
		} catch(IOException | ClassNotFoundException ex) {
		}
	}
	
	public void escribirFichero() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("act1.dat"));
			System.out.println("Escribiendo fichero...");
			out.writeObject(this.lista);
			System.out.println("Fin");
		} catch(IOException ex) {
			
		} finally {
			try {
				out.close();
			} catch(IOException ex) {
				
			}
		}
	}
	
	
	
}