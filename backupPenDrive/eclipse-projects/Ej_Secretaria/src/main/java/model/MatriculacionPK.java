package model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the MATRICULACION database table.
 * 
 */
@Embeddable
public class MatriculacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String dni;

	@Column(name="COD_ASIGNATURA", insertable=false, updatable=false)
	private String codAsignatura;

	public MatriculacionPK() {
	}
	
	public String getDni() {
		return this.dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCodAsignatura() {
		return this.codAsignatura;
	}
	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MatriculacionPK)) {
			return false;
		}
		MatriculacionPK castOther = (MatriculacionPK)other;
		return 
			this.dni.equals(castOther.dni)
			&& this.codAsignatura.equals(castOther.codAsignatura);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.dni.hashCode();
		hash = hash * prime + this.codAsignatura.hashCode();
		
		return hash;
	}
}