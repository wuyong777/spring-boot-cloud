package com.walle.javaConcurrent.deadLock;

public class DeadLock {

    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "线程 持有锁a，试图获取锁b");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "线程 获取锁b");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "线程 持有锁b，试图获取锁b");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "线程 获取锁a");
                }
            }
        }, "B").start();
    }

}
// A线程 持有锁a，试图获取锁b
// B线程 持有锁b，试图获取锁b
