package com.example.studentMarks.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;


@Entity
@Table(name = "StudentMarks")
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


       @Column(nullable = false ,length = 50)
    private String name ;

       @Column(nullable = false ,length = 50)
    private String course;

       @Column(nullable = false ,length = 50)
    private String module ;

       @Column(nullable = false ,length = 50)
    private double percentage ;


    public StudentDetails(){}

    public StudentDetails(String name , String Course , String module , double percentage){

        this.name = name ;
        this.course = course ;
        this.module = module ;
        this.percentage = percentage ;
    }

    public void setName (String name ){this.name=name ;}
    public String getName (){return name ;}

    public void setCourse (String course ){this.course = course ;}
    public String getCourse (){return course ;}

    public void setModule (String Module ){this.module = module ;}
    public String getModule (){return module ;}

    public void setPercentage (double percentage){this.percentage = percentage ;}
    public double getPercentage (){return percentage ;}


    
}
