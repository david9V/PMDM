package act;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class EmpleadoBD {

	GestionBD conexion;
	String instruccion;

	Statement sentencia;
	
	EmpleadoBD() throws SQLException {
		 this.conexion = new GestionBD();
		 this.conexion.establecerConexion();
	}

	void añadirEmp(Empleado emp) throws SQLException {
		/*
		this.instruccion = "INSERT INTO EMPLE " + "VALUES (" + emp.getEmp_no() + ",'" + emp.getApellido() + "', '"
				+ emp.getOficio() + "', " + emp.getDir() + ", SYSDATE, " + emp.getSalario() + ", "
				+ emp.getComision() + ", " + emp.getDept_no() + ")";
		*/
		
		this.sentencia = conexion.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = this.sentencia.executeQuery("SELECT EMPLE.* FROM EMPLE");
		rs.moveToInsertRow();
		rs.updateInt(1, emp.getEmp_no());
		rs.updateString(2, emp.getApellido());
		rs.updateString(3, emp.getOficio());
		rs.updateInt(4, emp.getDir());
		rs.updateDate(5, new java.sql.Date(System.currentTimeMillis()));
		rs.updateInt(6, emp.getSalario());
		rs.updateInt(7, emp.getComision());
		rs.updateInt(8, emp.getDept_no());
		rs.insertRow();
		//this.sentencia.executeUpdate(this.instruccion);
		//this.sentencia.clearBatch();
	}
	
	void existeDepartamento(int dep) throws SQLException, ExcepcionDepartamento {
		this.instruccion = "SELECT * FROM DEPART WHERE DEPT_NO="+dep;
		this.sentencia = this.conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionDepartamento();
		}
	}
	
	void existeEmpleado(Empleado emp) throws SQLException, ExcepcionEmpleado {
		this.instruccion = "SELECT * FROM EMPLE WHERE EMP_NO="+emp.getEmp_no();
		this.sentencia = this.conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionEmpleado();
		}
	}
	
	void existeDirector(int dir) throws SQLException, ExcepcionDirector {
		this.instruccion = "SELECT * FROM EMPLE WHERE EMP_NO="+dir;
		this.sentencia = this.conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (!rs.isBeforeFirst()) {
			rs.close();
			throw new ExcepcionDirector();
		}
	}

	void finalizarSentencia() throws SQLException {
		this.sentencia.close();
	}
}
