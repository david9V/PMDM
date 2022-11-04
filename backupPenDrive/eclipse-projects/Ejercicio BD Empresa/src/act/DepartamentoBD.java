package act;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartamentoBD {
	GestionBD conexion;
	String instruccion;

	Statement sentencia;
	
	Statement sN;
	ResultSet navegar;


	DepartamentoBD() throws SQLException {
		this.conexion = new GestionBD();
		this.conexion.establecerConexion();
		this.sN = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		 navegar = this.sN.executeQuery("SELECT DEPART.* FROM DEPART");
	}
	
	int navegarPrimero() throws SQLException {
		ResultSetMetaData rsmd = navegar.getMetaData();
		int nColumnas = rsmd.getColumnCount();

		navegar.first();
	
		for (int i = 1; i <= nColumnas; i++) {
			if (i > 1)
				System.out.print(",  ");
			String valor = navegar.getString(i);
			System.out.print(rsmd.getColumnName(i) + "=" + valor);
		}
		System.out.println("");
		
		return navegar.getInt(1);
	}
	
	int navegarUltimo() throws SQLException {
		ResultSetMetaData rsmd = navegar.getMetaData();
		int nColumnas = rsmd.getColumnCount();

		navegar.last();
	
		for (int i = 1; i <= nColumnas; i++) {
			if (i > 1)
				System.out.print(",  ");
			String valor = navegar.getString(i);
			System.out.print(rsmd.getColumnName(i) + "=" + valor);
		}
		System.out.println("");
		
		return navegar.getInt(1);
	}
	
	int navegarSiguiente() throws SQLException, ExcepcionNavegar {
		if (navegar.isLast()) {
			throw new ExcepcionNavegar();
		}
		
		ResultSetMetaData rsmd = navegar.getMetaData();
		int nColumnas = rsmd.getColumnCount();

		navegar.next();
	
		for (int i = 1; i <= nColumnas; i++) {
			if (i > 1)
				System.out.print(",  ");
			String valor = navegar.getString(i);
			System.out.print(rsmd.getColumnName(i) + "=" + valor);
		}
		System.out.println("");
		
		return navegar.getInt(1);
	}
	
	int navegarAnterior() throws SQLException, ExcepcionNavegar {
		if (navegar.isFirst()) {
			throw new ExcepcionNavegar();
		}
		
		ResultSetMetaData rsmd = navegar.getMetaData();
		int nColumnas = rsmd.getColumnCount();

		navegar.previous();
	
		for (int i = 1; i <= nColumnas; i++) {
			if (i > 1)
				System.out.print(",  ");
			String valor = navegar.getString(i);
			System.out.print(rsmd.getColumnName(i) + "=" + valor);
		}
		System.out.println("");
		
		return navegar.getInt(1);
	}
	
	int navegarConcretoPorNum(int dept_no) throws SQLException {
		
		ResultSetMetaData rsmd = navegar.getMetaData();
		int nColumnas = rsmd.getColumnCount();
		
		navegar.beforeFirst();;
		boolean flag = false;
		
		while(navegar.next() && !flag) {
			if (navegar.getInt(1) == dept_no) {
				for (int i = 1; i <= nColumnas; i++) {
					if (i > 1)
						System.out.print(",  ");
					String valor = navegar.getString(i);
					System.out.print(rsmd.getColumnName(i) + "=" + valor);
				}
				System.out.println("");
				
				flag = true;
			}
		}
		navegar.previous();
		
		return navegar.getInt(1);

	}
	
	void bajaDepartamento(int dept_no) throws SQLException {
		this.sentencia = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = this.sentencia.executeQuery("SELECT DEPART.* FROM DEPART");
		
		while(rs.next()) {
			if (rs.getInt(1) == dept_no) {
				rs.deleteRow();
			}
		}
		rs.close();
	}
	
	void añadirDepartamento(Departamento d) throws SQLException {
		this.sentencia = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = this.sentencia.executeQuery("SELECT DEPART.* FROM DEPART");
		rs.moveToInsertRow();
		rs.updateInt(1, d.getDept_no());
		rs.updateString(2, d.getdNombre());
		rs.updateString(3, d.getLoc());
		rs.insertRow();
		rs.close();
	}
	
	void existeDepartamento(int dep) throws SQLException, ExcepcionDepartamento {
		this.instruccion = "SELECT * FROM DEPART WHERE DEPT_NO=" + dep;
		this.sentencia = this.conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionDepartamento();
		}
	}
	
	void noExisteDepartamento(int dep) throws SQLException, ExcepcionDepartamento {
		this.instruccion = "SELECT * FROM DEPART WHERE DEPT_NO=" + dep;
		this.sentencia = this.conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionDepartamento();
		}
	}
	
	void finalizarSentencia() throws SQLException {
		this.sentencia.close();
	}
	
}
