package com.walle.javaConcurrent.produceAndconsume;

public class Demo1 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                resource.produce();
            }
        }, "Producer").start(); // 给生产者线程命名便于识别输出


        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                resource.consume();
            }
        }, "Consumer").start(); // 给消费者线程命名便于识别输出
    }

    static class Resource {
        private int num = 0;
        
        // 生产者方法
        public synchronized void produce() {
            try {
                    if (num > 0) { // 这里需要用while-->当线程数量比较多的时候，notifyAll可能会导致虚假唤醒，因此这里的判断必须用while，而非if）

                        this.wait(); // 如果库存大于0，则生产者等待
                    } else {
                        num++; // 库存不满则生产
                        System.out.println(Thread.currentThread().getName() + " -----current number: " + num);
                        this.notifyAll(); // 增加库存后通知所有等待的线程
                    }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // 消费者方法
        public synchronized void consume() {
            try {
                    if (num == 0) { // 这里需要用while-->当线程数量比较多的时候，notifyAll可能会导致虚假唤醒，因此这里的判断必须用while，而非if）
                        this.wait(); // 如果库存为空，则消费者等待
                    } else {
                        num--; // 库存不为空则消费
                        System.out.println(Thread.currentThread().getName() + " -----current number: " + num);
                        this.notifyAll(); // 消费后通知所有等待的线程
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}