package ru.skypro;

public interface IntegerList {

    void generateRandomArray();
    int add(int number);
    int add(int index, int number);
    int set(int index, int number);
    int remove(int number);
    int removeByIndex(int index);
    boolean contains(int arr[], int number);
    int indexOf(int number);
    int lastIndexOf(int number);
    int get(int index);
    boolean equals(IntegerList otherList);
    int size();
    boolean isEmpty();
    void clear();
    int[] toArray();
    void print();

    int[] sortBubble(int[] listOfInt);
    int[] sortSelection(int[] listOfInt);
    int[] sortInsertion(int[] listOfInt);
}
