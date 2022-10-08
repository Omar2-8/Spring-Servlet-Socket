package servlets;


import data.StudentCoursesData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentCourses;

import java.io.IOException;
import java.util.List;

@WebServlet("/grading")
public class GradingServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getSession().getAttribute("email"));System.out.println("test1");
        if(request.getSession().getAttribute("email") == null){
            response.sendRedirect("login");
            return;
        }

        List<StudentCourses> studentCourses =
                StudentCoursesData.getStudentCourses((String) request.getSession().getAttribute("email"));


        request.setAttribute("studentCourses", studentCourses);
        request.getRequestDispatcher("/WEB-INF/views/grading.jsp").forward(request, response);
    }

}
