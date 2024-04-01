package com.walle.javaConcurrent.state;

/**
 * State枚举定义了线程可能处于的不同状态。
 */
public enum State {

        // 线程新建状态
        NEW,

        // 线程可运行状态
        //i. 就绪状态（READY）: 线程已经调用了 start() 方法，且线程调度器随时可以将其分配给CPU进行执行。线程在就绪队列中等待，一旦得到CPU时间片，它就转为运行状态。
        //ii. 运行状态（RUNNING）: 线程正在执行其 run() 方法。
        // 需要注意的是，从Java的角度看，RUNNABLE状态包括了READY和RUNNING两种实际的操作系统状态。
        RUNNABLE,

        // 线程被阻塞，通常是因为同步锁
        BLOCKED,

        // 线程正在等待，没有指定的等待时间
        WAITING,

        // 线程正在定时等待，有一个指定的等待时间
        TIMED_WAITING,

        // 线程已经终止
        TERMINATED;
    }
