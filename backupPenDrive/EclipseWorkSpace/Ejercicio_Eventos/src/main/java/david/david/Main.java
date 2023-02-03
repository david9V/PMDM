package david.david;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bson.Document;

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
				
				break;
			}
			}
		} while(opc < 10);
		
		/*
		List<Document> consulta = collecion.find().into(new ArrayList<Document>());

		for (int i = 0; i < consulta.size(); i++) {
			System.out.println(consulta.get(i).toString());
		}
		
		for (int i = 0; i < consulta.size(); i++) {
			Document amig = consulta.get(i);
			System.out.println(" - " + amig.getString("nombre") + " - " + amig.get("telefono") + " - "
					+ amig.getString("curso") + " - " + amig.getDouble("nota"));
		}
		
		MongoCollection<Document> coll = db.getCollection("catalog");
		Document catalog = new Document("journal", "Oracle Magazine")
				.append("publisher", "Oracle Publishing")
				.append("edition", "November December 2013")
				.append("title", "Engineering as a Service")
				.append("author", "David A. Kelly");
		
		coll.insertOne(catalog);
		Document dbObj = coll.find().first();
		System.out.println(dbObj);
		Set<String> set = catalog.keySet();
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext()) {
			Object obj = iter.next();
			System.out.println(obj);
			System.out.println(dbObj.get(obj.toString()));
			
		}
		*/

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
		System.out.println(dao.consultarCollecionOrdenadaAscendente());
	}
	
	static void consultarColleccionDescendente() {
		System.out.println(dao.consultarCollecionOrdenadaDescendente());
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

}
