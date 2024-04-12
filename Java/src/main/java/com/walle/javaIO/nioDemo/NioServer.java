package com.walle.javaIO.nioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO服务器示例，用于演示非阻塞I/O的服务器端实现。
 * @Author wuyong
 * @Date 2024-04-04
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        // 初始化选择器
        Selector selector = Selector.open();
        // 打开服务端套接字通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        // 设置非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 注册选择器，监听连接请求
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("===========NIO服务端启动============");

        while (true) {
            // 超时等待客户端连接，避免无限阻塞
            if (selector.select(1000) == 0) {
                System.out.println("===========NIO服务端超时等待============");
                continue;
            }

            // 处理就绪的客户端连接请求
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                // 处理连接请求
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
                    socketChannel.configureBlocking(false);
                    // 注册读事件，准备读取客户端数据
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("成功连接客户端");
                }

                // 处理读事件，读取客户端数据
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    try {
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        if (buffer == null) {
                            buffer = ByteBuffer.allocate(1024);
                            key.attach(buffer);
                        }
                        buffer.clear();
                        int len = socketChannel.read(buffer);
                        if (len > 0) {
                            buffer.flip();
                            String message = new String(buffer.array(), 0, len);
                            System.out.println("收到客户端消息：" + message);
                        } else if (len < 0) {
                            // 关闭连接
                            key.cancel();
                            socketChannel.close();
                            continue;
                        }
                        // 准备写事件，向客户端发送消息
                        socketChannel.register(selector, SelectionKey.OP_WRITE, buffer);
                    } catch (IOException e) {
                        // 异常处理：关闭连接
                        key.cancel();
                        socketChannel.close();
                    }
                }

                // 处理写事件，向客户端发送消息
                if (key.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    String hello = "你好，坤坤！";
                    buffer.clear();
                    buffer.put(hello.getBytes());
                    buffer.flip();
                    socketChannel.write(buffer);
                    buffer.clear();
                    System.out.println("向客户端发送消息：" + hello);
                    // 准备读事件，等待客户端的下一次消息
                    socketChannel.register(selector, SelectionKey.OP_READ, buffer);
                }

                // 移除已处理的SelectionKey
                iterator.remove();
            }
        }

    }
}

