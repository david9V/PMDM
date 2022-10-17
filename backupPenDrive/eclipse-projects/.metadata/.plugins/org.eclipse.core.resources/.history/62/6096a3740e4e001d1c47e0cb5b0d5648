package pruebaCafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Ejemplo3 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.0.2:1521:xe", "david", "david");
			Statement stmt = conn.createStatement();
			String query = "SELECT CAFE_NOMBRE, PRECIO FROM CAFES";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String s = rs.getString("CAFE_NOMBRE");
				Float n = rs.getFloat("PRECIO");
				System.out.println(s + " " + n);
			}
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
	}
}
