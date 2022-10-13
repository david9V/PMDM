package ejercicioXML2;

import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
public class CrearXML {
	public static void main(String[] args){
		try{
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementacion = builder.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "empleados", null);
			//	creamos el elemento empleado
			Element empleado = documento.createElement("empleado");
			//creamos el elemento correo
			Element correo = documento.createElement("correo");
			//introducimos la información
			Text email = documento. createTextNode("david@gmail.es");
			//introducimos la versión de xml
			documento.setXmlVersion("1.0");
			//añadimos a la raiz al documento el elemento empleado
			documento.getDocumentElement().appendChild(empleado);
			//añadimos el elemento correo como elemento hijo de empleado
			empleado.appendChild(correo);
			//Se añade el objeto Text email como hijo del objeto Element correo
			correo.appendChild(email);
			Source origen = new DOMSource(documento);
			Result resultado = new StreamResult(new File("resultado.xml"));
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
}