package dao;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Jugadore;
import util.JpaUtil;

public class JugadoreDAO {
	public String altaJugador(Object jugador) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";
		try {
			em.getTransaction().begin();
			em.persist(jugador);
			em.getTransaction().commit();
			info = "\nJugador dado de alta";
			return info;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			info = ex.getMessage();
			return info;
		} finally {
			em.close();
		}
	}

	public String bajaJugador(long id) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";
		try {
			em.getTransaction().begin();
			Jugadore jug = em.find(Jugadore.class, id);
			em.remove(jug);
			em.getTransaction().commit();
			info = "\nJugador dado de baja";
			return info;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			info = ex.getMessage();
			return info;
		} finally {
			em.close();
		}
	}

	public Jugadore consultaJugador(long id) {
		EntityManager em = JpaUtil.getEntityManager();

		Jugadore jug = em.find(Jugadore.class, id);
		em.close();

		return jug;
	}

	public boolean existeJugador(long id) {
		EntityManager em = JpaUtil.getEntityManager();

		if (em.find(Jugadore.class, id) == null)
			return false;
		else
			return true;
	}

	public ArrayList<Jugadore> mostrarJugadors() {
		EntityManager em = JpaUtil.getEntityManager();
		ArrayList<Jugadore> lista = new ArrayList<>();
		TypedQuery<Jugadore> jugadores = em.createQuery("select j from Jugadore j", Jugadore.class);

		// Jugador.setParameter("cod", cod);

		for (Jugadore jug : jugadores.getResultList()) {
			lista.add(jug);
		}

		em.close();
		return lista;
	}

	public Jugadore mostrarJugadorPorNombre(String nombre) {
		EntityManager em = JpaUtil.getEntityManager();

		TypedQuery<Jugadore> Jugador = em.createQuery("select j from Jugadore j where nombre=:nombre", Jugadore.class);
		Jugador.setParameter("nombre", nombre);
		Jugadore jug;
		try {
			jug = Jugador.getSingleResult();
		} catch (Exception e) {
			jug = null;
		}
		em.close();

		return jug;
	}

}
