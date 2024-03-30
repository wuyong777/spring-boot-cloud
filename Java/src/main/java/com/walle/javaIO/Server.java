package com.walle.javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server started. Waiting for client to connect...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;
            String outputLine;

            while (true) {
                // 接收客户端消息
                if ((inputLine = in.readLine()) != null) {
                    System.out.println("Client: " + inputLine);
                    if (inputLine.equalsIgnoreCase("bye")) {
                        System.out.println("Client has disconnected.");
                        break;
                    }
                }

                // 发送回复消息
                System.out.print("Server: ");
                outputLine = consoleInput.readLine();
                out.println(outputLine);

                if (outputLine.equalsIgnoreCase("bye")) {
                    out.println("Server is offline.");
                    break;
                }
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}