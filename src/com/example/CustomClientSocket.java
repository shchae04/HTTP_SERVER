package com.example;

import java.io.*;
import java.net.Socket;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CustomClientSocket {

    private static final Logger logger = Logger.getLogger(CustomClientSocket.class.getName());

    public static void main(String[] args) {
        try {
            // logs 폴더가 존재하지 않으면 생성
            File logDir = new File("logs");
            if (!logDir.exists()) {
                logDir.mkdir();
            }

            // FileHandler 설정
            FileHandler fileHandler = new FileHandler("logs/client.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);

            // SYN - 서버 연결 요청
            Socket socket = new Socket("localhost", 8080);
            logger.info("Connected to the server");

            // Stream 설정
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            // HTTP Request 전송
            writer.println("GET / HTTP/1.1");
            writer.println("Host: localhost");
            writer.println();

            // 서버 응답 읽기
            String response;
            while ((response = reader.readLine()) != null) {
                logger.info("Received response: " + response);
            }

            // FIN - 연결 종료
            writer.close();
            reader.close();
            socket.close();
            logger.info("Connection closed");

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Client error", e);
        }
    }
}
