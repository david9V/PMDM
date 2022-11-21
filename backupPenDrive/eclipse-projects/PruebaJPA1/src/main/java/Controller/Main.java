package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Empleado;
import models.EmpleadoDAO;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		menu();
	}
	
	public static void menu(){
		EmpleadoDAO empleadoBD = new EmpleadoDAO();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // BUFFERED READER
		int opc = 0;
		do {
			opciones();
			try {
				opc = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			switch (opc) {
			case 1 -> {
				ArrayList<Empleado> lista = empleadoBD.mostrarTodos();
				if (lista.size() > 0)
					System.out.println(lista);
				else
					System.out.println("No hay ningún empleado");
				
			}
			case 2 -> {
				try {
					System.out.println("Introduzca la id del empleado a mostrar");
					long id = Long.parseLong(reader.readLine());
					Empleado emp = empleadoBD.mostrarUno(id);
					
					if (emp != null)
						System.out.println(emp);
					else
						System.out.println("Empleado no encontrado");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			case 3 -> {
				try {
					System.out.println("Nombre:");
					String nombre = reader.readLine();
					System.out.println("Edad:");
					Integer edad = Integer.parseInt(reader.readLine());
					System.out.println("NIF");
					String nif = reader.readLine();
					Empleado emp = new Empleado(nombre, nif, edad);
					
					if (empleadoBD.insertarEmp(emp)) System.out.println("Empleado insertado correctamente");
					else System.out.println("No se ha podido insertar");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			case 4 -> {
				try {
					System.out.println("Introduzca la id");
					long id = Long.parseLong(reader.readLine());
					Empleado e = empleadoBD.mostrarUno(id);
					if (e != null) {
						System.out.println(e);
						System.out.println("Nuevo nombre:");
						String nombre = reader.readLine();
						Empleado emp = new Empleado(id, nombre, e.getNif(), e.getEdad());
						empleadoBD.modificarEmp(emp);
						System.out.println("Empleado modificado");
					} else
						System.out.println("Empleado no encontrado");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			case 5 -> {
				try {
					System.out.println("Introduzca la id");
					long id = Long.parseLong(reader.readLine());
					Empleado e = empleadoBD.mostrarUno(id);
					if (e != null) {
						System.out.println("¿Está seguro de que desea borrar el siguiente empleado? (S/N)");
						System.out.println(e);
						String opcion = reader.readLine();
						if (opcion.equalsIgnoreCase("S")){
							if (empleadoBD.borrarEmp(id)) 
								System.out.println("Empleado borrado");
						} else
							System.out.println("Eliminación cancelada");
					} else
						System.out.println("Error, No existe ese empleado");
					
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
