package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Student")
@Table(name = "\"Students\"", schema = "public")
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_student_person"))
public class Student extends Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "scholarship", columnDefinition = "boolean DEFAULT 'false'")
	private boolean scholarship = false;
	
	@Column(name = "state", columnDefinition = "integer DEFAULT '1'")
	private Integer state = 1;

	public boolean isScholarship() {
		return scholarship;
	}

	public void setScholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
