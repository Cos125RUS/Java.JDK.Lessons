package org.example.TestInterfaces;

public class Ox implements Bull{
    @Override
    public void walk() {
        System.out.println("Walks hooves");

    }

    @Override
    public void talk() {
        System.out.println("MoooOoooOooOOOooo");

    }
}
