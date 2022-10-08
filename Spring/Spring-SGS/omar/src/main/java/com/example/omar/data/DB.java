package com.example.omar.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DB {

    private static DB instance;
    private static Connection connection;

    public DB() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");
            String url = "jdbc:mysql://localhost:3306/school";
            String username = "root";
            String password = "omar";
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection() throws SQLException{
        if (instance == null){
            instance = new DB();
        }else if(connection.isClosed()){
            instance = new DB();
        }
        return connection;
    }
}
