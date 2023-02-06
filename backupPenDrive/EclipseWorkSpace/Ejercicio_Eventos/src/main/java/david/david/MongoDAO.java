package david.david;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
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
		return mongoConnection.getColleccion().find().sort(new Document("_id", -1));
	}
	
	public void actualizarDocumento(String id, String nombre, String fecha, String ciudad, int precio) {
		mongoConnection.getColleccion().updateOne(new Document("_id", id),
				new Document("$set", new Document("nombre", nombre)
						.append("fecha", fecha)
						.append("ciudad", ciudad)
						.append("precio", precio)));
	}
	
	public void actualizarDocumentos(String id1, String id2, String nombre, String fecha, String ciudad, int precio) {
		mongoConnection.getColleccion().updateMany(new Document("_id", id1).append("_id", id2),
				new Document("$set", new Document("nombre", nombre)
						.append("fecha", fecha)
						.append("ciudad", ciudad)
						.append("precio", precio)));
	}
	
	public AggregateIterable<Document> agregado1() {
		return mongoConnection.getColleccion().aggregate(
				Arrays.asList(
						Aggregates.match(Filters.eq("nombre", "Boda")),
						Aggregates.group("$nombre", Accumulators.sum("count", 1))
						)
				);
	}
	
	public AggregateIterable<Document> agregado2(){
		return mongoConnection.getColleccion().aggregate(
				Arrays.asList(
						Aggregates.project(
								Projections.fields(
										Projections.excludeId(),
										Projections.include("nombre"),
										Projections.include("ciudad"),
										Projections.include("precio")))));
	}
	
	public void reemplazarDocumento(String id, String nuevo, String valor) {
		mongoConnection.getColleccion().replaceOne(new Document("_id", id), new Document(nuevo, valor));
	}
}
