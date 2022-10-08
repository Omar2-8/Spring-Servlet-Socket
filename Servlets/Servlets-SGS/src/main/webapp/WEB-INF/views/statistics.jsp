<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="model.*" %>


<html>
 <head>
 <body>
<div>
           <% List<Double> statistics = (List<Double>) request.getAttribute("statistics"); %>
                <table >
                    <thead>
                        <tr>
                            <th scope="col" >AVG              </th>
                            <th></th><th></th>
                            <th scope="col" >Median           </th>
                            <th></th><th></th>
                            <th scope="col" >Max               </th>
                            <th></th><th></th>
                            <th scope="col" >Min                 </th>
                        </tr>
                    </thead>
                    <tbody>
                    <tr>
                    <td><%= statistics.get(0) %>              </td>
                        <td></td><td></td>
                    <td><%= statistics.get(1) %>              </td>
                        <td></td><td></td>
                    <td><%= statistics.get(2) %>              </td>
                        <td></td><td></td>
                    <td><%= statistics.get(3) %>              </td>
                    </tr>
                    </tbody>
                </table>
        </div>
  </body>
 </head>
</html>

