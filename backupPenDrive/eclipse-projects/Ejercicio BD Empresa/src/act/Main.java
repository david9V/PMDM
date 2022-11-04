package act;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) throws NumberFormatException, IOException, SQLException {
		menu();
	}

	public static void menu() throws NumberFormatException, IOException, SQLException {
		EmpleadoBD emp = new EmpleadoBD();

		DepartamentoBD depart = new DepartamentoBD();

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
					emp.noExisteEmpleado(emp_no);
					System.out.println("Introduzca el apellido");
					String apellido = reader.readLine();
					System.out.println("Introduzca el oficio");
					String oficio = reader.readLine();
					System.out.println("Introduzca el director");
					int director = Integer.parseInt(reader.readLine());
					emp.existeDirector(director);
					System.out.println("Introduzca el salario");
					int salario = Integer.parseInt(reader.readLine());
					if (salario <= 0)
						throw new ExcepcionSalario();
					System.out.println("Introduzca la comisión");
					int comision = Integer.parseInt(reader.readLine());
					System.out.println("Introduzca el número de departamento");
					int dep_no = Integer.parseInt(reader.readLine());
					emp.existeDepartamento(dep_no);
					Empleado e = new Empleado(emp_no, apellido, oficio, director, salario, comision, dep_no);
					emp.añadirEmp(e);
					System.out.println("Empleado añadido");
				} catch (ExcepcionEmpleado e) {
					System.out.println("Ya existe el empleado");
				} catch (SQLException ex) {
					mostrarExcepciones(ex);
				} catch (ExcepcionSalario e) {
					System.out.println("El salario debe ser mayor de 0");
				} catch (ExcepcionDepartamento e) {
					System.out.println("Imposible insertar el empleado, no existe el departamento introducido");
				} catch (ExcepcionDirector e) {
					System.out.println("No existe ese director");
				}
			}
			case 2 -> {
				try {
					System.out.println("Introduzca el departamento donde quiere realizar la subida");
					int dep_no = Integer.parseInt(reader.readLine());
					emp.existeDepartamento(dep_no);
					System.out.println("Introduzca la subida de salario");
					int subida_sal = Integer.parseInt(reader.readLine());
					emp.subidaSalario(dep_no, subida_sal);
					System.out.println("Subida realizada");
				} catch (ExcepcionDepartamento e) {
					System.out.println("No se ha realizado la actualización");
					System.out.println("No existe el departamento");
				} catch (SQLException ex) {
					mostrarExcepciones(ex);
				}
			}
			case 3 -> {
				try {
					System.out.println("Introduzca el número de empleado");
					int emp_no = Integer.parseInt(reader.readLine());
					emp.existeEmpleado(emp_no);
					emp.consultaDatosEmp(emp_no);
				} catch (ExcepcionEmpleado e) {
					System.out.println("No existe el empleado");
				} catch (SQLException e) {
					mostrarExcepciones(e);
				}
			}
			case 4 -> {
				try {
					System.out.println("Introduzca el número de departamento");
					int dept_no = Integer.parseInt(reader.readLine());
					depart.existeDepartamento(dept_no);
					System.out.println("Introduzca el nombre");
					String dept_nombre = reader.readLine();
					System.out.println("Introduzca la localización");
					String dept_loc = reader.readLine();
					Departamento d = new Departamento(dept_no, dept_nombre, dept_loc);
					depart.añadirDepartamento(d);
					System.out.println("Departamento insertado");
				} catch (ExcepcionDepartamento e) {
					System.out.println("Ya existe ese departamento");
				} catch (SQLException e) {
					mostrarExcepciones(e);
				}
			}
			case 5 -> {
				try {
					System.out.println("Introduzca el número de departamento");
					int dept_no = Integer.parseInt(reader.readLine());
					depart.noExisteDepartamento(dept_no);
					emp.depTieneEmpleado(dept_no);
					depart.bajaDepartamento(dept_no);
					System.out.println("Departamento borrado");
				} catch (ExcepcionDepartamento e) {
					System.out.println("El departamento no existe");
				} catch (SQLException e) {
					mostrarExcepciones(e);
				} catch (ExcepcionEmpleado e) {
					System.out.println("Imposible eliminar departamento, tiene empleados");
				}
			}
			case 6 -> {
				int opcNavegar;
				do {
					opcionesNavegar();
					opcNavegar = Integer.parseInt(reader.readLine());

					switch (opcNavegar) {
					case 1 -> {
						try {							
							emp.mostrarEmpPorDep(depart.navegarPrimero());
						} catch(SQLException e) {
							mostrarExcepciones(e);
						} catch(ExcepcionEmpleado e) {
							System.out.println("---No existen empleados");
						}
					}
					case 2 -> {
						try {
							emp.mostrarEmpPorDep(depart.navegarUltimo());
						} catch(SQLException e) {
							mostrarExcepciones(e);
						} catch(ExcepcionEmpleado e) {
							System.out.println("---No existen empleados");
						}
					}
					case 3 -> {
						try {
							emp.mostrarEmpPorDep(depart.navegarSiguiente());
						} catch(SQLException e) {
							mostrarExcepciones(e);
						} catch(ExcepcionEmpleado e) {
							System.out.println("---No existen empleados");
						} catch(ExcepcionNavegar e) {
							System.out.println("No se puede avanzar, usted se encuentra al final de la tabla");
						}
					}
					case 4 -> {
						try {
							emp.mostrarEmpPorDep(depart.navegarAnterior());
						} catch(SQLException e) {
							mostrarExcepciones(e);
						} catch(ExcepcionEmpleado e) {
							System.out.println("---No existen empleados");
						} catch(ExcepcionNavegar e) {
							System.out.println("No se puede retroceder, usted se encuentra al principio de la tabla");
						}					}
					case 5 -> {
						try {
							System.out.println("Introduzca el número de departamento");
							int dept_no = Integer.parseInt(reader.readLine());
							depart.noExisteDepartamento(dept_no);
							emp.mostrarEmpPorDep(depart.navegarConcretoPorNum(dept_no));
						} catch(ExcepcionDepartamento e) {
							System.out.println("No existe el departamento");
						} catch (SQLException e) {
							mostrarExcepciones(e);
						} catch(ExcepcionEmpleado e) {
							System.out.println("---No existen empleados");
						} 
						
					}
					}
				} while (opcNavegar < 6);
			}
			}
			System.out.println();
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

	public static void opcionesNavegar() {
		System.out.println("1- Primero");
		System.out.println("2- Último");
		System.out.println("3- Siguiente");
		System.out.println("4- Anterior");
		System.out.println("5- Ir a uno concreto a partir de sú nº de departamento");
		System.out.println("6- Parar de navegar la tabla");
		System.out.println();
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
