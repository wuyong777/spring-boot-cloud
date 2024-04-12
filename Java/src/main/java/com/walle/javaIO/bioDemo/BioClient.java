package com.walle.javaIO.bioDemo;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

/**
 * BIO（同步阻塞IO）模式的客户端示例类。
 * 该类用于创建一个简单的客户端，它会连接到服务器，发送一个消息，然后接收并打印服务器的响应。
 *
 * @Author wuyong
 * @Date 2024-04-04
 */
public class BioClient {
    public static void main(String[] args) throws IOException {
        List<String> names = Arrays.asList("帅哥", "靓仔", "坤坤");
        // 循环创建多个客户端连接，每个连接发送不同的问候消息
        for (String name : names) {
            // 创建Socket对象并连接到服务器
            Socket socket = new Socket("127.0.0.1", 8888);
            System.out.println("===========BIO客户端启动================");

            // 获取Socket的输出流，用于向服务器发送数据
            OutputStream outputStream = socket.getOutputStream();
            // 构建要发送的消息，并将其转换为字节流发送给服务器
            String hello = "你好，" + name + "!";
            outputStream.write(hello.getBytes());

            // 清空输出流并关闭Socket的输出功能，准备读取输入流
            outputStream.flush();
            socket.shutdownOutput();

            // 获取Socket的输入流，用于读取服务器返回的数据
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            // 读取并打印服务器发送的消息
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println("收到服务端消息：" + msg);
            }

            // 关闭输入流、输出流和Socket
            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
