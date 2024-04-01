package com.walle.javaConcurrent.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 任务代码，可以有返回值
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在运行...");
        return "Callable任务已完成";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable = new CallableExample();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        // 获取Callable任务的结果
        String result = futureTask.get();
        System.out.println("任务结果：" + result);
    }
}