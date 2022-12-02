package dao;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Alumno;
import model.Asignatura;
import model.Matriculacion;
import util.JpaUtil;

public class AlumnoDAO {
	
	public String altaAlumno(Object alumno) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";
		try {
			em.getTransaction().begin();
			if (em.find(Alumno.class, ((Alumno)alumno).getDni()) == null) {
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
			if (a.getMatriculacions().size() == 0) {
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
	
	public ArrayList<Alumno> alumnosPorAsig(String cod) {
		EntityManager em = JpaUtil.getEntityManager();
		ArrayList<Alumno> lista = new ArrayList<>();
		TypedQuery<Matriculacion> matr = em.createQuery("select m from Matriculacion m where cod_asignatura=:cod", Matriculacion.class);
		
		matr.setParameter("cod", cod);
				
		for(Matriculacion m: matr.getResultList()) {
			lista.add(m.getAlumno());
		}
		
		em.close();
		return lista;
	}
}
