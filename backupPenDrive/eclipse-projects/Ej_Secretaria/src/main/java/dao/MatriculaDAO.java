package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Alumno;
import model.Asignatura;
import model.Matriculacion;
import util.JpaUtil;

public class MatriculaDAO {

	public String altaMatr(Object matricula) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(matricula);
			em.getTransaction().commit();
			return "Matrícula añadida";
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return "Ha ocurrido un error al insertar la matrícula";
		} finally {
			em.close();
		}
	}
	
	public boolean existeMatr(Object matricula) {
		EntityManager em = JpaUtil.getEntityManager();
		
		TypedQuery<Matriculacion> matr = em.createQuery("select m from Matriculacion m where dni=:dni and cod_asignatura=:cod_asignatura", Matriculacion.class);
		matr.setParameter("dni", ((Matriculacion)matricula).getAlumno().getDni());
		matr.setParameter("cod_asignatura", ((Matriculacion)matricula).getAsignatura().getCodigo());
		try {
			Matriculacion m = matr.getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
