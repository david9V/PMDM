package david.david;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static MongoDAO dao = new MongoDAO("eventos", "eventos");
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int opc;
		do {
			opciones();
			opc = Integer.valueOf(br.readLine());
			switch (opc) {
			case 1:{
				System.out.println("sdfsdf");
				//insertarDocumento();
				break;
			}
			case 2:{
				
				break;
			}
			case 3:{
				
				break;
			}
			case 4:{
				
				break;
			}
			case 5:{
				
				break;
			}
			case 6:{
				
				break;
			}
			case 7:{
				
				break;
			}
			case 8:{
				
				break;
			}
			case 9:{
				
				break;
			}
			}
		} while(opc != 5);
		
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
		System.out.println("Introduzca el nombre");
		String nombre = br.readLine();
		System.out.println("Introduzca la fecha");
		String fecha = br.readLine();
		System.out.println("Introduzca la ciudad");
		String ciudad = br.readLine();
		System.out.println("Introduzca el precio");
		int precio = Integer.valueOf(br.readLine());
		dao.insertarDocumento(null);
	}
	
	static void opciones() {
		System.out.println("");
		System.out.println("1- Insertar documento");
		System.out.println("2- Eliminar documento de la colección");
		System.out.println("3- Eliminar colección");
		System.out.println("4- Borrar todos los documentos de la colección");
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
