package com.example.studentMarks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.studentMarks.Entity.Lecturer;
import com.example.studentMarks.Entity.StudentDetails;
import com.example.studentMarks.StudentRepository.LecturerRepository;
import com.example.studentMarks.StudentRepository.studentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    private studentRepository studentRepo;

    @Autowired
    private LecturerRepository lecturerRepo;

    // --- LOGIN SECTION ---

    @GetMapping("/")
    public String showLoginPage() {
        return "login"; // Loads login.html
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam Long id, @RequestParam int pin , HttpSession session, Model model) {
      System.out.println("LOGIN ATTEMPT → id=" + id + ", pin=" + pin);
        Lecturer lecturer = lecturerRepo.findByIdAndPin(id, pin);

        
        if (lecturer != null) {
            session.setAttribute("lecturer", lecturer);
            return "redirect:/dashboard"; // Success! Go to dashboard
        } else {
            model.addAttribute("error","Invalid ID or PIN") ;
            return "login"; // Failed! Stay on login page
        }
    }

    // --- DASHBOARD SECTION ---

    @GetMapping("/dashboard")
    public String showDashboard(Model model, @RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("students", studentRepo.findByName(search.trim()));
        } else {
      model.addAttribute("students", studentRepo.findAll());
        }
        return "dashboard"; // Loads dashboard.html
    }
    // --- ADD STUDENT SECTION ---

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute StudentDetails student) {
        studentRepo.save(student);
        return "redirect:/dashboard";
    }

    // --- DELETE SECTION ---

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepo.deleteById(id);
        return "redirect:/dashboard";
    }
}