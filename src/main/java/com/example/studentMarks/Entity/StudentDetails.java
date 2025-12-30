package com.example.studentMarks.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;


@Entity
@Table(name = "student")
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

      @Column( name = "student_number",nullable = false,unique=true )
    private Long studentNumber;

       @Column(nullable = false )
    private String name ;

       @Column(nullable = false )
    private String course;

       @Column(nullable = false )
    private String module ;

       @Column(nullable = false )
    private double percentage ;


    public StudentDetails(){}

    public StudentDetails(Long studentNumber , String name , String Course , String module , double percentage){
        this.studentNumber = studentNumber;
        this.name = name ;
        this.course = course ;
        this.module = module ;
        this.percentage = percentage ;
    }
    
    public Long getId() {
        return id;
    }


    public void setStudentNumber (Long studentNumber ){this.studentNumber = studentNumber;}
    public Long getStudentNumber (){return studentNumber ;}


    public void setName (String name ){this.name=name ;}
    public String getName (){return name ;}

    public void setCourse (String course ){this.course = course ;}
    public String getCourse (){return course ;}

    public void setModule (String module ){this.module = module ;}
    public String getModule (){return module ;}

    public void setPercentage (double percentage){this.percentage = percentage ;}
    public double getPercentage (){return percentage ;}


    
}
