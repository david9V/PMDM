package pruebaCafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCAFES {
	private static String createTableCafes = "CREATE TABLE CAFES " + "(CAFE_NOMBRE VARCHAR(32), " + "PROV_ID INTEGER, "
			+ "PRECIO FLOAT, " + "VENTAS INTEGER, " + "TOTAL INTEGER)";

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.0.2:1521:xe", "david", "david");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(createTableCafes);
			stmt.close();
			conn.close();
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