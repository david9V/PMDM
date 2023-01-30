package david.david;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class PruebaMongo1 {

	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" ); // ESTO PARA QUITAR LAS COSAS ROJAS
		mongoLogger.setLevel(Level.SEVERE); 

		MongoClient mongoClient = new MongoClient("localhost", 27017);

		System.out.println("Bases de datos:");
		for (String s : mongoClient.listDatabaseNames()) {
			System.out.print(s + "  |  ");
		}
		System.out.println();

		System.out.println("Conectando a la DB media...");
		MongoDatabase db = mongoClient.getDatabase("media");

		System.out.println("Colleciones de media:");
		for (String c : db.listCollectionNames()) {
			System.out.println(c);
		}

		System.out.println("Conectando a la colección media...");
		MongoCollection<Document> collecion = db.getCollection("media");

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

	}

}
