package ru.skypro;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int size = 10;
        IntegerList integerList = new IntegerListImpl(size);

        for (int i = 0; i < size; i++) {
            integerList.add(generateRandom());
        }

        int[] arr1 = Arrays.copyOf(integerList.toArray(), integerList.toArray().length);
        int[] arr2 = Arrays.copyOf(integerList.toArray(), integerList.toArray().length);
        int[] arr3 = Arrays.copyOf(integerList.toArray(), integerList.toArray().length);

        System.out.println("Пузырьковый метод:");
        long start = System.currentTimeMillis();
        integerList.sortBubble(arr1);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Метод выбора:");
        start = System.currentTimeMillis();
        integerList.sortSelection(arr2);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Метод вставки:");
        start = System.currentTimeMillis();
        integerList.sortSelection(arr3);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("integerList.contains(arr1, 60) = " + integerList.contains(arr1, 60));
    }

    public static int generateRandom() {
        return (int) (Math.random()*1000);
    }
}
