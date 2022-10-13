package ejercicioXML1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
	
	public static void main(String args[]) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader flujoE = new BufferedReader(isr);
		PrintStream flujoS = System.out;
		String nombre;
		flujoS.print("Introduzca nombre del fichero XML: ");
		nombre=flujoE.readLine();
		File fich=new File(nombre);
		if(fich.exists()){
		try {
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(fich);
		Element root = document.getDocumentElement();
		// Combina nodos de textos de múltiples líneas y
		// elimina nodos de texto vacíos
		root.normalize();
		printNodo(root, 0);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		else
		System.out.println("No se encuentra el fichero XML");
		
	}
	
	public static void printNodo(Node nodo, int profundidad) {
		String prefijo = rellenarblancos(2*profundidad, " ");
		if (nodo.getNodeType() == Node.TEXT_NODE) {
		System.out.println(prefijo + nodo.getNodeValue());
		} else {
		NamedNodeMap atributos = nodo.getAttributes();
		if ((atributos == null) || (atributos.getLength() == 0)) {
		System.out.println(prefijo+ nodo.getNodeName());
		} else {
		System.out.print(prefijo + "[ " + nodo.getNodeName());
		printatributos(atributos);
		System.out.println(" ]");
		}
		}
		NodeList children = nodo.getChildNodes();
		for(int i=0; i<children.getLength(); i++) {
		Node childNode = children.item(i);
		printNodo(childNode, profundidad+1);
		}
	}
	
	private static void printatributos(NamedNodeMap atributos) {
		for(int i=0; i<atributos.getLength(); i++) {
		Node atributo = atributos.item(i);
		System.out.print(" "+atributo.getNodeName()+ " = "+ atributo.getNodeValue());
		}
	}
	
	private static String rellenarblancos(int n, String blanco) {
		StringBuilder blancos = new StringBuilder("");
		for(int i=0; i<n; i++) {
		blancos = blancos.append(blanco);
		}
		return(blancos.toString());
	}
	
	
	
}
