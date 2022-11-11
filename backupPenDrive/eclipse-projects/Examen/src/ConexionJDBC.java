
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionJDBC {
	Connection conn;

	ConexionJDBC() throws SQLException{
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
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@172.17.0.2:1521:xe", "EXAMEN", "EXAMEN");
						
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	Connection getConexion() {
		return this.conn;
	}
	
	void cerrarConexion() {
		try {
			this.conn.close();			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
