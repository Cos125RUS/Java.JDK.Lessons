package org.example.TestInterfaces;

public class Man implements Human {
    @Override
    public void walk() {
        System.out.println("Walks in two feet");
    }

    @Override
    public void talk() {
        System.out.println("Talks meaningful worlds");

    }
}
