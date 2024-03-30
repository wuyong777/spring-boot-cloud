package com.walle.designPattern.c.singleton;

/**
 * 枚举：
 * Java中利用枚举天然的线程安全性和单例特性实现单例模式
 */
public enum Singleton6 {
    INSTANCE;

    public static Singleton6 getInstance() {
        return INSTANCE;
    }
}