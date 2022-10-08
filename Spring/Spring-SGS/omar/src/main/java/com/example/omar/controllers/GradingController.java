package com.example.omar.controllers;

import com.example.omar.data.StudentCoursesData;
import com.example.omar.models.StudentCourses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class GradingController {

    @GetMapping("/grading")
    public String home(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("email") == null){
            return "redirect:/login";
        }

        List<StudentCourses> studentCourses =
                StudentCoursesData.getStudentCourses(
                        request.getSession().getAttribute("email").toString());

        model.addAttribute("studentCourses", studentCourses);


        return "grading";
    }

}
