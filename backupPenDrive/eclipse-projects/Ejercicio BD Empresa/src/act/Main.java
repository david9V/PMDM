package act;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) {

	}

	public static void menu() throws NumberFormatException, IOException {
		EmpleadoBD emp = new EmpleadoBD();
		DepartamentoBD depart = new DepartamentoBD();
		
		emp.conexion.establecerConexion();
		depart.conexion.establecerConexion();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int opc;
		do {
			opciones();
			opc = Integer.parseInt(reader.readLine());
			switch (opc) {
			case 1 -> {
				try {
					System.out.println("Introduzca el número de empleado");
					int emp_no = Integer.parseInt(reader.readLine());
					System.out.println("Introduzca el apellido");
					String apellido = reader.readLine();
					System.out.println("Introduzca el oficio");
					String oficio = reader.readLine();
					System.out.println("Introduzca el director");
					int director = Integer.parseInt(reader.readLine());
					emp.existeDirector(director);
					System.out.println("Introduzca el salario");
					int salario = Integer.parseInt(reader.readLine());
					if (salario <= 0) throw new ExcepcionSalario();
					System.out.println("Introduzca la comisión");
					int comision = Integer.parseInt(reader.readLine());
					System.out.println("Introduzca el número de departamento");
					int dep_no = Integer.parseInt(reader.readLine());
					emp.existeDepartamento(dep_no);
					Empleado e = new Empleado(emp_no, apellido, oficio, director, salario, comision, dep_no);
					emp.existeEmpleado(e);
					emp.añadirEmp(e);
				} catch (ExcepcionEmpleado e){
					System.out.println("Ya existe el empleado");
				} catch (SQLException ex) {
					mostrarExcepciones(ex);
				} catch(ExcepcionSalario e) {
					System.out.println("El salario debe ser mayor de 0");
				} catch (ExcepcionDepartamento e) {
					System.out.println("Imposible insertar el empleado, no existe el departamento introducido");
				} catch (ExcepcionDirector e) {
					System.out.println("No existe ese director");
				}
			}
			case 2 -> {

			}
			case 3 -> {

			}
			case 4 -> {

			}
			case 5 -> {

			}
			case 6 -> {

			}
			}
		} while (opc < 7);
		emp.conexion.cerrarConexion();
		depart.conexion.cerrarConexion();
	}

	public static void opciones() {
		System.out.println("1- Altas de nuevos empleados");
		System.out.println("2- Actualización del salario a los empleados de un departamento");
		System.out.println("3- Consulta de los datos de un empleado concreto");
		System.out.println("4- Altas de nuevos departamentos");
		System.out.println("5- Bajas de departamentos");
		System.out.println("6- Navegación por tabla Departamentos");
		System.out.println();
		System.out.println("7- Salir");
	}

	public static void mostrarExcepciones(SQLException ex) {
		System.out.println("\n--- SQLException capturada ---\n");
		while (ex != null) {
			System.out.println("Mensaje: " + ex.getMessage());
			System.out.println("ErrorCode: " + ex.getErrorCode());
			ex = ex.getNextException();
			System.out.println("");
		}
	}

}
