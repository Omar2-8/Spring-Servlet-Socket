package com.example.omar.controllers;

import com.example.omar.data.Students;
import com.example.omar.models.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        if(request.getSession().getAttribute("email") != null){
            return "redirect:/grading";
        }
        return "login";
    }
    @PostMapping("/login")
    public String login(String email, String password, HttpServletRequest request){

        Student student=Students.getStudentByEmail(email);

        if(student != null && student.getPassword().equals(password)){
            request.getSession().setAttribute("email", email);
            return "redirect:/grading";
        }else {

        request.setAttribute("error", "Invalid email or password");
        return "redirect:/login";}

    }
}
