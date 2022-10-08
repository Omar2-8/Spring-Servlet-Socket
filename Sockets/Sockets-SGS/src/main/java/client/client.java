package client;

import server.model.StudentCourses;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class client  implements Serializable{

    public static void main(String[] args){

        try{
             client.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void start() throws IOException, ClassNotFoundException {
        Socket serverSocket = new Socket("localhost", 8080);
        System.out.println("Connected to server at localhost:8080");

        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream objectInputStream = new ObjectInputStream(serverSocket.getInputStream());

        String serverMessage = in.readLine();
        System.out.println(serverMessage);

        String email = keyboard.readLine();
        out.println(email);
        String response = in.readLine();
        String password = keyboard.readLine();
        out.println(password);

         response = in.readLine();

        System.out.println(response);
        if(response.equals("Invalid login please try again")){
            serverSocket.close();
            return;
        }
        System.out.println(in.readLine());


        for(int i = 0 ; i<5 ; i++){
            System.out.println(in.readLine());
        }

        System.out.println(in.readLine());


        String input = keyboard.readLine();


        out.println(input);



        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        System.out.println(in.readLine());


        serverSocket.close();

    }
}
