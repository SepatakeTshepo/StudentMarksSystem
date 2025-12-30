package com.example.studentMarks.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;



@Entity
@Table(name = "lecturer")
public class Lecturer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @Column(nullable = false , unique = true)
    private String username ;

    @Column(nullable = false)
    private String password ;

    private String role ;

    public Lecturer() {
        // Empty constructor required by JPA/Hibernate
    }

    public Lecturer(String username , String password , String role){

        this.username =username ;
        this.password = password;
        this.role = role;
    }
    public void setEmployeeUsername(String username){this.username = username;}
    public String getEmployeeUsername (){return username;}
    
    public void setEmployeePassword (String password){this.password= password;}
    public String getEmployeePassword (){return password ;}

     public void setEmployeeRole (String role){this.role= role;}
    public String getEmployeeRole (){return role;}


    
    
}
