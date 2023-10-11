package org.example;

public class Main {
    private static class Box {
        private Object obj;

        public Box(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public void printInfo() {
            System.out.printf("Box (%s): %s\n",
                    obj.getClass().getSimpleName(), obj.toString());
        }
    }

    private static class GBox<T> {
        private T obj;

        public GBox(T obj) {
            this.obj = obj;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        public void printInfo() {
            System.out.printf("Box (%s): %s\n",
                    obj.getClass().getSimpleName(), obj.toString());
        }

        private static <T> void set(GBox<T> box, T value) {
            box.setObj(value);
        }
    }

    private static class BBox<T extends Number> {
        private T obj;

        public BBox(T obj) {
            this.obj = obj;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        public void printInfo() {
            System.out.printf("Box (%s): %s\n",
                    obj.getClass().getSimpleName(), obj.toString());
        }

        private static <T extends Number> void set(BBox<T> box, T value) {
            box.setObj(value);
        }
    }

    public class UBox<T> {
        <U> UBox(U u) {}
    }

    public static class TBox<T> {
        public static final TBox EMPTY_BOX = new TBox();
        private T value;

        public T getValue() {return value;}

        public void setValue(T value) {
            this.value = value;
        }
        static <T> TBox<T> emptyBox() {
            return (TBox<T>) EMPTY_BOX;
        }

        @Override public String toString() { return value.toString();}
    }

    private static class Animal {
        protected String name;
        protected Animal(String name) { this.name = name;}
        @Override
        public String toString() {
            return this.getClass().getSimpleName() + " with name " + name;
        }
    }

    private static class Cat extends Animal {
        protected Cat(String name) { super(name);}
    }
    private static class Dog extends Animal {
        protected Dog(String name) { super(name);}
    }

    private static void someMethod(Number n) {}

    public static <U> void addBox(U u, GBox<U> box) {}

    static void printInfo(TBox<? extends Animal> animalInBox) {
        System.out.println("Information about animal: " + animalInBox);
    }

    private static <T> void testErrorHelper(TBox<T> box) {
        box.setValue(box.getValue());
    }

    static void testError(TBox<?> box) {
        testErrorHelper(box);
    }

    public static void main(String[] args) {
//        Box b1 = new Box(20);
//        Box b2 = new Box(30);
//        System.out.println((Integer) b1.getObj() + (Integer) b2.getObj());
//
//        Box b3 = new Box("Hello, ");
//        Box b4 = new Box("World!");
//        System.out.println((String) b3.getObj() + (String) b4.getObj());
//
//        b1.printInfo();
//        b3.printInfo();

//        GBox<String> stringGBox = new GBox<>("Hello!");
//        stringGBox.printInfo();
//        GBox<Integer> integerGBox = new GBox<>(12);
//        integerGBox.printInfo();
//        GBox box = new GBox(1);
//        box.printInfo();
//        GBox.set(box, "Hop-hop-hop");
//        box.printInfo();
//
//        BBox<Integer> integerBBox = new BBox<>(123);
////        BBox<String> stringBBox = new BBox<String>("No");
//        someMethod(12);
//        someMethod(5.5);
//        BBox.set(new BBox<Integer>(15), 19);
//        TBox<String> tbox =TBox.emptyBox();
//
//        TBox<Cat> catInBox = TBox.emptyBox();
//        catInBox.setValue(new Cat("Vasya"));
//        printInfo(catInBox);
//
//        TBox<Dog> dogInBox = TBox.emptyBox();
//        dogInBox.setValue(new Dog("Kusaka"));
//        printInfo(dogInBox);

        Cat cat = new Cat("Vasya");
        Animal animal = cat;
        TBox<? extends Cat> catInBox = new TBox<>();
        TBox<? extends Animal> animalInBox = catInBox;
    }
}