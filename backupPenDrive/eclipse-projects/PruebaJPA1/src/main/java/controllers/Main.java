package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Empleado;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		menu();
	}
	
	public static void menu() throws NumberFormatException, IOException {
		EmpleadoBD empleadoBD = new EmpleadoBD();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // BUFFERED READER
		int opc;
		do {
			opciones();
			opc = Integer.parseInt(reader.readLine());
			switch (opc) {
			case 1 -> {
				ArrayList<Empleado> lista = empleadoBD.mostrarTodos();
				if (lista.size() > 0)
					System.out.println(lista);
				else
					System.out.println("Campos vacios");
				
			}
			case 2 -> {
				System.out.println("Introduzca la id del empleado a mostrar");
				long id = Long.parseLong(reader.readLine());
				Empleado emp = empleadoBD.mostrarUno(id);
				
				if (emp != null)
					System.out.println(emp);
				else
					System.out.println("Empleado no encontrado");
				
			}
			case 3 -> {
				System.out.println("Nombre:");
				String nombre = reader.readLine();
				System.out.println("Edad:");
				Integer edad = Integer.parseInt(reader.readLine());
				System.out.println("NIF");
				String nif = reader.readLine();
				Empleado emp = new Empleado(nombre, nif, edad);
				
				if (empleadoBD.insertarEmp(emp)) System.out.println("Empleado insertado correctamente");
				else System.out.println("No se ha podido insertar");
			}
			case 4 -> {
				System.out.println("Introduzca la id");
				long id = Long.parseLong(reader.readLine());
				if (empleadoBD.mostrarUno(id) != null) {
					System.out.println("Nombre:");
					String nombre = reader.readLine();
					System.out.println("Edad:");
					Integer edad = Integer.parseInt(reader.readLine());
					System.out.println("NIF");
					String nif = reader.readLine();
					Empleado emp = new Empleado(id, nombre, nif, edad);
					empleadoBD.modificarEmp(emp);
				} else
					System.out.println("Empleado no encontrado");
				
			}
			case 5 -> {
				System.out.println("Introduzca la id");
				long id = Long
			}
			case 6 -> {

			}

			}
			System.out.println();
		} while (opc < 6);

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
