package org.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable{
    private int left, right;
    private AtomicInteger value;
    private CountDownLatch cdl;

    public Task(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public Task(int value) {
        this.value = new AtomicInteger(value);
    }

    public void inc() {
//        synchronized (Task.class) {
//            value++;
//        }
        value.incrementAndGet();
    }

    public int getValue() {
        return value.intValue();
    }

    @Override
    public void run() {
//        System.out.println(left + right);
        for (int i = 0; i < 10000000; i++) {
            inc();
        }
        cdl.countDown();
    }

    @Override
    public String toString() {
        return String.format("(%s+%s)", left, right);
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }
}
