package dao;

import jakarta.persistence.EntityManager;
import model.Alumno;
import model.Asignatura;
import util.JpaUtil;

public class AsignaturaDAO {

	public String altaAsig(Object asig) {
		EntityManager em = JpaUtil.getEntityManager();
		String info = "";

		try {
			em.getTransaction().begin();
			if (em.find(Alumno.class, asig) == null) {
				em.persist(asig);
				em.getTransaction().commit();
				info = "Asignatura dada de alta";
			}
			else {
				em.getTransaction().rollback();
				info = "No se puede dar de alta, la asignatura ya existe";
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
	
	public Asignatura consultaAsig(String titulo) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Asignatura a = em.find(Asignatura.class, titulo);
		em.close();
		
		return a;
	}
	
	public boolean existeAsig(String codigo) {
		EntityManager em = JpaUtil.getEntityManager();
		
		if (em.find(Asignatura.class, codigo) == null)
			return false;
		else
			return true;		
	}
	
}
