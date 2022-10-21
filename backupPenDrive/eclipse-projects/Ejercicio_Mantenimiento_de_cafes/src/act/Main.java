package act;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String args[]) throws SQLException, NumberFormatException, IOException {
		CafeBD bd = new CafeBD();
		insertarDatosBD(bd); // 172.17.0.2
		menu(bd);
	}

	public static void menu(CafeBD bd) throws NumberFormatException, IOException, SQLException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int opc;
		do {
			opciones();
			opc = Integer.parseInt(reader.readLine());
			switch (opc) {
			case 1 -> {
				System.out.println("Introduzca el nombre del café a modificar:");
				String nombre = reader.readLine();
				System.out.println("Introduzca el nuevo número de ventas;");
				int ventas = Integer.parseInt(reader.readLine());
				
				if (bd.actualizarCafe(nombre, ventas)) {
					System.out.println("Ha ocurrido un error al intentar realizar la modificación");
				}
			}
			case 2 -> {
				System.out.println("Introduzca el nombre del café:");
				String nombre = reader.readLine();
				System.out.println("Introduzca la ID de proveedor:");
				int id_prov = Integer.parseInt(reader.readLine());
				System.out.println("Introduzca el precio:");
				double precio = Double.parseDouble(reader.readLine());
				System.out.println("Introduzca el número de ventas:");
				int ventas = Integer.parseInt(reader.readLine());
				System.out.println("Introduzca el total:");
				int total = Integer.parseInt(reader.readLine());
				Cafe c = new Cafe(nombre, id_prov, precio, ventas, total);
				
				if (bd.añadirCafe(c)) {
					System.out.println("Ha ocurrido un error al intentar añadir una nueva entrada");
				}
			}
			case 3 -> {
				System.out.println("Introduzca el nombre del café a borrar");
				String nombre = reader.readLine();
				
				if (bd.borrarCafe(nombre)) {
					System.out.println("Ha ocurrido un error al intentar realizar la eliminación");
				}
			}
			case 4 -> {
				System.out.println("Introduzca el nombre del café a mostrar");
				String nombre = reader.readLine();
				try {					
					System.out.println(bd.mostrarCafe(nombre));
				} catch (SQLException e) {
					System.out.println("Ha ocurrido un error al intentar mostrar la entrada");
				}
			}
			case 5 -> {
				try {
					ArrayList<Cafe> l = bd.mostrarTodos();		
					for (Cafe c : l) {
						System.out.println(c);
					}
				} catch(SQLException e) {
					System.out.println("Ha ocurrido un erro al intentar listar todas las entradas");
				}
			}
			}
		} while (opc < 6);
		bd.finalizarSentencia();
		bd.conexion.cerrarConexion();
	}

	public static void opciones() {
		System.out.println("1- Actualizar un café");
		System.out.println("2- Añadir un nuevo café");
		System.out.println("3- Borrar un café");
		System.out.println("4- Mostrar un café");
		System.out.println("5- Mostrar todos los resultados");
		System.out.println();
		System.out.println("6- Salir");
	}
	
	public static void insertarDatosBD(CafeBD bd) throws SQLException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("IP: ");
		String ip = reader.readLine();
		System.out.println("Usuario: ");
		String usuario = reader.readLine();
		System.out.println("Contraseña: ");
		String contraseña = reader.readLine();
		bd.conexion.setConDatos(usuario, contraseña, ip);
		bd.conexion.establecerConexion();
	}
}
