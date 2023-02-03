package david.david;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.result.DeleteResult;

public class MongoDAO {
	
	MongoConnection mongoConnection;
	
	MongoDAO(String db, String coll){
		this.mongoConnection = new MongoConnection(db, coll);
	}
	
	public void insertarDocumento(Document document) {
		mongoConnection.getColleccion().insertOne(document);
	}
	
	public boolean eliminarDocumento(String id) {
		DeleteResult deleteResult = mongoConnection.getColleccion().deleteOne(new Document("_id", id));
		if (deleteResult.getDeletedCount() == 1)
			return true;
		else
			return false;
	}
	
	public void eliminarCollecion() {
		mongoConnection.getColleccion().drop();
	}
	
	public void eliminarTodosDocumentosDeCollecion() {
		mongoConnection.getColleccion().deleteMany(new Document());
	}
	
	public Document consultarDocumento(String id) {
		FindIterable<Document> it = mongoConnection.getColleccion().find(new Document("_id", id));
		return it.first();
	}
	
	public void consultarCollecionConAgregacion() {
		
	}
	
	public FindIterable<Document> consultarCollecionOrdenadaAscendente() {
		return mongoConnection.getColleccion().find().sort(new Document("_id", 1));
	}
	
	public FindIterable<Document> consultarCollecionOrdenadaDescendente() {
		return mongoConnection.getColleccion().find().sort(new Document("_id", 0));
	}
	
	public void actualizarDocumento() {
		
	}
}
