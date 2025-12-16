package com.example.studentMarks.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;



@Entity
@Table(name = "lecturer")
public class Lecturer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

   @Column(nullable = false)
    private int pin ;

    public Lecturer() {
        // Empty constructor required by JPA/Hibernate
    }

    public Lecturer(Long id, int pin ){

        this.id =id ;
        this.pin = pin;
    }
    public void setEmployeeId (Long id){this.id = id ;}
    public Long getEmployeeId (){return id ;}
    
    public void setEmployeePin (int pin){this.pin = pin ;}
    public int getEmployeePin (){return pin ;}


    
    
}
