package controllers;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import models.Empleado;
import util.JpaUtil;

public class EmpleadoBD {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA1");

	public boolean insertarEmp(Object emp) {
		EntityManager em = JpaUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(emp);
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

	public boolean modificarEmp(Object emp) {
		EntityManager em = JpaUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.merge(emp);
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

	public boolean borrarEmp(Object emp) {
		EntityManager em = JpaUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(emp);
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

	public Empleado mostrarUno(long id) {
		EntityManager em = JpaUtil.getEntityManager();

		Empleado emp = em.find(Empleado.class, id);

		em.close();

		return emp;
	}

	public ArrayList<Empleado> mostrarTodos() {
		EntityManager em = JpaUtil.getEntityManager();
		ArrayList<Empleado> lista = new ArrayList<>();

		TypedQuery<Empleado> empleados = em.createQuery("select e from Empleado e", Empleado.class);

		for (Empleado e : empleados.getResultList()) {
			lista.add(e);
		}
		return lista;
	}
	
}
