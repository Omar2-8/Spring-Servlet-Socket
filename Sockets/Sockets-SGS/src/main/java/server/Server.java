package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static ExecutorService executorService;
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is on port " + 8080);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            executorService.execute(new ClientHandler(socket));
        }

    }

    public static void main(String[] args){

          executorService = Executors.newFixedThreadPool(10);
        try {
            new Server().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
