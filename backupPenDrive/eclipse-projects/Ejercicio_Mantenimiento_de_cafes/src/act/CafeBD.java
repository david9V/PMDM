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

	boolean actualizarCafe(String nombreCafe, int ventas) {
		boolean error = false;
		this.instruccion = "UPDATE CAFES SET VENTAS=" + ventas + " WHERE CAFE_NOMBRE='" + nombreCafe + "'";
		try {
			this.sentencia = conexion.getConexion().createStatement();
			this.sentencia.executeUpdate(this.instruccion);
			this.sentencia.clearBatch();
		} catch (SQLException e) {
			error = true;
		}

		return error;
	}

	boolean añadirCafe(Cafe cafe) {
		boolean error = false;
		this.instruccion = "INSERT INTO CAFES " + "VALUES ('" + cafe.getCafe_nombre() + "', " + cafe.getProv_id() + ", "
				+ cafe.getPrecio() + ", " + cafe.getVentas() + ", " + cafe.getTotal() + ")";
		try {
			this.sentencia = conexion.getConexion().createStatement();
			this.sentencia.executeUpdate(this.instruccion);
			this.sentencia.clearBatch();

		} catch (SQLException e) {
			error = true;
		}
		return error;
	}

	boolean borrarCafe(String nombreCafe) {
		boolean error = false;
		this.instruccion = "DELETE FROM CAFES WHERE CAFE_NOMBRE='" + nombreCafe + "'";
		try {
			this.sentencia = conexion.getConexion().createStatement();
			this.sentencia.executeUpdate(this.instruccion);
			this.sentencia.clearBatch();
		} catch (SQLException e) {
			error = true;
		}

		return error;
	}

	Cafe mostrarCafe(String nombreCafe) {
		Cafe cBuscado = new Cafe();
		this.instruccion = "SELECT * FROM CAFES";
		try {
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
		} catch (SQLException e) {
			System.out.println("Error al intentar mostrar la entrada");
		}
		
		return cBuscado;
	}

	ArrayList<Cafe> mostrarTodos() {
		this.instruccion = "SELECT * FROM CAFES";
		ArrayList<Cafe> lista = new ArrayList<>();
		try {
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
		} catch (SQLException e) {
			System.out.println("Error al intentar listar las todas entradas");
		}
		
		return lista;
	}

	void finalizarSentencia() throws SQLException {
		this.sentencia.close();
	}

}
