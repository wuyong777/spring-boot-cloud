package com.walle.javaIO.nioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * NIO客户端示例。用于演示如何使用非阻塞I/O与服务器进行通信。
 * @Author wuyong
 * @Date 2024-04-04
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        // 创建SocketChannel并初始化连接地址
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        System.out.println("==============NIO客户端启动================");

        // 设置SocketChannel为非阻塞模式
        socketChannel.configureBlocking(false);

        // 准备发送的消息
        String hello="你好，靓仔！";
        ByteBuffer buffer = ByteBuffer.wrap(hello.getBytes());

        // 向服务器发送消息
        socketChannel.write(buffer);
        System.out.println("发送消息：" + hello);
        buffer.clear();

        // 注册Selector并设置监听读事件，为接收服务器响应做准备
        socketChannel.register(Selector.open(), SelectionKey.OP_READ, buffer);

        while (true) {
            // 从服务器读取数据
            if (socketChannel.read(buffer) > 0) {
                buffer.flip();
                // 处理接收到的数据
                String msg = new String(buffer.array(), 0, buffer.limit());
                System.out.println("收到服务端消息：" + msg);
                break; // 接收到消息后退出循环
            }
        }

        // 关闭SocketChannel的输入流，准备关闭连接
        socketChannel.shutdownInput();
        // 关闭SocketChannel
        socketChannel.close();
    }
}

