package ru.skypro;

import ru.skypro.exception.ArrayIndexOutOfBoundsException;
import ru.skypro.exception.ArrayIsFullException;
import ru.skypro.exception.NotFoundException;
import ru.skypro.exception.NullPointerException;

import java.util.Arrays;

public class StringListImpl implements StringList{

    private final String[] stringList;
    private int size;

    public StringListImpl(int size) {
        this.stringList = new String[size];
    }

    private void shift(int index) {
        for (int i = index; i < size - 1; i++) {
            stringList[index] = stringList[i + 1];
            index++;
        }
        stringList[size - 1] = null;
        size--;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(stringList[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException("NullPointerException: Item is Null");
        }
        if(size >= stringList.length) {
            throw new ArrayIsFullException("ArrayIsFullException: Array is full!");
        }
        stringList[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("NullPointerException: Item is Null");
        }
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException index = " + index + " not exist!");
        }
        if(size >= stringList.length) {
            throw new ArrayIsFullException("ArrayIsFullException: Array is full!");
        }
        size++;
        for (int i = size - 1; i > index; i--) {
            stringList[i] = stringList[i - 1];
        }
        stringList[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new NullPointerException("NullPointerException: Item is Null");
        }
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException index =  " + index + " not exist!");
        }
        this.stringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new NullPointerException("NullPointerException: Item is Null");
        }
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) {
                stringList[i] = null;
                shift(i);
                return item;
            }
        }
        throw new NotFoundException("NotFoundException: item " + item + " not found");
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException index = " + index + " not exist!");
        }
        String removeItem = stringList[index];
        stringList[index] = null;
        shift(index);
        return removeItem;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new NullPointerException("NullPointerException: Item is Null");
        }
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new NullPointerException("NullPointerException: Item is Null");
        }
        for (int i = 0; i < size; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new NullPointerException("NullPointerException: Item is Null");
        }
        for (int i = size - 1; i >= 0 ; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException index = " + index + " not exist!");
        }
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(size != otherList.size()){
            return false;
        }
        return Arrays.equals(stringList, otherList.toArray());
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
        Arrays.fill(stringList, null);
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringList, stringList.length);
    }
}
