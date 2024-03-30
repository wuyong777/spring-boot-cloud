package com.walle.javaConcurrent;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("thread run");
        });
        thread.start();
    }
}
