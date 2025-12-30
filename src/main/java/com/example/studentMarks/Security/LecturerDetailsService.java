package com.example.studentMarks.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.studentMarks.Entity.Lecturer;
import com.example.studentMarks.StudentRepository.LecturerRepository;

@Service
public class LecturerDetailsService implements UserDetailsService{
    
    @Autowired
    public LecturerRepository lectuerRepo;

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{

        Lecturer lecturer = lectuerRepo.findByUsername(username);

        if (lecturer == null ){

            throw new UsernameNotFoundException("User not Found");
        }

        return new LecturerDetails(lecturer);


    }
}
