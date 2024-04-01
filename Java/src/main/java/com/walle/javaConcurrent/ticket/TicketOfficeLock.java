package com.walle.javaConcurrent.ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketOfficeLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "SallerD"); // 给线程命名
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "SallerE"); // 给线程命名
        thread2.start();

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "SallerF"); // 给线程命名
        thread3.start();
    }

    static class Ticket {
        private int remaining = 100;
        Lock lock = new ReentrantLock();

        public void sale() {
            lock.lock();
            try {
                if (remaining > 0) {
                    System.out.println(Thread.currentThread().getName() + " sale " + remaining-- + " ticket with lock");
                }
            } finally {
                lock.unlock();
            }
        }
    }

}
