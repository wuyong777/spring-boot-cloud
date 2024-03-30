package com.walle.designPattern.c.singleton;

/**
 * 静态内部类：
 * 利用静态内部类的加载时机来实现懒加载和线程安全性。
 */
public class Singleton5 {
    private Singleton5() {}

    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}