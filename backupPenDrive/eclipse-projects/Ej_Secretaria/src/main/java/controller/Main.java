package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int opc = 0;
		do {
			opciones();
			try {
				opc = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (opc) {
			case 1 -> {
				altaAlumno();
			}
			case 2 -> {
				altaAsig();
			}
			case 3 -> {
				bajasAlumno();
			}
			case 4 -> {
				consultaAlumnoId();
			}
			case 5 -> {
				consultaAsigTitulo();
			}
			case 6 -> {
				realizarMatr();
			}
			case 7 -> {
				consultaAlumnosAsig();
			}

			}
			System.out.println();
		} while (opc < 8);
	}

	public static void altaAlumno() {

	}

	public static void altaAsig() {
		
	}

	public static void bajasAlumno() {
		
	}

	public static void consultaAlumnoId() {
		
	}

	public static void consultaAsigTitulo() {
		
	}

	public static void realizarMatr() {
		
	}

	public static void consultaAlumnosAsig() {
		
	}

	public static void opciones() {
		System.out.println("1- Mostrar todos los empleados");
		System.out.println("2- Mostrar un empleado");
		System.out.println("3- Insertar un nuevo empleado");
		System.out.println("4- Modificar un empleado existente");
		System.out.println("5- Borrar empleado existente");
		System.out.println();
		System.out.println("6- Salir");
	}

}
