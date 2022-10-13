package pruebaXML1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ManejadorEjemplo extends DefaultHandler{
	
	public void startDocument() throws SAXException {
		System.out.println("\nPrincipio del	documento...");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("\nFin del documento...");
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("Comienza: "+qName);
		//Recorremos los atributos
		
		for(int i=0;i<attributes.getLength();i++) {
		System.out.print(" "+attributes.getQName(i)
		+" =");
		System.out.println(attributes.getValue(i));
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("\nProcesando texto dentro de una etiqueta... ");
		System.out.println("\tTexto: "+String.valueOf(ch, start, length));
	}
	
	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		System.out.println("Cierra: "+name);
	}
	
	
	
}