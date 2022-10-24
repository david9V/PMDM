package act;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CafeBD {
	ConexionBD conexion;
	String instruccion;

	Statement sentencia;

	CafeBD() throws SQLException {
		this.conexion = new ConexionBD();
	}

	void existe(String nombreCafe) throws SQLException, Excepcion {
		this.instruccion = "SELECT CAFE_NOMBRE FROM CAFES WHERE CAFE_NOMBRE='" + nombreCafe + "'";
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (!rs.isBeforeFirst()) {
			throw new Excepcion();
		}
	}

	void actualizarCafe(String nombreCafe, int ventas) throws SQLException {
		this.sentencia.clearBatch();
		this.instruccion = "UPDATE CAFES SET VENTAS=" + ventas + " WHERE CAFE_NOMBRE='" + nombreCafe + "'";
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();
	}

	void añadirCafe(Cafe cafe) throws SQLException {
		this.instruccion = "INSERT INTO CAFES " + "VALUES ('" + cafe.getCafe_nombre() + "', " + cafe.getProv_id() + ", "
				+ cafe.getPrecio() + ", " + cafe.getVentas() + ", " + cafe.getTotal() + ")";
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();

	}

	void borrarCafe(String nombreCafe) throws SQLException {
		this.instruccion = "DELETE FROM CAFES WHERE CAFE_NOMBRE='" + nombreCafe + "'";
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();

	}

	Cafe mostrarCafe(String nombreCafe) throws SQLException {
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

	ArrayList<Cafe> mostrarTodos() throws SQLException {
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

	void finalizarSentencia() throws SQLException {
		this.sentencia.close();
	}

}
