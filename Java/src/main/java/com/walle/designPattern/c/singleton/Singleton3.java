package com.walle.designPattern.c.singleton;

/**
 * 懒汉式（线程安全，同步方法）：
 * 在getInstance方法上加锁，确保线程安全，但每次获取实例都会同步，性能较低。
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}