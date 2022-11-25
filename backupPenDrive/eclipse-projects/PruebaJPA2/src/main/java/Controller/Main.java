package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import models.Compartimento;
import models.Departamento;
import models.Empleado;
import models.EmpleadoDAO;
import util.JpaUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		//Crear un Departamento
		Departamento departamento = new Departamento();
		departamento.setNombre("Ventas");
		//Crear el empleado 1
		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Ana");
		empleado1.setNif("222");
		empleado1.setEdad(25);
		empleado1.setDepartamento(departamento);
		//Almacenar el empleado 1
		em.persist(empleado1);
		// Crear el empleado 2
		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Pepe");
		empleado2.setNif("333");
		empleado2.setEdad(44);
		empleado2.setDepartamento(departamento);
		//Almacenar el empleado 2
		em.persist(empleado2);
		//Añadir los empleados al departamento
		departamento.getEmpleados().add(empleado1);
		departamento.getEmpleados().add(empleado1);
		//Almacenar el departamento
		em.persist(departamento);
		em.getTransaction().commit();
		em.close();
	}
	
	/*
	 * public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		//Crear la entidad Compartimento
		Compartimento compartimento = new Compartimento();
		compartimento.setDescripcion("Planta baja, compartimento 1");
		//Almacenar el compartimento
		em.persist(compartimento);
		//Crear la entidad Empleado
		Empleado empleado = new Empleado();
		empleado.setNombre("Ana");
		empleado.setCompartimentoAsignado(compartimento);
		//Almacenar el empleado
		em.persist(empleado);
		em.getTransaction().commit();
		em.close();
	}
	 */
}
