package com.hg.microservices.models.dto;

import java.util.List;

import com.hg.microservices.models.Course;

public class TeacherDto {

	//atributos person
	
	private String id;

	private String name;

	private String gender;

	private String email;

	//atributos teacher
		
	private String degree;
	
	private Double salary;

	private List<Course> courses;
	

	public TeacherDto(String id, String name, String gender, String email, String degree, Double salary,
			List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.degree = degree;
		this.salary = salary;
		this.courses = courses;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "TeacherDto [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", degree="
				+ degree + ", salary=" + salary + ", courses=" + courses + "]\n";
	}
	
	
	
}
