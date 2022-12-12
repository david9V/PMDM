package test;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Main {

	public static void main(String[] args) {
		Jugadores j1 = new Jugadores("María", "voleibol", "Madrid", 14);
		Jugadores j2 = new Jugadores("Miguel", "tenis", "Madrid", 13);
		Jugadores j3 = new Jugadores("Mario", "baloncesto", "Guadalajara", 15);
		Jugadores j4 = new Jugadores("Alicia", "tenis", "Madrid", 14);
		ODB odb = ODBFactory.open("neodatis2.test"); // Abrir BD
		// Almacenamos objetos
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		// recuperamos todos los objetos
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
		System.out.println(objects.size() + " Jugadores");
		int i = 1;
		// visualizar los objetos
		while (objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + " \t: " + jug.getNombre() + "*" + jug.getDeporte() + "*" + jug.getCiudad() + "*"
					+ jug.getEdad());
		}
		odb.close();
	}
}
