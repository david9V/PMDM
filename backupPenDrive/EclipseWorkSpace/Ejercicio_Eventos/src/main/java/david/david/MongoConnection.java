package david.david;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	private Logger mongoLogger; // PARA QUITAR LOS MENSAJES EN ROJOS DEL TERMINAL

	private MongoClient mongoClient;

	private MongoDatabase db;

	private MongoCollection<Document> coleccion;
	
	MongoConnection(String database, String collection){
		this.mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE); 
		this.mongoClient = new MongoClient("localhost", 27017);
		this.db = mongoClient.getDatabase(database);
		this.coleccion = db.getCollection(collection);
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public MongoDatabase getDb() {
		return db;
	}

	public MongoCollection<Document> getColleccion() {
		return coleccion;
	}
	
	
}
