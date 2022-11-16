package model;

import java.io.*;
import javax.persistence.*;

@Entity (name = "Student")
@Table (name = "\"Students\"", schema = "public")
@PrimaryKeyJoinColumn (name = "id", foreignKey = @ForeignKey (name = "fk_student_person"))
public class Student extends Person implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column (name = "schoolarship", columnDefinition = "boolean DEFAULT 'false'")
    private Boolean schoolarship = false;
    
    // State = 1: Inscrito; 2: Retirado; 3: Graduado; etc.
    @Column (name = "state", columnDefinition = "integer DEFAULT '1'")
    private Integer state = 1;

    public Boolean getSchoolarship () {
        
        return schoolarship;
        
    }

    public void setSchoolarship (Boolean schoolarship) {
        
        this.schoolarship = schoolarship;
        
    }

    public Integer getState () {
        
        return state;
        
    }

    public void setState (Integer state) {
        
        this.state = state;
        
    }

    public static long getSerialversionuid () {
        
        return serialVersionUID;
        
    }
    
}
