package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import dao.EquipoDAO;
import dao.EstadisticaDAO;
import dao.JugadoreDAO;
import dao.PartidoDAO;
import model.Equipo;
import model.Estadistica;
import model.EstadisticaPK;
import model.Jugadore;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static EquipoDAO equipoDAO = new EquipoDAO();
	static EstadisticaDAO estadisticaDAO = new EstadisticaDAO();
	static JugadoreDAO jugadoreDAO = new JugadoreDAO();
	static PartidoDAO partidoDAO = new PartidoDAO();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int opc = 0;
		do {
			opciones();
			try {
				opc = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (opc) {
			case 1 -> {
				insertarEstadisticas();
			}
			case 2 -> {
				mostrarEstadisticas();
			}
			case 3 -> {
				listadoJugadoresPorEquipo();
			}
			}

			System.out.println();
		} while (opc < 4);

	}
	
	public static void insertarEstadisticas() throws NumberFormatException, IOException {
		System.out.println("Introduzca la ID del jugador para insertar la estadística");
		long id = Long.parseLong(reader.readLine());
		if (jugadoreDAO.existeJugador(id)) {
			System.out.println("Introduzca la temporada");
			String temporada = reader.readLine();
			EstadisticaPK estadisticaPK = new EstadisticaPK();
			estadisticaPK.setIdJugador(id);
			estadisticaPK.setTemporada(temporada);
			if (estadisticaDAO.existeEstadisticaPK(estadisticaPK)) {
				System.out.println("");
				System.out.println("Imposible insertar estadística");
				System.out.println("Ya existe una estadística con esa ID");
			}
			else {
				System.out.println("Introduzca los puntos por partido");
				String s_puntos = reader.readLine();
				BigDecimal puntos;
				if (verificarNulo(s_puntos))
					 puntos = null;
				else
					puntos = BigDecimal.valueOf(Double.parseDouble(s_puntos));
				System.out.println("Introduzca las asistencias por partido");
				String s_asistencias = reader.readLine();
				BigDecimal asistencias;
				if (verificarNulo(s_asistencias))
					 asistencias = null;
				else
					asistencias = BigDecimal.valueOf(Double.parseDouble(s_asistencias));
				System.out.println("Introduzca los tapones por partido");
				String s_tapones = reader.readLine();
				BigDecimal tapones;
				if (verificarNulo(s_tapones))
					 tapones = null;
				else
					tapones = BigDecimal.valueOf(Double.parseDouble(s_tapones));
				System.out.println("Introduzca los rebotes por partido");
				String s_rebotes = reader.readLine();
				BigDecimal rebotes;
				if (verificarNulo(s_rebotes))
					 rebotes = null;
				else
					rebotes = BigDecimal.valueOf(Double.parseDouble(s_rebotes));
				Estadistica estadistica = new Estadistica();
				estadistica.setId(estadisticaPK);
				estadistica.setAsistenciasPorPartido(asistencias);
				estadistica.setPuntosPorPartido(puntos);estadistica.setRebotesPorPartido(rebotes);
				estadistica.setTaponesPorPartido(tapones);
				System.out.println("");
				System.out.println(estadisticaDAO.altaEstadistica(estadistica));
			}
		}
		else {
			System.out.println("");
			System.out.println("Imposible insertar estadística");
			System.out.println("No existe un jugador con esa ID");
		}
	}
	
	static void mostrarEstadisticas() throws NumberFormatException, IOException {
		System.out.println("Introduzca el ID de un jugador");
		long id = Long.parseLong(reader.readLine());
		if (jugadoreDAO.existeJugador(id)) {
			Jugadore jugador = jugadoreDAO.consultaJugador(id);
			System.out.println("");
			System.out.println("Datos del jugador: " + jugador.getIdJugador());
			System.out.println("Jugador: " + jugador.getNombre());
			ArrayList<Estadistica> lista = estadisticaDAO.recuperarEstadisticas();
			int n = 0;
			System.out.println("Temporada     Puntos     Asistencias     Tapones     Rebotes");
			for (Estadistica e : lista) {
				if (e.getId().getIdJugador() == id) {
					System.out.println(e);
					n++;
				}
			}
			System.out.println("Número de registros: " + n);
		}
		else {
			System.out.println("");
			System.out.println("Imposible mostrar estadísticas");
			System.out.println("No existe un jugador con esa ID");
		}
		
	}
	
	static void listadoJugadoresPorEquipo() {
		ArrayList<Equipo> lista = equipoDAO.recuperarEquipos();
		System.out.println("Número de equipos: " + lista.size());;
		
		for(Equipo e : lista) {
			System.out.println("Equipo: " + e.getNombreEquipo());
			ArrayList<Jugadore> jugadores = jugadoreDAO.recuperarJugadoresPorEquipo(e.getNombreEquipo());
			for(Jugadore j : jugadores) {
				BigDecimal altura = j.getAltura().divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
				System.out.println(j.getIdJugador() + ", " + j.getNombre() + ": " + altura + "m");
			}
			System.out.println("==============================================");
		}
	}
	
	static boolean verificarNulo(String s) {
		if (s.isEmpty())
			return true;
		else
			return false;
	}

	
	
	public static void opciones() {
		System.out.println("1- Insertar estadísticas por jugador");
		System.out.println("2- Mostrar estadísticas");
		System.out.println("3- Listado de jugadores por equipo");
		System.out.println("");
		System.out.println("4- Salir");
	}

}
