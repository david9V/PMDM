
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) throws NumberFormatException, IOException, SQLException {
		menu();
	}

	public static void menu() throws NumberFormatException, IOException, SQLException {
		LibroBD libroBD = new LibroBD();
		SocioBD socioBD = new SocioBD();
		PrestamoBD prestamoBD = new PrestamoBD();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		int opc;
		do {
			opciones();
			opc = Integer.parseInt(reader.readLine());
			switch (opc) {
			case 1 -> {
				try {
					System.out.println("Introduzca la ID del libro a modificar");
					int id = Integer.parseInt(reader.readLine());
					Libro mod = libroBD.encontrarIdLibro(id);
					System.out.println(mod);
					System.out.println("¿Desea cambiar el título o la editorial?");
					System.out.println("1- Título");
					System.out.println("2- Editorial");
					int opcMod = Integer.parseInt(reader.readLine());
					if (opcMod == 1) {
						System.out.println("Introduzca el nuevo título");
						String titulo = reader.readLine();
						libroBD.modificarTitulo(titulo, id);
						System.out.println("Título modificado con éxito");
					} else if (opcMod == 2) {
						System.out.println("Introduzca la nueva editorial");
						String editorial = reader.readLine();
						libroBD.modificarEditorial(editorial, id);
						System.out.println("Editorial modificada con éxito");
					} else System.out.println("Error, opción no válida");
					
				} catch(SQLException e) {
					mostrarExcepciones(e);
				} catch(ExcepcionID e) {
					System.out.println("Imposible modificar, libro no encontrado");
				}
				
			}
			case 2 -> {
				try {
					System.out.println("1- Consulta por título");
					System.out.println("2- Consulta por editorial");
					int opcConsulta = Integer.parseInt(reader.readLine());
					if (opcConsulta == 1) {
						System.out.println("Introduzca el título");
						String titulo = reader.readLine();
						ArrayList<Libro> lista = libroBD.mostrarPorTitulo(titulo);
						System.out.println(lista);
					} else if (opcConsulta == 2) {
						System.out.println("Introduzca la editorial");
						String editorial = reader.readLine();
						ArrayList<Libro> lista = libroBD.mostrarPorEditorial(editorial);
						System.out.println(lista);
					} else System.out.println("Error, opción no válida");
				} catch(SQLException e) {
					mostrarExcepciones(e);
				} catch(ExcepcionPersonalizada e) {
					System.out.println("No se obtuvieron resultados");
				}
				
			}
			case 3 -> {
				try {
					System.out.println("Introduzca la id del libro");
					int idLibro = Integer.parseInt(reader.readLine());
					libroBD.existeLibro(idLibro);
					System.out.println("Introduzca la id del socio");
					int idSocio = Integer.parseInt(reader.readLine());
					socioBD.existeSocio(idSocio);
					prestamoBD.insertarPrestamo(idLibro, idSocio);
					System.out.println("Préstamo insertado con éxito");
				} catch(SQLException e) {
					mostrarExcepciones(e);
				} catch(ExcepcionID e) {
					System.out.println("Imposible insertar préstamo, no existe el libro");
				} catch(ExcepcionPersonalizada e) {
					System.out.println("Imposible insertar préstamo, no existe el socio");
				}
				
			}
			case 4 -> {
				try {
					System.out.println("Introduzca la ID del socio");
					int idSocio = Integer.parseInt(reader.readLine());
					socioBD.existeSocio(idSocio);
					String nombreSocio = socioBD.devolverNombreSocio(idSocio); 
					ArrayList<Bundle> ids_libros = prestamoBD.devolverLibrosDeSocio(idSocio);
					System.out.println("Socio: " +nombreSocio);
					
					for(int i = 0; i < ids_libros.size(); i++) {
						System.out.print("---LIBRO | " );
						System.out.print("Título: " + libroBD.devolverNombreLibro(ids_libros.get(i).getId()));
						System.out.print(", Editorial: " + libroBD.devolverEditorialLibro(ids_libros.get(i).getId()));
						System.out.print(", Fecha de préstamo: " + ids_libros.get(i).getFechaInicio());
						System.out.print(", Fecha de devolución: " + ids_libros.get(i).getFechaFin());
						System.out.println();
					}
				} catch(SQLException e) {
					mostrarExcepciones(e);
				} catch(ExcepcionPersonalizada e) {
					System.out.println("No existe un socio asociado a esa ID");
				} catch(ExcepcionPersonalizada2 e) {
					System.out.println("El socio no tiene ningún libro prestado");
				}
				
			}

			}
			System.out.println();
		} while (opc < 5 && opc > 0);
		
		libroBD.conexion.cerrarConexion();
		socioBD.conexion.cerrarConexion();
		prestamoBD.conexion.cerrarConexion();
	}

	public static void opciones() {
		System.out.println("1- Modificación de libros");
		System.out.println("2- Consulta de libros");
		System.out.println("3- Préstamo de libros");
		System.out.println("4- Listado de libros prestados a un socio determinado");
		System.out.println("5- Salir");
		System.out.println();
	}

	public static void mostrarExcepciones(SQLException ex) {
		System.out.println("\n--- SQLException capturada ---\n");
		while (ex != null) {
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("ErrorCode: " + ex.getErrorCode());
			ex = ex.getNextException();
			System.out.println("");
		}
	}

}
