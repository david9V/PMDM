package pruebaCafe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ActInsertCafe2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("Introduzca el nombre del café: ");
	    String nombre = reader.readLine();
	    System.out.println("Introduzca la ID del proveedor: ");
	    String id = reader.readLine();
	    System.out.println("Introduzca el precio del café: ");
	    String precio = reader.readLine();
	    System.out.println("Introduzca el número de ventas del café: ");
	    String ventas = reader.readLine();
	    
	    String instruccion = "INSERT INTO CAFES " + "VALUES ('"+nombre+"', "+String.valueOf(id)+", "+String.valueOf(precio)+", "+String.valueOf(precio)+", "+String.valueOf(ventas)+")";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.0.2:1521:xe", "david", "david");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(instruccion);
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}
