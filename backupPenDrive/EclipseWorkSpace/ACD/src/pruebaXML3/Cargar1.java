package pruebaXML3;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.*;
public class Cargar1 {
	
public static void main(String[] args) {
	String file = "laboratorio.xml";
	if (args.length > 0) {
		file = args[0];
		}
	try {
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(file));
		Element root = document.getDocumentElement();
		System.out.println(root.getTagName());
		System.out.printf(" nombre: %s%n",
				root.getAttribute("nombre"));
		System.out.printf(" nombre corto: %s%n",
				root.getAttribute("nombrecorto"));
		System.out.printf(" mision: %s%n",
			root.getAttribute("mision"));
	} catch(Exception e) {
		e.printStackTrace();
		}
	}
}