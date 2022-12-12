package dao;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Estadistica;
import model.Jugadore;
import util.JpaUtil;

public class EstadisticaDAO {
	
	public String altaEstadistica(Object estadistica) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";
		try {
			em.getTransaction().begin();
			em.persist(estadistica);
			em.getTransaction().commit();
			info = "\nEstadistica dada de alta";
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
	
	public boolean existeEstadisticaPK(Object estadistica_pk) {
		EntityManager em = JpaUtil.getEntityManager();

		if (em.find(Estadistica.class, estadistica_pk) == null)
			return false;
		else
			return true;
	}
	
	public ArrayList<Estadistica> recuperarEstadisticas() {
		EntityManager em = JpaUtil.getEntityManager();
		ArrayList<Estadistica> lista = new ArrayList<>();
		TypedQuery<Estadistica> estadisticas = em.createQuery("select e from Estadistica e", Estadistica.class);

		for (Estadistica est : estadisticas.getResultList()) {
			lista.add(est);
		}

		em.close();
		return lista;
	}
}
