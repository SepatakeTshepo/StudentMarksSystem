package com.example.studentMarks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

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

           System.out.println("Student Number = " + student.getStudentNumber());
        
        studentRepo.save(student);
        return "redirect:/student/Menu";}

    @GetMapping("/searchStudent")
    public String search (){

        return "searchStudent";

    }
@GetMapping("/search")
public String searchStudent(
        @RequestParam(required = false) String studentNumber ,
        @RequestParam(required = false) String name,
        Model model) {

    StudentDetails student = null;

    if (studentNumber != null && !studentNumber.isEmpty()) {
        try {
            Long number = Long.parseLong(studentNumber);
            student = studentRepo.findByStudentNumber(number);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid studentNumber format");
           
        }

    } else if (name != null && !name.isEmpty()) {
        student = studentRepo.findByName(name);
    }

    model.addAttribute("student", student);
    return "searchStudent";
}

@GetMapping ("/list")
public String list (Model model){

     model.addAttribute("students", studentRepo.findAll());
    return "list-students";
}


@GetMapping("/edit/{id}")
public String EditStudent(@PathVariable Long id , Model model){

    StudentDetails student =
            studentRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Student not found"));

    model.addAttribute("student" , student);

    return "editStudent";
}



        @PostMapping("/updateStudent")
        public String EditStudent(@ModelAttribute StudentDetails student){

            studentRepo.save(student);
            return "redirect:/student/list";}
    

   @GetMapping("/delete/{id}")
    public String Delete(@PathVariable Long id){

        studentRepo.deleteById(id);

        return "redirect/student/list";
    }


@GetMapping("/view")
public String viewStudents(Model model) {
    model.addAttribute("students", studentRepo.findAll());
    return "listStudent"; 
}

    
    




    
}
