package models;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;

public class CompartimentoDAO {

	public boolean insertarComp(Object comp) {
		EntityManager em = JpaUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(comp);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}

	}

	public boolean modificarComp(Object comp) {
		EntityManager em = JpaUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(comp);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}

	}

	public boolean borrarComp(Long id) {
		EntityManager em = JpaUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(em.find(Compartimento.class, id));
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}

	}

	public Compartimento mostrarUno(long id) {
		EntityManager em = JpaUtil.getEntityManager();

		Compartimento comp = em.find(Compartimento.class, id);

		em.close();

		return comp;
	}

	public ArrayList<Compartimento> mostrarTodos() {
		EntityManager em = JpaUtil.getEntityManager();
		ArrayList<Compartimento> lista = new ArrayList<>();

		TypedQuery<Compartimento> Compartimentos = em.createQuery("select e from Compartimento e", Compartimento.class);

		for (Compartimento e : Compartimentos.getResultList()) {
			lista.add(e);
		}
		return lista;
	}
	
}
