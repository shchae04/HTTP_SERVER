package com.example;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomServerSocket {


    private static final int PORT = 8080;
    private static final Logger logger = Logger.getLogger(CustomServerSocket.class.getName());

    public static void main(String[] args) {

        try {
            // logs 폴더가 존재하지 않으면 생성
            File logDir = new File("logs");
            if (!logDir.exists()) {
                logDir.mkdir();
            }

            FileHandler fileHandler = new FileHandler("logs/server.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);

            ServerSocket serverSocket = new ServerSocket(8080);
            logger.info("Socket Listening Port :" + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                logger.info("Client Connected :" + clientSocket.getInetAddress());

                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "SERVER ERROR", e);
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            //SYN
            String requestLine = reader.readLine();
            logger.info("Received request: " + requestLine);

            //ACK
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/html");
            writer.println();
            writer.println("<html><body><h1>Hello, Client!</h1></body></html>");

            //FIN
            reader.close();
            writer.close();
            clientSocket.close();
            logger.info("Client connection closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
