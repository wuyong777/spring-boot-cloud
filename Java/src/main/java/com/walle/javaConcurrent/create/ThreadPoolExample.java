package com.walle.javaConcurrent.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample implements Runnable {
    @Override
    public void run() {
        // 任务代码
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行...");
    }

    public static void main(String[] args) {
        // 创建固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 提交任务
        for (int i = 0; i < 5; i++) {
            executorService.submit(new ThreadPoolExample());
        }

        // 关闭线程池
        executorService.shutdown();
    }
}