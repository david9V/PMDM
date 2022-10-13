package ActFichToXML;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Main {

	public static void main(String[] args) {
		try{
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementacion = builder.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "empleados", null);
			documento.setXmlVersion("1.0");

			RandomAccessFile file = null;
			try {
				file = new RandomAccessFile("archivoAccesoAleatorio.dat", "rw");
			} catch (FileNotFoundException e) {
				System.out.println("Error con el fichero");
				e.printStackTrace();
				System.exit(-1);
			}
			
			String id;
			String departamento;
			String salario;
			//Vamos a leer el fichero aleatorio
			try {
				file.seek(0);
				while(true) {
					id = String.valueOf(file.readInt());
					String apellido = "";
					for(int i = 0; i<10; i++){
						char c = file.readChar();
						if(Character.isLetter(c)) {
							apellido+=c;
						}
					}
					departamento = String.valueOf(file.readInt());
					salario = String.valueOf(file.readDouble());
					
					//	creamos el elemento empleado
					Element empleado = documento.createElement("empleado");
					documento = añadirNodo(documento, empleado, "id", id);
					documento = añadirNodo(documento, empleado, "apellido", apellido);
					documento = añadirNodo(documento, empleado, "departamento", departamento);
					documento = añadirNodo(documento, empleado, "salario", salario);
				}
			} catch(EOFException e) {
				System.out.println("Fin de lectura del fichero aleatorio");
				System.out.println("Creando archivo XML...");
				System.out.println();
			} catch(IOException ex) {
				
			}
			file.seek(0);
			
			
			Source origen = new DOMSource(documento);
			Result resultado = new StreamResult(new File("aleatorio_a_XML.xml"));
			Result consola = new StreamResult(System.out);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.transform(origen, resultado);
			transformer.transform(origen, consola);
		}catch (Exception e){
			System.out.println("Error: "+ e);
		}
	}
	
	public static Document añadirNodo(Document d,Element empleado, String elemento, String texto) {
		Element e = d.createElement(elemento);
		Text t = d. createTextNode(texto);
		d.getDocumentElement().appendChild(empleado);
		empleado.appendChild(e);
		e.appendChild(t);
		
		return d;
	}

}
