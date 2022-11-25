package dao;

import jakarta.persistence.EntityManager;
import model.Alumno;
import model.Asignatura;
import util.JpaUtil;

public class AlumnoDAO {
	
	public String altaAlumno(Object alumno) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";
		try {
			em.getTransaction().begin();
			if (em.find(Alumno.class, alumno) == null) {
				em.persist(alumno);
				em.getTransaction().commit();
				info = "Alumno dado de alta";
			}
			else {
				em.getTransaction().rollback();
				info = "No se puede dar de alta, el alumno ya existe";
			}
			return info;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			info = "Ha habido uno error en la transacción";
			return info;
		} finally {
			em.close();
		}
	}
	
	public String bajaAlumno(String dni) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";
		try {
			em.getTransaction().begin();
			Alumno a = em.find(Alumno.class, dni);
			if (a.getMatriculacions() == null) {
				em.remove(a);
				em.getTransaction().commit();
				info = "Alumno dado de baja";
			}
			else {
				em.getTransaction().rollback();
				info = "No se puede dar de baja, el alumno está matriculado en alguna asignatura";
			}
			return info;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			info = "Ha habido uno error en la transacción";
			return info;
		} finally {
			em.close();
		}
	}
	
	public Alumno consultaAlumno(String dni) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Alumno a = em.find(Alumno.class, dni);
		em.close();
		
		return a;
	}
	
	public boolean existeAlumno(String dni) {
		EntityManager em = JpaUtil.getEntityManager();
		
		if (em.find(Alumno.class, dni) == null)
			return false;
		else
			return true;		
	}
}
