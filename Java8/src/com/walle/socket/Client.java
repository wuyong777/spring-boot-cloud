package com.walle.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            String serverResponse;

            while (true) {
                // 发送消息
                System.out.print("Client: ");
                userInput = consoleInput.readLine();
                out.println(userInput);

                if (userInput.equalsIgnoreCase("bye")) {
                    System.out.println("You have disconnected.");
                    out.println("Client is offline.");
                    break;
                }

                // 接收服务端回复
                if ((serverResponse = in.readLine()) != null) {
                    System.out.println("Server: " + serverResponse);
                    if (serverResponse.equalsIgnoreCase("Server is offline.")) {
                        System.out.println("Server has disconnected.");
                        break;
                    }
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}