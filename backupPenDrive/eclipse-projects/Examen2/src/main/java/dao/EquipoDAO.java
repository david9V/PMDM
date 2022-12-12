package dao;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Equipo;
import util.JpaUtil;

public class EquipoDAO {

	public String altaEquipo(Object Equipo) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";
		try {
			em.getTransaction().begin();
			em.persist(Equipo);
			em.getTransaction().commit();
			info = "\nEquipo dado de alta";
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

	public String bajaEquipo(String nombre) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";
		try {
			em.getTransaction().begin();
			Equipo e = em.find(Equipo.class, nombre);
			em.remove(e);
			em.getTransaction().commit();
			info = "\nEquipo dado de baja";
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
	
	public Equipo consultaEquipo(String nombre) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Equipo a = em.find(Equipo.class, nombre);
		em.close();
		
		return a;
	}
	
	public boolean existeEquipo(String nombre) {
		EntityManager em = JpaUtil.getEntityManager();
		
		if (em.find(Equipo.class, nombre) == null)
			return false;
		else
			return true;		
	}

	public ArrayList<Equipo> recuperarEquipos() {
		EntityManager em = JpaUtil.getEntityManager();
		ArrayList<Equipo> lista = new ArrayList<>();
		TypedQuery<Equipo> equipo = em.createQuery("select e from Equipo e", Equipo.class);
						
		for(Equipo e: equipo.getResultList()) {
			lista.add(e);
		}
		
		em.close();
		return lista;
	}
	
	public Equipo mostrarEquipoPorNombre(String nombre) {
		EntityManager em = JpaUtil.getEntityManager();
		
		TypedQuery<Equipo> equipo = em.createQuery("select a from Equipo a where NOMBRE_EQUIPO=:nombre", Equipo.class);
		equipo.setParameter("nombre", nombre);
		Equipo a;
		try {
			a = equipo.getSingleResult();			
		} catch (Exception e) {
			a = null;
		}
		em.close();
		
		return a;
	}
	
	
}
