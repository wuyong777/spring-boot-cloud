package com.walle.javaConcurrent.create;

public class RunnableExample implements Runnable {
    @Override
    public void run() {
        // 任务代码
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行...");
    }

    public static void main(String[] args) {
        Runnable task = new RunnableExample();
        Thread thread = new Thread(task);
        thread.start();
    }
}