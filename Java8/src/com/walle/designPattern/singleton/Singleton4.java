package com.walle.designPattern.singleton;

/**
 * 双检锁/双重检查锁定（DCL，线程安全）：
 * 使用volatile关键字和双重检查机制，既保证线程安全又减小同步范围。
 */
public class Singleton4 {
    private volatile static Singleton4 instance;

    private Singleton4() {}

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}