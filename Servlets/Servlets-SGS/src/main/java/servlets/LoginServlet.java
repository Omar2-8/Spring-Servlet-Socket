package servlets;

import data.Students;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;


import java.io.IOException;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet {


     private Student student;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email + " " + password);
        student = Students.getStudentByEmail(email);

        if( student!= null && student.getPassword().equals(password)){
            request.getSession().setAttribute("email", email);
            response.sendRedirect("grading");
        }else{
            request.setAttribute("errorMessage",  "Invalid email or password");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(request, response);
        }
    }
}
