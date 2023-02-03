package david.david;

import org.bson.Document;

public class MongoDAO {
	
	MongoConnection mongoConnection;
	
	MongoDAO(String db, String coll){
		this.mongoConnection = new MongoConnection(db, coll);
	}
	
	public void insertarDocumento(Document document) {
		mongoConnection.getColleccion().insertOne(document);
	}
	
	public void eliminarDocumento() {
		
	}
	
	public void eliminarCollecion() {
		
	}
	
	public void borrarTodosDocumentosDeCollecion() {
		
	}
	
	public void consultarDocumento() {
		
	}
	
	public void consultarCollecionConAgregacion() {
		
	}
	
	public void consultarCollecionOrdenadaAscendente() {
		
	}
	
	public void consultarCollecionOrdenadaDescendente() {
		
	}
	
	public void actualizarDocumento() {
		
	}
}
