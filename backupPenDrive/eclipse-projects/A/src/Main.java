
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
		// ClaseBD c = new ClaseBD();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // BUFFERED READER
		int opc;
		do {
			opciones();
			opc = Integer.parseInt(reader.readLine());
			switch (opc) {
			case 1 -> {

			}
			case 2 -> {

			}
			case 3 -> {

			}
			case 4 -> {

			}
			case 5 -> {

			}
			case 6 -> {

			}

			}
			System.out.println();
		} while (opc < 7);
		//c.conexion.cerrarConexion();

	}

	public static void opciones() {
		System.out.println("1- ");
		System.out.println("2- ");
		System.out.println("3- ");
		System.out.println("4- ");
		System.out.println("5- ");
		System.out.println("6- ");
		System.out.println();
		System.out.println("7- Salir");
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
