package com.walle.javaIO.aioDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 异步IO客户端示例类
 * 主要用于演示如何使用异步方式与服务器进行通信。
 *
 * @Author wuyong
 * @Date 2024-04-04
 */
public class AioClient {
    public static void main(String[] args) throws Exception {
        // 创建异步Socket通道
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();

        // 创建ByteBuffer
        final ByteBuffer buffer = ByteBuffer.wrap(("你好，靓仔！").getBytes());
        // 异步连接服务器
        client.connect(new InetSocketAddress("127.0.0.1", 8888), null, new CompletionHandler<Void, Object>() {
            // 当连接操作完成时调用此方法
            @Override
            public void completed(Void result, Object attachment) {
                // 异步发送消息给服务器
                client.write(buffer, null, new CompletionHandler<Integer, Object>() {

                    // 创建ByteBuffer
                    final ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                    // 当消息写入完成时调用此方法
                    @Override
                    public void completed(Integer result, Object attachment) {
                        // 准备读取服务器响应
                        readBuffer.clear();
                        // 异步读取数据
                        client.read(readBuffer, null, new CompletionHandler<Integer, Object>() {
                            // 当数据读取完成时调用此方法
                            @Override
                            public void completed(Integer result, Object attachment) {
                                // 处理接收到的数据
                                readBuffer.flip();
                                String msg = new String(readBuffer.array(), 0, result);
                                System.out.println("收到服务端消息：" + msg);
                            }

                            // 当读取操作失败时调用此方法
                            @Override
                            public void failed(Throwable exc, Object attachment) {
                                // 处理异常并关闭连接
                                exc.printStackTrace();
                                try {
                                    client.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }

                    // 当写操作失败时调用此方法
                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        // 处理异常并关闭连接
                        exc.printStackTrace();
                        try {
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            // 当连接操作失败时调用此方法
            @Override
            public void failed(Throwable exc, Object attachment) {
                // 处理异常并关闭连接
                exc.printStackTrace();
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        // 等待一段时间以确保连接操作完成
        Thread.sleep(1000);
        // 关闭输入流和Socket通道
        client.shutdownInput();
        client.close();
    }
}
