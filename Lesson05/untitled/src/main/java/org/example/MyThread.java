package org.example;

public class MyThread extends Thread {


    @Override
    public void run() {
        System.out.println("Hello from MyThread: " + Thread.currentThread());

    }
}
