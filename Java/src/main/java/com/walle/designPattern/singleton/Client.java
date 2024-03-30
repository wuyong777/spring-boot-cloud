package com.walle.designPattern.singleton;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                Singleton1 instance = Singleton1.getInstance();
                System.out.println(instance);
            }).start();
            }
        }
    }

