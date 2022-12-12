package test2;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class InsertaDatos {

	public static void main(String[] args) {
		Jugadores j1 = new Jugadores("España");
		Jugadores j2 = new Jugadores("Croacia");
		Jugadores j3 = new Jugadores("Inglaterra");
		
		Pais p1 = new Pais(1, "Argentina");
		Pais p2 = new Pais(1, "Marruecos");
		
		ODB odb = ODBFactory.open("EQUIPOS.BD");
		
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(p1);
		odb.store(p2);
		
		odb.close();

	}

}
