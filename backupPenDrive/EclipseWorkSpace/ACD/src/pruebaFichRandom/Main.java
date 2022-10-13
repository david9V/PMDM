package pruebaFichRandom;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

	private static final int TAM_REGISTRO = 36;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("archivoAccesoAleatorio.dat", "rw");
		} catch (FileNotFoundException e) {
			System.out.println("Error con el fichero");
			e.printStackTrace();
			System.exit(-1);
		}
		boolean fin = false;
		while (!fin) {
			System.out.println("Elija una operacion:");
			System.out.println("1- Alta empleado");
			System.out.println("2- Baja empleado");
			System.out.println("3- Consulta empleado");
			System.out.println("4- Modifica salario");
			System.out.println("*- Salir");
			String op = sc.nextLine();

			switch (op) {
			case "1":
				altaEmpleado(sc, file);
				break;
			case "2":
				bajaEmpleado(sc, file);
				break;
			case "3":
				consultaEmpleado(sc, file);
				break;
			case "4":
				modificaSalario(sc, file);
				break;
			default:
				fin = true;
			}
		}
	}

	private static void modificaSalario(Scanner sc, RandomAccessFile file) {
		System.out.println("Introduzca el id del empleado");
		String idS = sc.nextLine();
		int id = -1;
		try {
			id = Integer.parseInt(idS);
		} catch (Exception e) {
			System.out.println("id empleado no valida");
			return;
		}

		int pos = TAM_REGISTRO * (id - 1);
		try {
			file.seek(pos);
			try {
				int idA = file.readInt();
				file.seek(pos+4+20+4);
				if (idA == id) {
					System.out.println("Introduzca nuevo salario");
					String salS = sc.nextLine();
					double salario = -1;
					try {
						salario = Double.parseDouble(salS);
					} catch (Exception e) {
						System.out.println("salario no valido");
						return;
					}
					file.writeDouble(salario);
				} else {
					System.out.println("Empleado no registrado");
					return;
				}

			} catch (EOFException e) {
				System.out.println("Empleado no registrado");
				return;
			}
		} catch (IOException e) {
			System.out.println("Error en la baja");
			e.printStackTrace();
			return;
		}

	}

	private static void consultaEmpleado(Scanner sc, RandomAccessFile file) {
		System.out.println("Introduzca el id del empleado");
		String idS = sc.nextLine();
		int id = -1;
		try {
			id = Integer.parseInt(idS);
		} catch (Exception e) {
			System.out.println("id empleado no valida");
			return;
		}

		int pos = TAM_REGISTRO * (id - 1);
		try {
			file.seek(pos);
			try {
				int idA = file.readInt();
				if (idA == id) {
					System.out.println("Id: "+id);
					String apellido = "";
					for(int i = 0; i<10; i++){
						apellido+=file.readChar();
					}
					System.out.println("Apellidos: "+apellido);
					System.out.println("Dept: "+file.readInt());
					System.out.println("Salario: "+file.readDouble());
				} else {
					System.out.println("Empleado no registrado");
					return;
				}

			} catch (EOFException e) {
				System.out.println("Empleado no registrado");
				return;
			}
		} catch (IOException e) {
			System.out.println("Error en la baja");
			e.printStackTrace();
			return;
		}

	}

	private static void bajaEmpleado(Scanner sc, RandomAccessFile file) {
		System.out.println("Introduzca el id del empleado");
		String idS = sc.nextLine();
		int id = -1;
		try {
			id = Integer.parseInt(idS);
		} catch (Exception e) {
			System.out.println("id empleado no valida");
			return;
		}

		int pos = TAM_REGISTRO * (id - 1);
		try {
			file.seek(pos);
			try {
				int idA = file.readInt();
				file.seek(pos);
				if (idA == id) {
					file.seek(pos);
					file.writeInt(Integer.MIN_VALUE);
					System.out.println("Baja completa");
				} else {
					System.out.println("Empleado no registrado");
					return;
				}

			} catch (EOFException e) {
				System.out.println("Empleado no registrado");
				return;
			}
		} catch (IOException e) {
			System.out.println("Error en la baja");
			e.printStackTrace();
			return;
		}

	}

	private static void altaEmpleado(Scanner sc, RandomAccessFile file) {

		System.out.println("Introduzca el id del empleado");
		String idS = sc.nextLine();
		int id = -1;
		try {
			id = Integer.parseInt(idS);
		} catch (Exception e) {
			System.out.println("id empleado no valida");
			return;
		}
		int pos = TAM_REGISTRO * (id - 1);
		try {
			file.seek(pos);
			try {
				int idA = file.readInt();
				if (idA == id) {
					System.out.println("id ya registrada");
					return;
				}
				file.seek(pos);
			} catch (EOFException e) {
				// do nothing
			}

			System.out.println("Introduzca apellido (10 letras maximo)");
			String apellido = sc.nextLine();
			if (apellido.length() > 10) {
				apellido.substring(0, 10);
			} else {
				StringBuffer sbnom = new StringBuffer(apellido);
				sbnom.setLength(10);
				apellido = sbnom.toString();
			}

			System.out.println("Introduzca el codigo de departamento");
			String deptS = sc.nextLine();
			int dept = -1;
			try {
				dept = Integer.parseInt(deptS);
			} catch (Exception e) {
				System.out.println("id departamento no valida");
				return;
			}

			System.out.println("Introduzca el salario");
			String salS = sc.nextLine();
			double salario = -1;
			try {
				salario = Double.parseDouble(salS);
			} catch (Exception e) {
				System.out.println("salario no valido");
				return;
			}

			file.writeInt(id);
			file.writeChars(apellido);
			file.writeInt(dept);
			file.writeDouble(salario);

			System.out.println("Alta completa");
			System.out.println();
		} catch (IOException e) {
			System.out.println("Error en el alta");
			e.printStackTrace();
			return;
		}
	}
}

