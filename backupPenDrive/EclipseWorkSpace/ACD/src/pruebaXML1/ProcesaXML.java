package pruebaXML1;

import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

// Clase que procesa un XML de ejemplo mediante el handler SAX ManejadorEjemplo

public class ProcesaXML {
	 	
	public static void main(String[] args) {
		try {
			// Creamos la factoria de parseadores por defecto
			XMLReader reader = XMLReaderFactory.createXMLReader();
			// Añadimos nuestro manejador al reader
			reader.setContentHandler(new ManejadorEjemplo());
			// Procesamos el xml de ejemplo
			reader.parse(new InputSource(new FileInputStream("libreria.xml")));
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
