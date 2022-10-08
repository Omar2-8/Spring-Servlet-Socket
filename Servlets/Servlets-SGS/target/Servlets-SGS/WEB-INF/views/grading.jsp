<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="model.*" %>

<html>
 <head>
 <body>

<div>
            <% List<StudentCourses> studentCourses = (List<StudentCourses>) request.getAttribute("studentCourses"); %>
                <table >
                    <thead>
                        <tr>
                            <th scope="col" >#                 </th>
                            <th></th><th></th>
                            <th scope="col" >Course Name       </th>
                            <th></th><th></th>
                            <th scope="col" >your Mark          </th>
                            <th></th><th></th>
                            <th scope="col" >statistics          </th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < studentCourses.size(); i++) { %>
                            <tr>
                                <th scope="row"><%= i+1 %> </th>
                                <td></td><td></td>
                                <td><%= studentCourses.get(i).getCourseName() %> </td>
                                <td></td><td></td>
                                <td><%= studentCourses.get(i).getMark() %>   </td>
                                <td></td><td></td>
                                <td>
                                    <form action="statistics" method="post">
                                        <input type="hidden" name="courseName" value="<%= studentCourses.get(i).getCourseName() %>">
                                        <button type="submit">Show statistics of the course</button>
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
        </div>
  </body>
 </head>
</html>