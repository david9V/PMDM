package pruebaXML2;

import java.util.ArrayList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandCoches extends DefaultHandler {
	private ArrayList<Coche> coches;
	private Coche coche;
	private StringBuilder sbItem;
	
	public ArrayList<Coche> getCoches() {
		return coches;
	}
	
	public void startDocument() throws SAXException {
		super.startDocument();
		coches = new ArrayList<Coche>();
		sbItem = new StringBuilder();
	}
	
	public void startElement(String uri, String localName, String name, org.xml.sax.Attributes attributes) throws SAXException { 
		super.startElement(uri, localName, name, attributes);
		// Valida que al detectar una etiqueta reco declare el objeto.
		
		if (localName.equals("reco")) {
		coche= new Coche();
		}
		
	}
	
	public void characters(char[] ch, int start, int length)
		throws SAXException {
		super.characters(ch, start, length);
		
		if (this.coche != null) sbItem.append(ch, start, length);
	}

	public void endElement(String uri, String localName, String name) throws SAXException {
		super.endElement(uri, localName, name);
		if (this.coche != null) {
			// Colocamos los nombres de cada etioqueta del XML.
			// Este proceso se ejecuta por cada etiqueta XML.
			// Aquí guardamos cada valor al objeto.
			if (localName.equals("id")) {
				// 	La variable sbItem contiene el contenido de cada tag.
				coche.setId(sbItem.toString());
			} else if (localName.equals("marca")) {
				// 	"marca" es el nombre de la etiqueta XML.
				coche.setMarca(sbItem.toString());
			} else if (localName.equals("modelo")) {
				coche.setModelo(sbItem.toString());
			} else if (localName.equals("reco")) {
				/**
				 * Al leer reco, significa que terminamos el registro y debemos
				 * guardar el objeto al ArrayList
				 **/
				coches.add(coche);
			}
			sbItem.setLength(0);
		}
	}
}