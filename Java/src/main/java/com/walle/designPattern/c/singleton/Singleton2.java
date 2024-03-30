package com.walle.designPattern.c.singleton;

/**
 * 懒汉式（线程不安全）：
 * 第一次调用getInstance方法时才创建对象，但非线程安全。
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}