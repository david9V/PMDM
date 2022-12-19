package test3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ODB odb = ODBFactory.open("actividad_neodatis.bd");
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

				}
				case 2 -> {

				}

				}
			}
			case 2 -> {
				int opcIns;
				opc();
				opcIns = Integer.parseInt(reader.readLine());
				switch (opcIns) {
				case 1 -> {

				}
				case 2 -> {

				}

				}
			}
			case 3 -> {
				int opcIns;
				opc();
				opcIns = Integer.parseInt(reader.readLine());
				switch (opcIns) {
				case 1 -> {

				}
				case 2 -> {

				}

				}
			}
			case 4 -> {

			}
			case 5 -> {
				int opc2;
				consultas();
				opc2 = Integer.parseInt(reader.readLine());
				switch (opc2) {
				case 1 -> {

				}
				case 2 -> {

				}
				case 3 -> {

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

}
