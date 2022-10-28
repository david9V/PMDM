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
		if (insertarDatosBD(bd)) {
			menu(bd);
			// 172.17.0.2
		}

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
				try {
					bd.existe(nombre);
					System.out.println("Introduzca el nuevo número de ventas;");
					int ventas = Integer.parseInt(reader.readLine());
					bd.actualizarCafe(nombre, ventas);
				} catch (Excepcion e) {
					System.out.println("El café introducido no existe");
				}

			}
			case 2 -> {
				try {
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

					bd.añadirCafe(c);
				} catch (SQLException ex) {
					System.out.println("\n--- SQLException capturada ---\n");
					while (ex != null) {
						System.out.println("Mensaje: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("ErrorCode: " + ex.getErrorCode());
						ex = ex.getNextException();
						System.out.println("");
					}
				}
			}
			case 3 -> {
				try {
					System.out.println("Introduzca el nombre del café a borrar");
					String nombre = reader.readLine();
					bd.existe(nombre);
					System.out.println("¿Está seguro de que desea borrar la siguiente entrada? (S/N)");
					System.out.println(bd.mostrarCafe(nombre));
					String respuesta = reader.readLine();
					if (respuesta.equalsIgnoreCase("s")) {
						bd.borrarCafe(nombre);
					} else {
						System.out.println("Borrado cancelado");
					}
					
				} catch (SQLException ex) {
					System.out.println("\n--- SQLException capturada ---\n");
					while (ex != null) {
						System.out.println("Mensaje: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("ErrorCode: " + ex.getErrorCode());
						ex = ex.getNextException();
						System.out.println("");
					}
				} catch (Exception e) {
					System.out.println("El café introducido no existe");
				}

			}
			case 4 -> {
				try {
					System.out.println("Introduzca el nombre del café a mostrar");
					String nombre = reader.readLine();
					bd.existe(nombre);
					System.out.println(bd.mostrarCafe(nombre));
				} catch (SQLException ex) {
					System.out.println("\n--- SQLException capturada ---\n");
					while (ex != null) {
						System.out.println("Mensaje: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("ErrorCode: " + ex.getErrorCode());
						ex = ex.getNextException();
						System.out.println("");
					}
				} catch (Exception e) {
					System.out.println("El café introducido no existe");
				}
			}
			case 5 -> {
				try {
					ArrayList<Cafe> l = bd.mostrarTodos();
					for (Cafe c : l) {
						System.out.println(c);
					}
				} catch (SQLException ex) {
					System.out.println("\n--- SQLException capturada ---\n");
					while (ex != null) {
						System.out.println("Mensaje: " + ex.getMessage());
						System.out.println("SQLState: " + ex.getSQLState());
						System.out.println("ErrorCode: " + ex.getErrorCode());
						ex = ex.getNextException();
						System.out.println("");
					}
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

	public static boolean insertarDatosBD(CafeBD bd) throws IOException {
		boolean conectado = true;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("IP: ");
		String ip = reader.readLine();
		System.out.println("Usuario: ");
		String usuario = reader.readLine();
		System.out.println("Contraseña: ");
		String contraseña = reader.readLine();
		bd.conexion.setConDatos(usuario, contraseña, ip);
		try {
			bd.conexion.establecerConexion();
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexión con los datos introducidos");
			conectado = false;
		}

		return conectado;
	}
}
