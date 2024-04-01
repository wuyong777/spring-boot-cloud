package com.walle.javaConcurrent.ticket;

public class TicketOfficeSynchronized {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "SallerA"); // 给线程命名
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "SallerB"); // 给线程命名
        thread2.start();

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "SallerC"); // 给线程命名
        thread3.start();
    }
    static class Ticket {
        private int remaining = 100;
        public synchronized void sale() {
            if (remaining > 0) {
                System.out.println(Thread.currentThread().getName() + " sale " + remaining-- + " ticket with sync");
            }
        }
    }
}

