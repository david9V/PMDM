package pruebaXMSLTDH;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbTest {
	private final static String XML_EMPLEADOS = "./info-empleados.xml";

	public static void main(String[] args) throws JAXBException, IOException {
// Primero rellenamos los objetos Java y generamos un XML
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		Empleado empleado1 = new Empleado();
		empleado1.setDni("12345678C");
		empleado1.setNombre("Carlos Pérez Ruíz");
		empleado1.setEdad(29);
		Empleado empleado2 = new Empleado();
		empleado2.setDni("87654321C");
		empleado2.setNombre("Claudia Ortiz Zaldo");
		empleado2.setEdad(31);
		Empresa empresa = new Empresa();
		empresa.setCif("A58818501");
		empresa.setNombre("TECNOMUR S.L.");
		empleados.add(empleado1);
		empleados.add(empleado2);
		empresa.setEmpleados(empleados);
//Creamos el contexto e instanciamos el marshaller
		JAXBContext context = JAXBContext.newInstance(Empresa.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(empresa, System.out);
		Writer w = null;
		try {
			w = new FileWriter(XML_EMPLEADOS);
			m.marshal(empresa, w);
		} finally {
			try {
				w.close();
			} catch (Exception e) {
			}
		}
//Ahora leemos el XML e instanciamos las clases Java
		System.out.println("Salida desde el fichero XML: ");
		Unmarshaller um = context.createUnmarshaller();
		Empresa empresa2 = (Empresa) um.unmarshal(new FileReader(XML_EMPLEADOS));
		for (int i = 0; i < empresa2.getEmpleados().toArray().length; i++) {
			System.out.println("Empleado " + (i + 1) + ": " + empresa2.getEmpleados().get(i).getNombre() + " con DNI "
					+ empresa2.getEmpleados().get(i).getDni() + " y " + empresa2.getEmpleados().get(i).getEdad()
					+ " años");
		}
	}
}
