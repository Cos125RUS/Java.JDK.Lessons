package org.example;

public class Homework1 {

    private static <T> void change(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        change(arr, 1,4);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
