package org.example.seminar3;

public class Main {
    public static void main(String[] args) {
        /*
        Задача 1.
         */
        Calculator calculator = new Calculator();
        System.out.println(calculator.subtract(42, 10.5f));
        /*
        Задача 2.
         */
        ArrayComparator arrayComparator = new ArrayComparator();
        Integer[] array = {1, 2, 3};
        String[] arr = {"1", "2", "3"};
        System.out.println(arrayComparator.compareArrays(array, arr));
    }
}
