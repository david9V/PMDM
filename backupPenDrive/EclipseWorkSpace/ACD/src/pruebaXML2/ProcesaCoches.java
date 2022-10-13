package pruebaXML2;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ProcesaCoches {
	
	public static void main (String args[]){
		ArrayList<Coche> coches;
		Coche coche;
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			// Añadimos nuestro manejador al reader
			HandCoches handler = new HandCoches();
			reader.setContentHandler(handler);
			// Procesamos el xml
			reader.parse(new InputSource(new FileInputStream("coches.xml")));
			coches=handler.getCoches();
			for(int i=0; i<coches.size(); i++){
				coche=coches.get(i);
				System.out.println(coche.toString());
			}
		} catch(Exception e) {
			
		}
	}
	
}
	

	
