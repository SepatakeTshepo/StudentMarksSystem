package com.example.studentMarks.Security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.studentMarks.Entity.Lecturer;

public class LecturerDetails implements UserDetails{

    private Lecturer lecturer ;

    public LecturerDetails (Lecturer lecturer){

        this.lecturer = lecturer;

    }

    @Override
    public Collection <? extends GrantedAuthority>getAuthorities(){

        return List.of(new SimpleGrantedAuthority(lecturer.getEmployeeRole()));
    }
    
    @Override
    public String getPassword (){

        return lecturer.getEmployeePassword();
    }

    @Override
    public String getUsername(){

        return lecturer.getEmployeePassword();
    }

    @Override
    public boolean isAccountNonExpired(){ return true ;}

    @Override
    public boolean isAccountNonLocked (){return true ;}

    @Override
    public boolean isCredentialsNonExpired(){return true ;}

    @Override
    public boolean isEnabled (){return true ;}
}
