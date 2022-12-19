package test2;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import test2.Jugadores;

public class VisualizarDatos {
	public static void main(String[] args) {
		ODB odb = ODBFactory.open("EQUIPOS.BD");

		Objects<Jugadores> jugadores = odb.getObjects(Jugadores.class);
		System.out.println(jugadores.size() + " Jugadores");
		int i = 1;
		while (jugadores.hasNext()) {
			Jugadores jug = jugadores.next();
			System.out.println((i++) + " \t: " + jug.getPais());
		}
		
		Objects<Pais> paises = odb.getObjects(Pais.class);
		System.out.println(paises.size() + " Países");
		i = 1;
		while (paises.hasNext()) {
			Pais pais = paises.next();
			System.out.println((i++) + " \t: " + pais.getId() + "*" + pais.getNombrePais());
		}
		odb.close();

	}
}
