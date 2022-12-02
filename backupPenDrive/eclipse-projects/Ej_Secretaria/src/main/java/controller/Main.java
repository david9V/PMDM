package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import dao.MatriculaDAO;
import model.Alumno;
import model.Asignatura;
import model.Matriculacion;
import model.MatriculacionPK;

public class Main {
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO();
		MatriculaDAO matriculaDAO = new MatriculaDAO();
		int opc = 0;
		do {
			opciones();
			try {
				opc = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (opc) {
			case 1 -> {
				altaAlumno(alumnoDAO);
			}
			case 2 -> {
				altaAsig(asignaturaDAO);
			}
			case 3 -> {
				bajasAlumno(alumnoDAO);
			}
			case 4 -> {
				consultaAlumnoId(alumnoDAO);
			}
			case 5 -> {
				consultaAsigTitulo(asignaturaDAO);
			}
			case 6 -> {
				realizarMatr(alumnoDAO, asignaturaDAO, matriculaDAO);
			}
			case 7 -> {
				consultaAlumnosAsig(asignaturaDAO, alumnoDAO);
			}

			}
			System.out.println();
		} while (opc < 8);
	}

	public static void altaAlumno(AlumnoDAO alumnoDAO) throws IOException {
		System.out.println("Introduzca el DNI del nuevo alumno");
		String dni = reader.readLine();
		if (alumnoDAO.existeAlumno(dni)) {
			System.out.println();
			System.out.println("Error al dar de alta");
			System.out.println("Ya existe un alumno con ese DNI");
			System.out.println();
		} 
		else {
			System.out.println("Introduzca el nombre del nuevo alumno");
			String nombre = reader.readLine();
			System.out.println("Introduzca los apellidos del nuevo alumno");
			String apellidos = reader.readLine();
			System.out.println("Introduzca el domiclio del nuevo alumno");
			String domicilio = reader.readLine();
			System.out.println("Introduzca el teléfono del nuevo alumno");
			String telefono = reader.readLine();
			System.out.println("Introduzca el tipo de Acceso del nuevo alumno");
			BigDecimal tipoAcceso = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));
			System.out.println();
			System.out.println(alumnoDAO.altaAlumno(new Alumno(dni, nombre, apellidos, domicilio, telefono, tipoAcceso))); 
		}
	}

	public static void altaAsig(AsignaturaDAO asignaturaDAO) throws NumberFormatException, IOException {
		System.out.println("Introduzca el código de la nueva asignatura");
		String codigo = reader.readLine();
		if (asignaturaDAO.existeAsig(codigo)) {
			System.out.println("Error al dar de alta");
			System.out.println("Ya existe una asignatura con ese código");
			System.out.println();
		} 
		else {
			System.out.println("Introduzca el título de la nueva asignatura");
			String titulo = reader.readLine();
			System.out.println("Introduzca los creditos de la nueva asignatura");
			BigDecimal creditos = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));
			System.out.println();
			System.out.println(asignaturaDAO.altaAsig(new Asignatura(codigo, titulo, creditos)));
		}
	}

	public static void bajasAlumno(AlumnoDAO alumnoDAO) throws IOException {
		System.out.println("Introduzca el DNI del alumno a borrar");
		String dni = reader.readLine();
		if (!alumnoDAO.existeAlumno(dni)) {
			System.out.println();
			System.out.println("Error");
			System.out.println("No existe un alumno con ese DNI");
		}
		else {
			System.out.println("¿Está seguro de que desea borrar el siguiente alumno? (S/N)");
			System.out.println(alumnoDAO.consultaAlumno(dni));
			String opcion = reader.readLine();
			if (opcion.compareTo("S") == 0)
				System.out.println(alumnoDAO.bajaAlumno(dni));
			else
				System.out.println("Baja cancelada");
			
		}
	}

	public static void consultaAlumnoId(AlumnoDAO alumnoDAO) throws IOException {
		System.out.println("Introduzca el DNI del alumno");
		String dni = reader.readLine();
		Alumno a = alumnoDAO.consultaAlumno(dni); 
		if (a != null) {
			System.out.println();
			//System.out.println(a.getMatriculacions());
			System.out.println(a);			
		}
		else {
			System.out.println();
			System.out.println("No existe ese alumno");			
		}
	}

	public static void consultaAsigTitulo(AsignaturaDAO asignaturaDAO) throws IOException {
		System.out.println("Introduzca el título de la asignatura");
		String titulo = reader.readLine();
		Asignatura a = asignaturaDAO.consultaAsig(titulo);
		if (a == null) {
			System.out.println();
			System.out.println("No existe ninguna asignatura con ese título");
		}
		else {
			System.out.println();
			System.out.println(a);
		}
		
	}

	public static void realizarMatr(AlumnoDAO alumnoDAO, AsignaturaDAO asignaturaDAO, MatriculaDAO matriculaDAO) throws IOException {
		System.out.println("Introduzca el DNI del alumno:");
		String dni = reader.readLine();
		if (alumnoDAO.existeAlumno(dni)) {
			System.out.println("Introduzca el título de la asignatura");
			String titulo = reader.readLine();
			Asignatura a = asignaturaDAO.consultaAsig(titulo);
			if (a != null) {
				System.out.println("Introduzca la nota");
				BigDecimal nota = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));
				Matriculacion m = new Matriculacion();
				m.setNota(nota);
				m.setAlumno(alumnoDAO.consultaAlumno(dni));
				m.setAsignatura(asignaturaDAO.consultaAsig(titulo));
				MatriculacionPK pk = new MatriculacionPK();
				pk.setDni(dni);
				pk.setCodAsignatura(asignaturaDAO.consultaAsig(titulo).getCodigo());
				m.setId(pk);
				if (matriculaDAO.existeMatr(m)) {
					System.out.println("Error, La matricula ya existe");
				}
				else {
					System.out.println(matriculaDAO.altaMatr(m));
				}
			}
			else {
				System.out.println("Error, la asignatura no existe");
			}
		}
		else {
			System.out.println("Error, El alumno no existe");
		}
	}

	public static void consultaAlumnosAsig(AsignaturaDAO asignaturaDAO, AlumnoDAO alumnoDAO) throws IOException {
		System.out.println("Introduzca el título de la asignatura");
		String titulo = reader.readLine();
		Asignatura a = asignaturaDAO.consultaAsig(titulo); 
		if (a != null) {
			ArrayList<Alumno> lista = alumnoDAO.alumnosPorAsig(a.getCodigo());
			if (lista.size() == 0)
				System.out.println("No hay ningún alumno asociado a esa asignatura");
			else {
				System.out.println(lista);
			}
		}
		else {
			System.out.println("No existe esa asignatura");
		}
	}

	public static void opciones() {
		System.out.println("1- Alta de alumno");
		System.out.println("2- Alta de asignatura");
		System.out.println("3- Bajas de alumno");
		System.out.println("4- Consulta de alumno por identificador");
		System.out.println("5- Consulta de asignatura por título");
		System.out.println("6- Realizar matriculación");
		System.out.println("7- Consulta de alumnos por asignatura");
		System.out.println();
		System.out.println("8- Salir");
	}

}
