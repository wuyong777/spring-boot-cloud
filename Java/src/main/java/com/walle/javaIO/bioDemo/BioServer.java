package com.walle.javaIO.bioDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO（同步阻塞IO）模式下的服务器端示例类。
 * @Author wuyong
 * @Date 2024-04-04
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocket对象，并绑定到8888端口
        ServerSocket server = new ServerSocket(8888);
        System.out.println("===========BIO服务端启动================");

        // 不断监听客户端连接，每个连接都创建一个新的线程处理
        while (true) {
            // 接受客户端的Socket连接
            Socket socket = server.accept();
            new BioServerThread(socket).start(); // 启动处理线程
        }

    }

    /**
     * 处理客户端请求的线程类。
     * 使用同步阻塞IO方式读取客户端消息并回复。
     */
    static class BioServerThread extends Thread {
        // 客户端的Socket连接
        private Socket socket;

        public BioServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // 读取客户端发送的消息
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String msg;
                while ((msg = bufferedReader.readLine()) != null) {
                    System.out.println("收到客户端消息：" + msg);
                }

                // 向客户端发送消息
                OutputStream outputStream = socket.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                printStream.println("你好，吊毛！");
                printStream.flush(); // 刷新输出流，确保消息被发送

                // 关闭Socket的输出流，表示服务端已发送完消息
                socket.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
