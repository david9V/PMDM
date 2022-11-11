import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class PrestamoBD {
	
	ConexionJDBC conexion;

	String instruccion;

	Statement sentencia;

	PrestamoBD() throws SQLException {
		this.conexion = new ConexionJDBC();
		this.conexion.establecerConexion();
	}
	
	void insertarPrestamo(int idLibro, int idSocio) throws SQLException {
		this.instruccion = "INSERT INTO PRESTAMOS " + "VALUES (" +idLibro+ ", "+idSocio+", SYSDATE, SYSDATE + 7)";
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();
	}
	
	ArrayList<Bundle> devolverLibrosDeSocio(int idSocio) throws SQLException, ExcepcionPersonalizada2 {
		ArrayList<Bundle> ids_libros = new ArrayList<>();
		
		this.instruccion = "SELECT * FROM PRESTAMOS WHERE ID_SOCIO="+idSocio;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		
		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionPersonalizada2();
		} else {
			while(rs.next()) {
				ids_libros.add(new Bundle(rs.getInt("ID_LIBRO"), rs.getDate("FECHA_INICIO").toString(), rs.getDate("FECHA_FIN").toString()));
			}
		}
		
		return ids_libros;
	}
	
}
