import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

public class ClaseBD {
	
	ConexionJDBC conexion;
	
	String instruccion;

	Statement sentencia;
	
	ClaseBD() throws SQLException {
		this.conexion = new ConexionJDBC();
		this.conexion.establecerConexion();
	}
	
	void finalizarSentencia() throws SQLException {
		this.sentencia.close();
	}
		
	/* EJEMPLO MOSTRAR CONSULTA
	 * void consultaDatosEmp(int emp_no) throws SQLException, ExcepcionEmpleado {
		this.sentencia = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = this.sentencia.executeQuery("SELECT EMPLE.* FROM EMPLE WHERE EMP_NO=" + emp_no);
		ResultSetMetaData rsmd = rs.getMetaData();
		int nColumnas = rsmd.getColumnCount();

		rs.next();
		for (int i = 1; i <= nColumnas; i++) {
			if (i > 1)
				System.out.print(",  ");
			String valor = rs.getString(i);
			System.out.print(rsmd.getColumnName(i) + "=" + valor);
		}
		System.out.println("");
	}
	 */
	
	
	////////////////////////////////
	
	/* EJEMPLO USAR PROCEDURE
	 * void subidaSalario(int dep, int subida) throws ExcepcionDepartamento, SQLException {
		CallableStatement cstmt = this.conexion.getConexion().prepareCall("{call SUBIDA_SAL(?,?)}");

		cstmt.registerOutParameter(1, Types.INTEGER);
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.setInt(1, dep);
		cstmt.setInt(2, subida);
		cstmt.execute();
		cstmt.close();
	}
	 */
	
	///////////////////////////////////////
	
	/* EJEMPLO VER SI EXISTE ENTRADA Y LANZAR EXCEPCION
	 * void noExisteEmpleado(int n) throws SQLException, ExcepcionEmpleado {
		this.instruccion = "SELECT * FROM EMPLE WHERE EMP_NO="+n;
		this.sentencia = this.conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionEmpleado();
		}
	}
	 */
	
	///////////////////////////////////////
	///////////////////////////////////////
	///////////////////////////////////////
	
	/* EJEMPLO UPDATE
	 * void actualizarCafe(String nombreCafe, int ventas) throws SQLException {
		this.instruccion = "UPDATE CAFES SET VENTAS=" + ventas + " WHERE CAFE_NOMBRE='" + nombreCafe + "'";
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();
	}
	 */
	
	///////////////////////////////////////

	/* EJEMPLO INSERT
	 * void añadirCafe(Cafe cafe) throws SQLException {
		this.instruccion = "INSERT INTO CAFES " + "VALUES ('" + cafe.getCafe_nombre() + "', " + cafe.getProv_id() + ", "
				+ cafe.getPrecio() + ", " + cafe.getVentas() + ", " + cafe.getTotal() + ")";
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();
	}
	 */
	
	///////////////////////////////////////

	/* EJEMPLO DELETE
	 * void borrarCafe(String nombreCafe) throws SQLException {
		this.instruccion = "DELETE FROM CAFES WHERE CAFE_NOMBRE='" + nombreCafe + "'";
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();

	}
	 */
	
	///////////////////////////////////////

	/* EJEMPLO MOSTRAR | SOUT EN MAIN
	 * Cafe mostrarCafe(String nombreCafe) throws SQLException {
		Cafe cBuscado = new Cafe();
		this.instruccion = "SELECT * FROM CAFES";
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		while (rs.next()) {
			String nombre = rs.getString("CAFE_NOMBRE");
			if (nombre.equals(nombreCafe)) {
				cBuscado.setCafe_nombre(nombre);
				cBuscado.setProv_id(rs.getInt("PROV_ID"));
				cBuscado.setPrecio(rs.getFloat("PRECIO"));
				cBuscado.setVentas(rs.getInt("VENTAS"));
				cBuscado.setTotal(rs.getInt("TOTAL"));
			}
		}
		this.sentencia.clearBatch();
		rs.close();

		return cBuscado;
	}
	 */
	
	///////////////////////////////////////

	/* EJEMPLO MOSTRAR | SE PASA LISTA Y SOUT EN MAIN
	 * ArrayList<Cafe> mostrarTodos() throws SQLException {
		this.instruccion = "SELECT * FROM CAFES";
		ArrayList<Cafe> lista = new ArrayList<>();
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		while (rs.next()) {
			Cafe c = new Cafe();
			c.setCafe_nombre(rs.getString("CAFE_NOMBRE"));
			c.setProv_id(rs.getInt("PROV_ID"));
			c.setPrecio(rs.getFloat("PRECIO"));
			c.setVentas(rs.getInt("VENTAS"));
			c.setTotal(rs.getInt("TOTAL"));
			lista.add(c);
		}
		this.sentencia.clearBatch();
		rs.close();

		return lista;
	}
	 */
}
