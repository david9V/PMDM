package act;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpleadoBD {

	GestionBD conexion;
	String instruccion;

	Statement sentencia;

	EmpleadoBD() {
		this.conexion = new GestionBD();
	}

	void añadirEmp(Empleado emp) throws SQLException {
		this.instruccion = "INSERT INTO EMPLE " + "VALUES (" + emp.getEmp_no() + ",'" + emp.getApellido() + "', '"
				+ emp.getOficio() + "', " + emp.getDir() + ", SYSDATE, " + emp.getSalario() + ", "
				+ emp.getComision() + ", " + emp.getDept_no() + ")";
		this.sentencia = conexion.getConexion().createStatement();
		this.sentencia.executeUpdate(this.instruccion);
		this.sentencia.clearBatch();
	}
	
	void existeDepartamento(int dep) throws SQLException, ExcepcionDepartamento {
		this.instruccion = "SELECT * FROM DEPART WHERE DEPT_NO="+dep;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (!rs.isBeforeFirst()) {
			throw new ExcepcionDepartamento();
		}
	}
	
	void existeEmpleado(Empleado emp) throws SQLException, ExcepcionEmpleado {
		this.instruccion = "SELECT * FROM EMPLE WHERE EMP_NO="+emp.getEmp_no();
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (!rs.isBeforeFirst()) {
			throw new ExcepcionEmpleado();
		}
	}
	
	void existeDirector(int dir) throws SQLException, ExcepcionDirector {
		this.instruccion = "SELECT * FROM EMPLE WHERE EMP_NO="+dir;
		this.sentencia = conexion.getConexion().createStatement();
		ResultSet rs = this.sentencia.executeQuery(this.instruccion);

		if (!rs.isBeforeFirst()) {
			throw new ExcepcionDirector();
		}
	}

	void finalizarSentencia() throws SQLException {
		this.sentencia.close();
	}
}
