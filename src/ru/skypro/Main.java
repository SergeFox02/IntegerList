package ru.skypro;

public class Main {

    public static void main(String[] args) {

        int size = 10;
        IntegerList integerList = new IntegerListImpl(size);

        for (int i = 0; i < size; i++) {
            integerList.add(generateRandom());
        }

        integerList.add(45);
        integerList.add(123);
        integerList.add(455);
        integerList.add(457);
        integerList.print();

        integerList.sortBubble(integerList.toArray());

        System.out.println("integerList.contains(45) = " + integerList.contains(45));
        System.out.println("integerList.contains(457) = " + integerList.contains(457));


    }

    public static int generateRandom() {
        return (int) (Math.random()*1000);
    }
}
