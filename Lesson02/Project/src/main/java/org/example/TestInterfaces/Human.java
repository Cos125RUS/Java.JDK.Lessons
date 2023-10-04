package org.example.TestInterfaces;

public interface Human {
    default void walk() {
        System.out.println("Walks in two feet");
    }
    void talk();
}
