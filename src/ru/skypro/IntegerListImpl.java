package ru.skypro;

import ru.skypro.exception.ArrayIndexOutOfBoundsException;
import ru.skypro.exception.ArrayIsFullException;
import ru.skypro.exception.NotFoundException;
import ru.skypro.exception.NullPointerException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{

    private final Integer[] integerList;
    private int size;

    public IntegerListImpl(int size) {
        this.integerList = new Integer[size];
    }

    @Override
    public void generateRandomArray() {
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < size; i++) {
            int temp = random.nextInt(100_000) + 100_000;
            add(i, temp);
        }
    }


    private void shift(int index) {
        for (int i = index; i < size - 1; i++) {
            integerList[index] = integerList[i + 1];
            index++;
        }
        integerList[size - 1] = null;
        size--;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(integerList[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    @Override
    public int add(int number) {
        if(size >= integerList.length) {
            throw new ArrayIsFullException("ArrayIsFullException: Array is full!");
        }
        integerList[size++] = number;
        return number;
    }

    @Override
    public int add(int index, int number) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException index = " + index + " not exist!");
        }
        if(size >= integerList.length) {
            throw new ArrayIsFullException("ArrayIsFullException: Array is full!");
        }
        size++;
        for (int i = size - 1; i > index; i--) {
            integerList[i] = integerList[i - 1];
        }
        integerList[index] = number;
        return number;
    }

    @Override
    public int set(int index, int number) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException index =  " + index + " not exist!");
        }
        this.integerList[index] = number;
        return number;
    }

    @Override
    public int remove(int number) {
        for (int i = 0; i < size; i++) {
            if (integerList[i].equals(number)) {
                integerList[i] = null;
                shift(i);
                return number;
            }
        }
        throw new NotFoundException("NotFoundException: item " + number + " not found");
    }

    @Override
    public int removeByIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException index = " + index + " not exist!");
        }
        int removeNumber = integerList[index];
        integerList[index] = null;
        shift(index);
        return removeNumber;
    }

    @Override
    public boolean contains(int[] arr, int number) {
        int[] sortArr = sortSelection(arr);
        int min = 0;
        int max = arr.length - 1;

        while (min < max) {
            int mid = (min + max) / 2;
            if (sortArr[mid] == number) {
                return true;
            }
            if (number < sortArr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int number) {
        for (int i = 0; i < size; i++) {
            if (integerList[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int number) {
        for (int i = size - 1; i >= 0 ; i--) {
            if (integerList[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException index = " + index + " not exist!");
        }
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if(size != otherList.size()){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!integerList[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(integerList, null);
        size = 0;
    }

    @Override
    public int[] toArray() {
        return Arrays.stream(integerList).mapToInt(Integer::intValue).toArray();
    }

    @Override
    public int[] sortBubble(int[] el) {
        if (el == null) {
            throw new NullPointerException("NullPointerException: IntegerList is null");
        }
        for (int i = 0; i < el.length - 1; i++) {
            for (int j = 0; j < el.length - 1; j++) {
                if (el[j] > el[j + 1]) {
                    int temp = el[j + 1];
                    el[j + 1] = el[j];
                    el[j] = temp;
                }
            }
        }
        return el;
    }

    @Override
    public int[] sortSelection(int[] el) {
        if (el == null) {
            throw new NullPointerException("NullPointerException: IntegerList is null");
        }
        for (int j = 0; j < el.length; j++){
            int indexOfMinimum = j;
            int min = el[indexOfMinimum];

            for (int i = j; i < el.length; i++) {
                if (el[i] < min) {
                    min = el[i];
                    indexOfMinimum = i;
                }
            }
            int temp = el[indexOfMinimum];
            el[indexOfMinimum] = el[j];
            el[j] = temp;
        }
        return el;
    }

    @Override
    public int[] sortInsertion(int[] el) {
        for (int i = 1; i < el.length; i++) {
            int temp = el[i];
            int j = i;
            while (j > 0 && el[j - 1] >= temp) {
                el[j] = el[j - 1];
                j--;
            }
            el[j] = temp;
        }
        return el;
    }
}
