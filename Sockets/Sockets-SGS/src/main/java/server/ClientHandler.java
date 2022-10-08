package server;

import server.model.Student;
import server.model.StudentCourses;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler implements Runnable,Serializable{

    private final Socket clientSocket;
    private final PrintWriter out;
    private final BufferedReader in;
    private final ObjectOutputStream objectOutputStream;
    private Student student;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;

        this.out = new PrintWriter(clientSocket.getOutputStream());
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

    }

    private void login() throws IOException {
        try{
            out.println("Enter your Email and Password:");
            out.flush();
            String email = in.readLine();
            System.out.println(email);
            out.println("Enter your Password:");
            out.flush();
            String password = in.readLine();
            out.flush();

            student = Students.getStudentByEmail(email);
            if(!student.getPassword().equals(password)){
                throw new Exception("Wrong Password");
            }if(student==null){
                throw new Exception("Wrong Email or it does not exist");
            }

        }catch (Exception ignored){}



    }
    @Override
    public void run() {
        try {
            login();
        }catch (Exception e) {
            out.println("Invalid login please try again");
            out.flush();
            try {
                clientSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        out.println("You're Logged in Welcome :)");

        out.println("Your courses and their marks are: ");
        out.flush();

        List<StudentCourses> studentCoursesList = StudentCoursesData.getStudentCourses(student.getEmail());
        for(int i = 0 ; i<studentCoursesList.size() ; i++){
           out.println(i+1 + " | " + studentCoursesList.get(i).getCourseName() +" | "+studentCoursesList.get(i).getMark());
        }


        out.println("Type the course Name to see the the statistics: ");
        out.flush();
        String courseName=null;
        try {
            courseName= in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        List<Double> statics = new ArrayList<Double>
                (StudentCoursesData.getStatistics(courseName));
        out.println("the class course statistics are: ");out.flush();
        out.println("the AVG of the marks in the course is "+ statics.get(0));out.flush();
        out.println("the Median of the marks in the course is "+ statics.get(1));out.flush();
        out.println("the Maximum mark of the course is "+ statics.get(2));out.flush();
        out.println("the Minimum mark of the course is "+ statics.get(3));out.flush();


    }
}
