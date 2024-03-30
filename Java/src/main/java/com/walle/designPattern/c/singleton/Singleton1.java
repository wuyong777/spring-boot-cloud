package com.walle.designPattern.c.singleton;

/**
 * 饿汉式（静态成员变量初始化）：
 * 类加载时就初始化单例对象，线程安全
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}