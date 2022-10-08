package servlets;

import data.StudentCoursesData;
import data.Students;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/statistics")
public class StatisticsServlet  extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("email");
        String courseName = request.getParameter("courseName");
        if(email == null || courseName == null){
            response.sendRedirect("/login");
            return;
        }

        List<Double> statistics = StudentCoursesData.getStatistics(courseName);
        request.setAttribute("statistics", statistics);
        request.setAttribute("courseName", courseName);
        request.getRequestDispatcher("/WEB-INF/views/statistics.jsp").forward(request, response);
    }
}
