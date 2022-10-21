package act;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	Connection conn;
	String usuario;
	String contraseña;
	String ip;
	
	
	ConexionBD(){
		cargarDriver();
	}
	
	void cargarDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	void setConDatos(String usuario, String contraseña, String ip) {
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.ip = ip;
	}
	
	void establecerConexion() throws SQLException {
		this.conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":1521:xe", usuario, contraseña);
	}
	
	Connection getConexion() {
		return this.conn;
	}
	
	void cerrarConexion() throws SQLException {
		this.conn.close();
	}
	
}
