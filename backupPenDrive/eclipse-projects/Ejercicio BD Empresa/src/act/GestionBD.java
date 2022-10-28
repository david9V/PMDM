package act;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionBD {
	Connection conn;

	GestionBD(){
		cargarDriver();
	}
	
	void cargarDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	void establecerConexion() {
		try {
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.0.2:1521:xe", "EMPRESA", "EMPRESA");			
		} catch(SQLException ex) {
			System.out.println("\n--- SQLException capturada ---\n");
			while (ex != null) {
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("ErrorCode: " + ex.getErrorCode());
				ex = ex.getNextException();
				System.out.println("");
			}
		}
	}
	
	Connection getConexion() {
		return this.conn;
	}
	
	void cerrarConexion() {
		try {
			this.conn.close();			
		} catch (SQLException ex) {
			System.out.println("\n--- SQLException capturada ---\n");
			while (ex != null) {
				System.out.println("Mensaje: " + ex.getMessage());
				System.out.println("ErrorCode: " + ex.getErrorCode());
				ex = ex.getNextException();
				System.out.println("");
			}
		}
	}
	
}
