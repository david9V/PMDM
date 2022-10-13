package act1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		menu();
	}
	
	static void opciones() {
		System.out.println("1- Buscar persona");
		System.out.println("2- Buscar siguientes personas");
		System.out.println("3- Añadir persona");
		System.out.println("4- Eliminar persona");
		System.out.println("5- Salir");
	}
	
	static void menu() {
		Scanner sc = new Scanner(System.in);
		int opc;
		ListaPersona lista = new ListaPersona();
		lista.leerFichero();
		String persona = "";
		do {
			opciones();
			opc = sc.nextInt();
			switch (opc) {
			case 1:{
				persona = lista.buscarPersona();
				break;
			}
			case 2:{
				lista.buscarTodasPersonas(persona);
				break;
			}
			case 3:{
				lista.altaPersona();
				break;
			}
			case 4:{
				lista.eliminarPersona();
				break;
			}
			case 5:{
				lista.escribirFichero();
				break;
			}
			}
		} while(opc != 5);
	}

}