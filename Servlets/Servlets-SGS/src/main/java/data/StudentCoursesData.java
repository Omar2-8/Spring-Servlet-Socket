package data;

import model.StudentCourses;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentCoursesData implements Serializable {


    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        StudentCoursesData.connection = connection;
    }

    public StudentCoursesData() {
        try {
            connection= DB.getConnection();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static List<StudentCourses> getStudentCourses(String email) {
        List<StudentCourses> studentCourse = new ArrayList<>();
        try{
            connection= DB.getConnection();
            PreparedStatement statement = connection.prepareStatement
                    ("select * from studentCourses where studentEmail = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                studentCourse.add(
                        new StudentCourses(
                        resultSet.getString("courseName"),
                        resultSet.getString("studentEmail"),
                        resultSet.getInt("mark")
                        ));
            }
            return studentCourse;
        }catch (Exception e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static List<Double> getStatistics(String courseName){
        List<Double> statics = new ArrayList<Double>();
        double median;
        try{
            PreparedStatement statement = connection.prepareStatement
                    ("select AVG(mark),COUNT(mark),MAX(mark),MIN(mark) from studentCourses where courseName = ?");
            statement.setString(1, courseName);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
            statics.add(resultSet.getDouble(1));
            double count=resultSet.getDouble(2);
            if(count%2 == 0 ){
                median=((count/2) + (count/2 -1))/2;
            }else{
                median=count/2;
            }
            statics.add(median);
            statics.add(resultSet.getDouble(3));
            statics.add(resultSet.getDouble(4));
            }
                return statics;
        }catch (Exception e){
            e.printStackTrace();
            return statics;
        }
    }



}
