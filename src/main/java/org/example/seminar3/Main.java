package org.example.seminar3;

public class Main {
    public static void main(String[] args) {
        /*
        Задача 1.
         */
        Calculator calculator = new Calculator();
        System.out.println(calculator.subtract(42, 10.5f));//31.5
        /*
        Задача 2.
         */
        ArrayComparator arrayComparator = new ArrayComparator();
        Integer[] array1 = {1, 2, 3};
        String[] array2 = {"1", "2", "3"};
        Integer[] array3 = {8, 11, 4};
        System.out.println(arrayComparator.compareArrays(array1, array3)); // true
        System.out.println(arrayComparator.compareArrays(array1, array2)); // false

        /*
        Задача 3
         */
        Pair pair = new Pair("Good", "Morning");
        System.out.println(pair.getFirst()); //Good
        System.out.println(pair.getSecond()); //Morning
        System.out.println(pair.toString()); //Good Morning
    }
}
