package david.david.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bson.Document;

import david.david.dao.MongoDAO;

public class Main {

	static MongoDAO dao = new MongoDAO("eventos", "prueba");
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int opc;
		do {
			opciones();
			opc = Integer.valueOf(br.readLine());
			switch (opc) {
			case 1:{
				insertarDocumento();
				break;
			}
			case 2:{
				eliminarDocumento();
				break;
			}
			case 3:{
				eliminarCollecion();
				break;
			}
			case 4:{
				eliminarTodosLosDocumentos();
				break;
			}
			case 5:{
				consultarDocumento();
				break;
			}
			case 6:{
				opcionesAgregados();
				int opcAgr = Integer.valueOf(br.readLine());
				switch (opcAgr) {
				case 1:{
					agregado1();
					break;
				}
				case 2:{
					agregado2();
					break;
				}
				default:
				}
				break;
			}
			case 7:{
				consultarColleccionAscendente();
				break;
			}
			case 8:{
				consultarColleccionDescendente();
				break;
			}
			case 9:{
				opcionesUpdate();
				int opcUpd = Integer.valueOf(br.readLine());
				switch (opcUpd) {
				case 1:{
					actualizarDocumento();
					break;
				}
				case 2:{
					actualizarDocumentos();
					break;
				}
				case 3:{
					reemplazarDocumento();
					break;
				}
				default:
				}
				break;
			}
			default:
			}
		} while(opc < 10);
		cerrarBD();
	}
	
	static void insertarDocumento() throws IOException {
		System.out.println("Introduzca la id");
		String id = br.readLine();
		if (dao.consultarDocumento(id) == null) {
			System.out.println("Introduzca el nombre");
			String nombre = br.readLine();
			System.out.println("Introduzca la fecha");
			String fecha = br.readLine();
			System.out.println("Introduzca la ciudad");
			String ciudad = br.readLine();
			System.out.println("Introduzca el precio");
			int precio = Integer.valueOf(br.readLine());
			dao.insertarDocumento(new Document()
					.append("_id", id)
					.append("nombre", nombre)
					.append("fecha", fecha)
					.append("ciudad", ciudad)
					.append("precio", precio));
		}
		else
			System.out.println("Ya existe un documento con esa id");
		
	}
	
	static void eliminarDocumento() throws IOException {
		System.out.println("Introduzca la id del documento");
		String id = br.readLine();
		if (dao.consultarDocumento(id) != null) {
			System.out.println("¿Está seguro de que desea borrar el siguiente documento? (S/N)");
			System.out.println(dao.consultarDocumento(id).toJson());
			String o = br.readLine();
			if (o.equals("S")) {
				dao.eliminarDocumento(id);
				System.out.println("Documento borrado");
			}
			else {
				System.out.println("Operación de borrado cancelada");
			}
		}
		else {
			System.out.println("Error de borrado. No se ha encontrado un documento con esa id");
		}
		
	}
	
	static void eliminarCollecion() {
		dao.eliminarCollecion();
	}
	
	static void eliminarTodosLosDocumentos() {
		dao.eliminarTodosDocumentosDeCollecion();
	}
	
	static void consultarDocumento() throws IOException {
		System.out.println("Introduzca la id");
		String id = br.readLine();
		try {
			System.out.println(dao.consultarDocumento(id).toJson());			
		} catch(NullPointerException e) {
			System.out.println("Documento no encontrado");
		}
	}
	
	static void consultarColleccionAscendente() {
		for (Document d : dao.consultarCollecionOrdenadaAscendente()){
			System.out.println(d);
		}	
	}
	
	static void consultarColleccionDescendente() {
		for (Document d : dao.consultarCollecionOrdenadaDescendente()) {
			System.out.println(d);
		}
		
	}
	
	static void agregado1() {
		for (Document d : dao.agregado1()) {
			System.out.println(d);
		}
	}
	
	static void agregado2() {
		for (Document d : dao.agregado2()) {
			System.out.println(d);
		}
	}
	
	static void actualizarDocumento() throws IOException {
		System.out.println("Introduzca la id del documento a modificar");
		String id = br.readLine();
		if (dao.consultarDocumento(id) == null) {
			System.out.println("No se ha encontrado un documento con esa id");
		}
		else {
			System.out.println("Introduzca el nombre");
			String nombre = br.readLine();
			System.out.println("Introduzca la fecha");
			String fecha = br.readLine();
			System.out.println("Introduzca la ciudad");
			String ciudad = br.readLine();
			System.out.println("Introduzca el precio");
			int precio = Integer.valueOf(br.readLine());
			dao.actualizarDocumento(id, nombre, fecha, ciudad, precio);
			
		}
	}
	
	static void actualizarDocumentos() throws IOException {
		System.out.println("Introduzca la id del primer documento a modificar");
		String id1 = br.readLine();
		System.out.println("Introduzca la id del segundo documento a modificar");
		String id2 = br.readLine();
		if (dao.consultarDocumento(id1) == null || dao.consultarDocumento(id1) == null) {
			System.out.println("No se ha encontrado un documento con esa id");
		}
		else {
			System.out.println("Introduzca el nombre");
			String nombre = br.readLine();
			System.out.println("Introduzca la fecha");
			String fecha = br.readLine();
			System.out.println("Introduzca la ciudad");
			String ciudad = br.readLine();
			System.out.println("Introduzca el precio");
			int precio = Integer.valueOf(br.readLine());
			dao.actualizarDocumentos(id1, id2, nombre, fecha, ciudad, precio);
			
		}
	}
	
	static void reemplazarDocumento() throws IOException {
		System.out.println("Introduzca la id del documento a modificar");
		String id = br.readLine();
		
		if (dao.consultarDocumento(id) == null) {
			System.out.println("No se ha encontrado un documento con esa id");
		}
		else {
			System.out.println("Introduzca el nuevo campo que va a tener el documento");
			String nuevo = br.readLine();
			System.out.println("Introduzca el valor del campo");
			String valor = br.readLine();
			dao.reemplazarDocumento(id, nuevo, valor);
		}
	}
	
	static void opciones() {
		System.out.println("");
		System.out.println("1- Insertar documento");
		System.out.println("2- Eliminar documento de la colección");
		System.out.println("3- Eliminar colección");
		System.out.println("4- Eliminar todos los documentos de la colección");
		System.out.println("5- Consultar un documento");
		System.out.println("6- Consultar usando agregaciones");
		System.out.println("7- Consultar colección de forma ordenada ascendente");
		System.out.println("8- Consultar colección de forma ordenada descendente");
		System.out.println("9- Actualizar un documento");
		System.out.println("");
		System.out.println("10- Salir");
		System.out.println("");
	}
	
	static void opcionesAgregados() {
		System.out.println("");
		System.out.println("1- Agregado 1-> Contar todos los documentos cuyo nombre sea boda");
		System.out.println("2- Agregado 2-> Mostrar los documentos sin la id con los atributos nombre, ciudad y precio");
		System.out.println("");
	}
	
	static void opcionesUpdate() {
		System.out.println("");
		System.out.println("1- Actualizar un documento");
		System.out.println("2- Actualizar muchos documentos");
		System.out.println("3- Reemplazar un documento");
		System.out.println("");
	}
	
	static void cerrarBD() {
		dao.cerrarBD();
	}

}
