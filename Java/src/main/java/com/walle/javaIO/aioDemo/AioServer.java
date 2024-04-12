package com.walle.javaIO.aioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 异步IO（AIO）服务器示例类。
 * 主要用于演示如何使用AIO方式实现一个简单的服务器，能够接收客户端连接并发送消息。
 *
 * @Author wuyong
 * @Date 2024-04-04
 */
public class AioServer {
    public static void main(String[] args) throws Exception {
        // 创建异步通道组，指定线程池大小，用于处理IO事件
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withFixedThreadPool(10, Executors.defaultThreadFactory());
        // 创建异步服务器Socket通道，并绑定到指定端口
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(8888));
        System.out.println("=============AIO服务端启动=========");

        // 异步等待接收客户端连接请求
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            // 用于读取数据的ByteBuffer
            final ByteBuffer buffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel channel, Object attachment) {
                System.out.println("客户端连接成功");
                try {
                    buffer.clear();
                    // 异步读取客户端发送的数据
                    channel.read(buffer, null, new CompletionHandler<Integer, Object>() {
                        @Override
                        public void completed(Integer len, Object attachment) {
                            buffer.flip();
                            // 将读取到的数据转换为字符串
                            String message = new String(buffer.array(), 0, len);
                            System.out.println("收到客户端消息：" + message);

                            // 异步向客户端发送消息
                            channel.write(ByteBuffer.wrap(("你好，阿坤！").getBytes()), null, new CompletionHandler<Integer, Object>() {
                                @Override
                                public void completed(Integer result, Object attachment) {
                                    // 关闭通道的输出流
                                    try {
                                        channel.shutdownOutput();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void failed(Throwable exc, Object attachment) {
                                    exc.printStackTrace();
                                    // 关闭通道
                                    try {
                                        channel.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {
                            exc.printStackTrace();
                            // 关闭通道
                            try {
                                channel.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 继续等待下一个客户端连接
                server.accept(null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
                // 继续等待下一个客户端连接
                server.accept(null, this);
            }
        });
        // 等待异步通道组处理所有连接，直到程序被终止
        group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

}
