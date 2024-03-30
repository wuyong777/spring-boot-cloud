package com.walle.designPattern.c.singleton;

/**
 * Author: wuyong
 * Date: 2024-03-30
 */
public class Client {
    public static void main(String[] args) {
        //test1();
        test2();
        //test3();
        //test4();
        //test5();
        //test6();
    }

    public static void test1() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton1 instance = Singleton1.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }

    public static void test2() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton2 instance = Singleton2.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }

    public static void test3() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton3 instance = Singleton3.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }

    public static void test4() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton4 instance = Singleton4.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }

    public static void test5() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton5 instance = Singleton5.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }

    public static void test6() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Singleton6 instance = Singleton6.getInstance();
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}

