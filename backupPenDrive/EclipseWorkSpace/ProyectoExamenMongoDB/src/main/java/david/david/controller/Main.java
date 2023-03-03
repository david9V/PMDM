package david.david.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bson.Document;

import com.mongodb.client.FindIterable;

import david.david.dao.MongoDAO;

public class Main {

	static MongoDAO daoActividades = new MongoDAO("gimnasio", "actividades");
	static MongoDAO daoSocios = new MongoDAO("gimnasio", "socios");
	static MongoDAO daoUso_gimnasio = new MongoDAO("gimnasio", "uso_gimnasio");
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int opc;
		do {
			opciones();
			opc = Integer.valueOf(br.readLine());
			switch (opc) {
			case 1:{
				consultarDocumentos();
				break;
			}
			case 2:{
				insertarDocumento();
				break;
			}
			case 3:{
				eliminarDocumento();
				break;
			}
			default:
			}
		} while(opc < 4);
		cerrarBD();
	}
	
	static void insertarDocumento() throws IOException {
		System.out.println("Introduzca el nombre de la colección (actividades, socios, uso_gimnasio)");
		String id = br.readLine();
		switch (id) {
		case "actividades":{
			daoInsercionAct();
			break;
		}
		case "socios":{
			daoInsercionSoc();
			break;
		}
		case "uso_gimnasio":{
			daoInsercionUso_gym();
			break;
		}
		default:{
			System.out.println("Colección no válida");
		}
		}
		
	}
	
	public static void daoInsercionAct() throws IOException {
		System.out.println("Introduzca la id");
		String id = br.readLine();
		if (daoActividades.consultarDocumento(id) == null) {
			System.out.println("Introduzca el nombre");
			String nombre = br.readLine();
			System.out.println("Introduzca el tipo");
			String tipo = br.readLine();
			daoActividades.insertarDocumento(new Document()
					.append("_id", id)
					.append("NOMBRE", nombre)
					.append("_tipo", tipo));
			System.out.println("Documento añadido con éxito");
		}
		else
			System.out.println("Ya existe un documento con esa id");
	}
	
	public static void daoInsercionSoc() throws IOException {
		System.out.println("Introduzca la id");
		String id = br.readLine();
		if (daoSocios.consultarDocumento(id) == null) {
			System.out.println("Introduzca el nombre");
			String nombre = br.readLine();
			System.out.println("Introduzca la fecha de alta");
			String fech_alta = br.readLine();
			System.out.println("Introduzca la dirección");
			String direccion = br.readLine();
			System.out.println("Introduzca la cuota fija");
			String cuota = br.readLine();
			daoSocios.insertarDocumento(new Document()
					.append("_id", id)
					.append("NOMBRE", nombre)
					.append("FECHA_ALT", fech_alta)
					.append("DIRECCION", direccion)
					.append("CUOTA_FIJA", cuota));
			System.out.println("Documento añadido con éxito");
		}
		else
			System.out.println("Ya existe un documento con esa id");
	}
	
	public static void daoInsercionUso_gym() throws IOException {
		System.out.println("Introduzca la id del socio");
		String id_soc = br.readLine();
		if (daoSocios.consultarDocumento(id_soc) != null) {
			System.out.println("Introduzca la id de la actividad");
			String id_act = br.readLine();
			if (daoActividades.consultarDocumento(id_act) != null) {
				System.out.println("Introduzca la fecha");
				String fech = br.readLine();
				System.out.println("Introduzca la hora de inicio");
				String h_inicio = br.readLine();
				System.out.println("Introduzca la hora final");
				String h_fin = br.readLine();
				
				daoUso_gimnasio.insertarDocumento(new Document()
						.append("CODSOCIO", id_soc)
						.append("CODACTIV", id_act)
						.append("FECHA", fech)
						.append("HORAINICIO", h_inicio)
						.append("HORAFINAL", h_fin));
				System.out.println("Documento añadido con éxito");
			}
			else
				System.out.println("Error, no existe una actividad con esa id");
		}
		else
			System.out.println("Error, no existe un socio con esa id");
	}
	
	
	static void eliminarDocumento() throws IOException {
		System.out.println("Introduzca el nombre de la colección (actividades, socios, uso_gimnasio)");
		String id = br.readLine();
		switch (id) {
		case "actividades":{
			daoEliminar(daoActividades);
			break;
		}
		case "socios":{
			daoEliminar(daoSocios);
			break;
		}
		case "uso_gimnasio":{
			daoEliminar(daoUso_gimnasio);
			break;
		}
		default:{
			System.out.println("Colección no válida");
		}
		}
	}
	
	static void daoEliminar(MongoDAO mongoDAO) throws IOException {
		System.out.println("Introduzca la id del documento");
		String id = br.readLine();
		if (mongoDAO.consultarDocumento(id) != null) {
			System.out.println("¿Está seguro de que desea borrar el siguiente documento? (S/N)");
			System.out.println(mongoDAO.consultarDocumento(id).toJson());
			String o = br.readLine();
			if (o.equals("S")) {
				mongoDAO.eliminarDocumento(id);
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
	
	
	static void consultarDocumentos() throws IOException {
		System.out.println("Introduzca el nombre de la colección (actividades, socios, uso_gimnasio)");
		String id = br.readLine();
		switch (id) {
		case "actividades":{
			daoConsulta(daoActividades);
			break;
		}
		case "socios":{
			daoConsulta(daoSocios);
			break;
		}
		case "uso_gimnasio":{
			daoConsulta(daoUso_gimnasio);
			break;
		}
		default:{
			System.out.println("Colección no válida");
		}
		}
	}
	
	static void daoConsulta(MongoDAO mongoDao) {
		try {
			FindIterable<Document> lista = mongoDao.consultarDocumentos();
			for (Document d : lista) {
				System.out.println(d);
			}
		} catch(NullPointerException e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	static void opciones() {
		System.out.println("");
		System.out.println("1- Mostrar todos los documentos de cualquier colección");
		System.out.println("2- Insertar un documento en cualquier colección");
		System.out.println("3- Eliminar un documento de cualquier colección");
		System.out.println("");
		System.out.println("4- Salir");
		System.out.println("");
	}
	
	static void cerrarBD() {
		daoActividades.cerrarBD();
		daoSocios.cerrarBD();
		daoUso_gimnasio.cerrarBD();
	}

}
