package org.example;

import java.util.ArrayList;

public class Homework2 {
    public static class Fruit {
        private float weight;

        public Fruit(float weight) {
            this.weight = weight;
        }

        public Float getWeight() {
            return weight;
        }
    }
    public static class Apple extends Fruit {
        private static float weight = 1.0f;

        public Apple() {
            super(weight);
        }
    }
    public static class Orange extends Fruit {
        private static float weight = 1.5f;

        public Orange() {
            super(weight);
        }
    }

    public static class Box<T extends Fruit> {
        private ArrayList<T> list;
        private int count;

        public Box() {
            this.list = new ArrayList<>();
        }

        public void add(T item) {
            list.add(item);
            count++;
        }

        public Float getWeight() {
            if (count > 0)
                return count * list.get(0).getWeight();
            else
                return 0f;
        }

        public boolean compare(Box<? extends Fruit> box) {
            return getWeight().equals(box.getWeight());
        }

        public void pourOver (Box<T> box) {
            while (count > 0) {
                box.add(list.get(--count));
            }
        }
    }

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        for (int i = 0; i < 10; i++) {
            appleBox.add(new Apple());
            orangeBox.add(new Orange());
            orangeBox2.add(new Orange());
        }
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox2.getWeight());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(orangeBox.compare(orangeBox2));

        orangeBox.pourOver(orangeBox2);
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox2.getWeight());
    }
}
