package com.example.studentMarks.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;



@Entity
@Table(name = "studentMarks_db")
public class Lecturer{

    @Id
    private Long id ;

    @Column(nullable = false ,length = 50)
    private int pin ;

    public Lecturer() {
        // Empty constructor required by JPA/Hibernate
    }

    public Lecturer( int pin ){

       
        this.pin = pin;
    
    }
    

    public void setEmployeePin (int pin){this.pin = pin ;}
    public int getEmployeePin (){return pin ;}


    
    
}
