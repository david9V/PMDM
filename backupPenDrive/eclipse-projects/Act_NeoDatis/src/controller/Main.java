package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import dao.Dao;
import model.Departamento;
import model.Empleado;

public class Main {

	public static Dao dao = new Dao();

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		int opc;
		do {
			opciones();
			opc = Integer.parseInt(reader.readLine());
			switch (opc) {
			case 1 -> {
				int opcIns;
				opc();
				opcIns = Integer.parseInt(reader.readLine());
				switch (opcIns) {
				case 1 -> {
					altaDepart();
				}
				case 2 -> {
					altaEmp();
				}
				}
			}
			case 2 -> {
				int opcIns;
				opc();
				opcIns = Integer.parseInt(reader.readLine());
				switch (opcIns) {
				case 1 -> {
					deleteDepart();
				}
				case 2 -> {
					deleteEmp();
				}

				}
			}
			case 3 -> {
				int opcIns;
				opc();
				opcIns = Integer.parseInt(reader.readLine());
				switch (opcIns) {
				case 1 -> {
					updateDepart();
				}
				case 2 -> {
					updateEmp();
				}

				}
			}
			case 4 -> {
				visualizarTodo();
			}
			case 5 -> {
				int opc2;
				consultas();
				opc2 = Integer.parseInt(reader.readLine());
				switch (opc2) {
				case 1 -> {
					consulta1();
				}
				case 2 -> {
					consulta2();
				}
				case 3 -> {
					consulta3();
				}
				case 4 -> {

				}
				}
			}
			}
		} while (opc < 6);

	}

	public static void opciones() {
		System.out.println("");
		System.out.println("1- Insertar");
		System.out.println("2- Eliminar");
		System.out.println("3- Actualizar");
		System.out.println("4- Visualizar todos los datos");
		System.out.println("5- Consultas predeterminadas");
		System.out.println("");
		System.out.println("6- Salir");
	}

	public static void consultas() {
		System.out.println("");
		System.out.println("1- Apellidos de los empleados del departamento 10");
		System.out.println("2- Número de empleados del departamento de Ventas");
		System.out.println("3- Apellido de los empleados cuyo director es Fernández");
		System.out.println("4- Número de empleados por cada departamento");
	}

	public static void opc() {
		System.out.println("");
		System.out.println("1- Departamento");
		System.out.println("2- Empleado");
	}

	public static void altaDepart() throws NumberFormatException, IOException {
		System.out.println("Introduzca el número de departamento");
		int deptNo = Integer.parseInt(reader.readLine());
		if (dao.existeDepart(deptNo)) {
			System.out.println("Ya existe un departamento con ese código");
		} else {
			System.out.println("Introduzca el nombre del departamento");
			String nombre = reader.readLine();
			System.out.println("Introducza la localización del departamento");
			String loc = reader.readLine();
			Departamento d = new Departamento(deptNo, nombre, loc);
			dao.altaDepart(d);
		}
	}

	public static void altaEmp() throws NumberFormatException, IOException {
		System.out.println("Introduzca el número del empleado");
		int empNo = Integer.parseInt(reader.readLine());
		if (dao.existeEmpleado(empNo)) {
			System.out.println("Ya existe un empleado con ese código");
		} else {
			System.out.println("Introduzca el departamento");
			String depart = reader.readLine();
			Departamento d = dao.existeDepartNombre(depart);
			if (d != null) {
				System.out.println("Introduzca el apellido");
				String apellido = reader.readLine();
				System.out.println("Introduzca el oficio");
				String oficio = reader.readLine();
				System.out.println("Introduzca el salario");
				float salario = Float.parseFloat(reader.readLine());
				System.out.println("Introduzca la comisión");
				float comision = Float.parseFloat(reader.readLine());
				System.out.println("Introduzca el id de su director");
				int dir = Integer.parseInt(reader.readLine());
				Empleado e = dao.recuperarEmpleado(dir);
				if (e != null) {
					Date date = null;
					Empleado emp = new Empleado(empNo, apellido, oficio, e, date, salario, comision, d);
					dao.altaEmp(emp);
				} else {
					System.out.println("No existe ese empleado");
				}

			} else {
				System.out.println("No existe ese departamento");
			}
		}
	}

	public static void updateEmp() throws NumberFormatException, IOException {
		System.out.println("Introduzca el número del empleado");
		int empNo = Integer.parseInt(reader.readLine());
		if (dao.existeEmpleado(empNo)) {
			System.out.println("Introduzca el nuevo oficio");
			String oficio = reader.readLine();
			dao.modificarEmp(oficio, empNo);
		}
		else {
			System.out.println("No existe ese empleado");
		}
	}

	public static void updateDepart() throws NumberFormatException, IOException {
		System.out.println("Introduzca el número de departamento");
		int deptNo = Integer.parseInt(reader.readLine());
		if (dao.existeDepart(deptNo)) {
			System.out.println("Introduzca el nuevo nombre");
			String nombre = reader.readLine();
			dao.modificarDept(nombre, deptNo);
		}
		else {
			System.out.println("No existe ese departamento");
		}
	}
	
	public static void deleteEmp() throws NumberFormatException, IOException {
		System.out.println("Introduzca el id de empleado");
		int empNo = Integer.parseInt(reader.readLine());
		if (dao.existeEmpleado(empNo)) {
			System.out.println("¿Está seguro de que desea borrar el siguiente empleado? (S/N)");
			Empleado e = dao.recuperarEmpleado(empNo);
			System.out.println(e);
			String opc = reader.readLine();
			if (opc.equals("S")) {
				dao.borrarEmp(empNo);
			} else
				System.out.println("Eliminación cancelada");
		}
		else {
			System.out.println("No existe ese empleado");
		}
	}
	
	public static void deleteDepart() throws NumberFormatException, IOException {
		System.out.println("Introduzca el id de departamento");
		int deptNo = Integer.parseInt(reader.readLine());
		if (dao.existeDepart(deptNo)) {
			System.out.println("¿Está seguro de que desea borrar el siguiente departamento? (S/N)");
			Departamento d = dao.recuperarDepartamento(deptNo);
			System.out.println(d);
			String opc = reader.readLine();
			if (opc.equals("S")) {
				dao.borrarDept(deptNo);
			} else
				System.out.println("Eliminación cancelada");
		}
		else {
			System.out.println("No existe ese departamento");
		}
	}
	
	public static void visualizarTodo() {
		System.out.println(dao.recuperarDepartamentos());
		Objects<Empleado> empleados = dao.recuperarEmpleados();
		for(Empleado e : empleados) {
			System.out.println(e.toStringMod());
		}
	}
	
	public static void consulta1() {
		ArrayList<String> apellidos = dao.consulta1();
		if (apellidos.size() == 0) {
			System.out.println("No hay ningún empleado en el departamento 10");
		}
		else {
			System.out.println(apellidos);
		}
	}

	public static void consulta2() {
		System.out.println(dao.consulta2());
	}
	
	public static void consulta3() {
		ArrayList<String> apellidos = dao.consulta3();
		if (apellidos.size() == 0) {
			System.out.println("No hay ningún empleado cuyo director sea Fernandez");
		}
		else {
			System.out.println(apellidos);
		}
	}
	
	public static void consulta4() {
		
	}
}
