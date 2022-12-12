package test3;

import java.sql.Date;

public class Empleado {
	private int empNo;
	private String apellido;
	private String oficio;
	private Empleado dir;
	private java.sql.Date fechaAlt;
	private float salario;
	private float comision;
	private Departamento dept;
	
	public Empleado(int empNo, String apellido, String oficio, Empleado dir, Date fechaAlt, float salario,
			float comision, Departamento dept) {
		this.empNo = empNo;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.fechaAlt = fechaAlt;
		this.salario = salario;
		this.comision = comision;
		this.dept = dept;
	}
	
	public Empleado() {
		super();
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Empleado getDir() {
		return dir;
	}

	public void setDir(Empleado dir) {
		this.dir = dir;
	}

	public java.sql.Date getFechaAlt() {
		return fechaAlt;
	}

	public void setFechaAlt(java.sql.Date fechaAlt) {
		this.fechaAlt = fechaAlt;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public Departamento getDept() {
		return dept;
	}

	public void setDept(Departamento dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Empleado [empNo=" + empNo + ", apellido=" + apellido + ", oficio=" + oficio + ", dir=" + dir
				+ ", fechaAlt=" + fechaAlt + ", salario=" + salario + ", comision=" + comision + ", dept=" + dept + "]";
	}
	
	
	
}
