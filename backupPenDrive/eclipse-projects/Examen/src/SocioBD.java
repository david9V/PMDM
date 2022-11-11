import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SocioBD {
	ConexionJDBC conexion;

	String instruccion;

	Statement sentencia;

	SocioBD() throws SQLException {
		this.conexion = new ConexionJDBC();
		this.conexion.establecerConexion();
	}
	
	void existeSocio(int id) throws SQLException, ExcepcionPersonalizada {
		this.instruccion = "SELECT * FROM SOCIOS WHERE ID_SOCIO="+id;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		
		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionPersonalizada();
		}
	}
	
	String devolverNombreSocio(int id) throws SQLException {
		this.instruccion = "SELECT * FROM SOCIOS WHERE ID_SOCIO="+id;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		rs.next();
		
		return rs.getString("NOMBRE_SOCIO");
	}
	
}
