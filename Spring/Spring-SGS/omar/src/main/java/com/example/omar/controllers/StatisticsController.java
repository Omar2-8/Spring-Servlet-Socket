package com.example.omar.controllers;

import com.example.omar.data.StudentCoursesData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class StatisticsController {

    @PostMapping("/statistics")
    public String statistics(String courseName, Model model, HttpServletRequest request){

        String email = request.getSession().getAttribute("email").toString();

        if(email == null || courseName == null){
            return "redirect:/login";
        }

        List<Double> statistics = StudentCoursesData.getStatistics(courseName);

        model.addAttribute("statistics", statistics);

        return "statistics";
    }

}
