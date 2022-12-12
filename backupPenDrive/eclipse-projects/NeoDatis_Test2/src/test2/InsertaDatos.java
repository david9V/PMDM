package test2;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class InsertaDatos {

	public static void main(String[] args) {
		Jugadores j1 = new Jugadores("España");
		Jugadores j2 = new Jugadores("Croacia");
		Jugadores j3 = new Jugadores("Inglaterra");
		
		ODB odb = ODBFactory.open("EQUIPOS.BD");
		
	}

}
