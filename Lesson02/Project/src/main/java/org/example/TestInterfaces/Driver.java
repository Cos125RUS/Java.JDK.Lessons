package org.example.TestInterfaces;

public class Driver {
    public void test() {
        Man man0 = new Man();
        Ox ox0 = new Ox();
        Human man1 = new Man();
        Bull ox2 = new Ox();
        Minotaurus minos = new Minotaurus();
        Bull[] allBulls = {ox2, ox0, minos};
        Human[] allHumans = {man1, man0, minos};

        for (Bull b : allBulls) {
            b.walk();
            b.talk();
        }
        System.out.println();
        for (Human h : allHumans) {
            h.walk();
            h.talk();
        }
    }
}
