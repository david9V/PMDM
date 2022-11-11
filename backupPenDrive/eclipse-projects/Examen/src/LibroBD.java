import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroBD {
	ConexionJDBC conexion;

	String instruccion;

	Statement sentencia;

	LibroBD() throws SQLException {
		this.conexion = new ConexionJDBC();
		this.conexion.establecerConexion();
	}

	Libro encontrarIdLibro(int id) throws SQLException, ExcepcionID {
		Libro l = new Libro();
		this.instruccion = "SELECT * FROM LIBROS WHERE ID_LIBRO="+id;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		
		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionID();
		} else {
			rs.next();
			l.setId_libro(rs.getInt("ID_LIBRO"));
			l.setTitulo(rs.getString("TITULO"));
			l.setNum_ejemplares(rs.getInt("NUM_EJEMPLARES"));
			l.setEditorial(rs.getString("EDITORIAL"));
			l.setNum_paginas(rs.getInt("NUM_PAGINAS"));
			l.setDate(rs.getDate("FECHA_EDICION").toString());
		}
		return l;
	}
	
	void existeLibro(int id) throws SQLException, ExcepcionID {
		this.instruccion = "SELECT * FROM LIBROS WHERE ID_LIBRO="+id;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		
		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionID();
		}
	}
	
	void modificarTitulo(String titulo, int id) throws SQLException {
		this.instruccion = "UPDATE LIBROS SET TITULO='"+titulo+"' WHERE ID_LIBRO="+id;
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();
	}
	
	void modificarEditorial(String editorial, int id) throws SQLException {
		this.instruccion = "UPDATE LIBROS SET EDITORIAL='"+editorial+"' WHERE ID_LIBRO="+id;
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();
	}
	
	ArrayList<Libro> mostrarPorTitulo(String titulo) throws SQLException, ExcepcionPersonalizada{
		ArrayList<Libro> lista = new ArrayList();
		
		this.instruccion = "SELECT * FROM LIBROS WHERE TITULO='"+titulo+"'";
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		
		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionPersonalizada();
		} else {
			while(rs.next()) {
				Libro l = new Libro();
				l.setId_libro(rs.getInt("ID_LIBRO"));
				l.setTitulo(rs.getString("TITULO"));
				l.setNum_ejemplares(rs.getInt("NUM_EJEMPLARES"));
				l.setEditorial(rs.getString("EDITORIAL"));
				l.setNum_paginas(rs.getInt("NUM_PAGINAS"));
				l.setDate(rs.getDate("FECHA_EDICION").toString());
				lista.add(l);
			}
		}
		
		return lista;
	}
	
	ArrayList<Libro> mostrarPorEditorial(String editorial) throws SQLException, ExcepcionPersonalizada{
		ArrayList<Libro> lista = new ArrayList();
		
		this.instruccion = "SELECT * FROM LIBROS WHERE EDITORIAL='"+editorial+"'";
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		
		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionPersonalizada();
		} else {
			while(rs.next()) {
				Libro l = new Libro();
				l.setId_libro(rs.getInt("ID_LIBRO"));
				l.setTitulo(rs.getString("TITULO"));
				l.setNum_ejemplares(rs.getInt("NUM_EJEMPLARES"));
				l.setEditorial(rs.getString("EDITORIAL"));
				l.setNum_paginas(rs.getInt("NUM_PAGINAS"));
				l.setDate(rs.getDate("FECHA_EDICION").toString());
				lista.add(l);
			}
		}
		
		return lista;
	}
	
	String devolverNombreLibro(int id) throws SQLException {
		this.instruccion = "SELECT * FROM LIBROS WHERE ID_LIBRO="+id;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		rs.next();
		
		return rs.getString("TITULO");
	}
	
	String devolverEditorialLibro(int id) throws SQLException {
		this.instruccion = "SELECT * FROM LIBROS WHERE ID_LIBRO="+id;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);
		rs.next();
		
		return rs.getString("EDITORIAL");
	}
	
}
