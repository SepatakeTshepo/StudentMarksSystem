package com.example.studentMarks.StudentRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentMarks.Entity.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer , Long > {

    Lecturer findByIdAndPin(Long id ,String pin );

    
}
