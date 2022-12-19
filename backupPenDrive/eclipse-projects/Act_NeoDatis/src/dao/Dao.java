package dao;

import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import model.Departamento;
import model.Empleado;

public class Dao {

	public boolean existeEmpleado(int emp_no) {
		ODB odb = ODBFactory.open("neodatis.bd");

		IQuery query = new CriteriaQuery(Empleado.class, Where.equal("empNo", emp_no));
		try {
			odb.getObjects(query).next();
			odb.close();
			return true;
		} catch (Exception e) {
			odb.close();
			return false;
		}
	}

	public Empleado recuperarEmpleado(int emp_no) {
		ODB odb = ODBFactory.open("neodatis.bd");

		IQuery query = new CriteriaQuery(Empleado.class, Where.equal("empNo", emp_no));
		try {
			Empleado e = (Empleado) odb.getObjects(query).getFirst();
			odb.close();
			return e;
		} catch (Exception e) {
			odb.close();
			return null;
		}
	}

	public Departamento recuperarDepartamento(int dept_no) {
		ODB odb = ODBFactory.open("neodatis.bd");

		IQuery query = new CriteriaQuery(Departamento.class, Where.equal("deptNo", dept_no));
		try {
			Departamento d = (Departamento) odb.getObjects(query).getFirst();
			odb.close();
			return d;
		} catch (Exception e) {
			odb.close();
			return null;
		}
	}

	public boolean existeDepart(int dept_no) {
		ODB odb = ODBFactory.open("neodatis.bd");

		IQuery query = new CriteriaQuery(Departamento.class, Where.equal("deptNo", dept_no));
		try {
			odb.getObjects(query).next();
			odb.close();
			return true;
		} catch (Exception e) {
			odb.close();
			return false;
		}
	}

	public Departamento existeDepartNombre(String nombre) {
		ODB odb = ODBFactory.open("neodatis.bd");

		IQuery query = new CriteriaQuery(Departamento.class, Where.equal("dnombre", nombre));
		try {
			Departamento d = (Departamento) odb.getObjects(query).getFirst();
			odb.close();
			return d;
		} catch (Exception e) {
			odb.close();
			return null;
		}
	}

	public void altaDepart(Departamento d) {
		ODB odb = ODBFactory.open("neodatis.bd");

		odb.store(d);

		odb.close();
	}

	public void altaEmp(Empleado e) {
		ODB odb = ODBFactory.open("neodatis.bd");

		odb.store(e);

		odb.close();
	}

	public void modificarEmp(String oficio, int emp_no) {
		ODB odb = ODBFactory.open("neodatis.bd");
		IQuery query = new CriteriaQuery(Empleado.class, Where.equal("empNo", emp_no));
		Empleado e = (Empleado) odb.getObjects(query).getFirst();
		e.setOficio(oficio);
		odb.store(e);
		odb.close();
	}

	public void modificarDept(String nombre, int dept_no) {
		ODB odb = ODBFactory.open("neodatis.bd");
		IQuery query = new CriteriaQuery(Departamento.class, Where.equal("deptNo", dept_no));
		Departamento d = (Departamento) odb.getObjects(query).getFirst();
		d.setDnombre(nombre);
		odb.store(d);
		odb.close();
	}

	public void borrarEmp(int empNo) {
		ODB odb = ODBFactory.open("neodatis.bd");
		IQuery query = new CriteriaQuery(Empleado.class, Where.equal("empNo", empNo));
		Empleado e = (Empleado) odb.getObjects(query).getFirst();
		odb.delete(e);
		odb.close();
	}

	public void borrarDept(int deptNo) {
		ODB odb = ODBFactory.open("neodatis.bd");
		IQuery query = new CriteriaQuery(Departamento.class, Where.equal("deptNo", deptNo));
		Departamento e = (Departamento) odb.getObjects(query).getFirst();
		odb.delete(e);
		odb.close();
	}

	public Objects<Empleado> recuperarEmpleados() {
		ODB odb = ODBFactory.open("neodatis.bd");
		IQuery query = new CriteriaQuery(Empleado.class);
		Objects<Empleado> empleados = odb.getObjects(query);
		odb.close();
		return empleados;
	}

	public Objects<Departamento> recuperarDepartamentos() {
		ODB odb = ODBFactory.open("neodatis.bd");
		IQuery query = new CriteriaQuery(Departamento.class);
		Objects<Departamento> departamentos = odb.getObjects(query);
		odb.close();
		return departamentos;
	}

	public ArrayList<String> consulta1() {
		ODB odb = ODBFactory.open("neodatis.bd");
		ArrayList<String> apellidos = new ArrayList();
		IQuery query = new CriteriaQuery(Empleado.class);
		Objects<Empleado> empleados = odb.getObjects(query);

		for (Empleado e : empleados) {
			if (e.getDept().getDeptNo() == 10) {
				apellidos.add(e.getApellido());
			}
		}
		odb.close();
		return apellidos;
	}

	public int consulta2() {
		ODB odb = ODBFactory.open("neodatis.bd");
		int n = 0;
		IQuery query = new CriteriaQuery(Empleado.class);
		Objects<Empleado> empleados = odb.getObjects(query);

		for (Empleado e : empleados) {
			if (e.getDept().getDnombre().equals("Ventas")) {
				n++;
			}
		}
		odb.close();
		return n;
	}
	
	public ArrayList<String> consulta3() {
		ODB odb = ODBFactory.open("neodatis.bd");
		ArrayList<String> apellidos = new ArrayList();
		IQuery query = new CriteriaQuery(Empleado.class);
		Objects<Empleado> empleados = odb.getObjects(query);

		for (Empleado e : empleados) {
			if (e.getDir().getApellido().equals("Fernandez")) {
				apellidos.add(e.getApellido());
			}
		}
		odb.close();
		return apellidos;
	}

}
