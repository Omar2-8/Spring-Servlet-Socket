package com.example.omar.data;



import com.example.omar.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Students {

    private static Connection connection;

    public Students() {
        try {
            connection= DB.getConnection();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static Student getStudentByEmail(String email){
        try{
            connection= DB.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("select * from student where email =?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() ? new Student(
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")

            ):null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudents(){

        try {
            List<Student> students = new ArrayList<Student>();
            PreparedStatement statement = connection.prepareStatement
                    ("select * from student");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                students.add(new Student(
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password")
                ));

            }
            return students;

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Check the Table");
        }
    }
}
