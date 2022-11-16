package models;

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
    
    @Column(name = "schoolarship", columnDefinition = "boolean DEFAULT 'false'")
    private Boolean schoolarship = false;
    
    @Column(name = "state", columnDefinition = "integer DEFAULT '1'")
    private Integer state = 1;

    public Boolean getSchoolarship() {
        return schoolarship;
    }

    public void setSchoolarship(Boolean schoolarship) {
        this.schoolarship = schoolarship;
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