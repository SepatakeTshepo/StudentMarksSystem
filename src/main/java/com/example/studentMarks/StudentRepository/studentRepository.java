package com.example.studentMarks.StudentRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentMarks.Entity.StudentDetails;

import java.util.List;

public interface studentRepository extends JpaRepository<StudentDetails , Long >{

   

    StudentDetails findByName (String name) ;
    StudentDetails findById (int Id);

    
}
