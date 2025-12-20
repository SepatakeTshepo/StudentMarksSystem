package com.example.studentMarks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.studentMarks.Entity.StudentDetails;
import com.example.studentMarks.StudentRepository.studentRepository;

@Controller
@RequestMapping("/student")
public class MenuController {

     @Autowired
    private studentRepository studentRepo;

   @GetMapping("/Menu")
    public String menu(){

        return "Menu";
    }


    @GetMapping("/add")
    public String add (){

        return "Addstudent";
    }

     @PostMapping("/add")
    public String addStudent( StudentDetails student){

        studentRepo.save(student);
        return "redirect:/student/Menu";}

    @GetMapping("/search")
    public String search (){

        return "Search-Student";

    }

   @GetMapping("/search/result")
public String searchStudent(
        @RequestParam String type,
        @RequestParam String keyword,
        Model model) {

    StudentDetails student = null;

    if (type.equals("id")) {
        Long id = Long.parseLong(keyword);
        student = studentRepo.findById(id).orElse(null);

    } else if (type.equals("name")) {
        student = studentRepo.findByName(keyword);
    }

    model.addAttribute("student", student);
    return "Search-Student";
}



    @GetMapping("/edit")
    public String Edit (){

        return "Edit-Student";}

        @PostMapping("/edit")
        public String EditStudent(StudentDetails student){

            studentRepo.save(student);
            return "redirect:/student/Menu";}
    

   @GetMapping("/delete")
    public String Delete(){

        return "Delete-Student";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam Long Id ){

        studentRepo.deleteById(Id);
        return "redirect:/student/Menu";




    }
    




    
}
