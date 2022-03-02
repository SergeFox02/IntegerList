package ru.skypro;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        StringList stringList = new StringListImpl(5);

        System.out.println("stringList.add(\"Word1\") = " + stringList.add("Word1"));
        System.out.println("stringList.add(\"Word4\") = " + stringList.add("Word4"));
        System.out.println("stringList.add(\"Word3\") = " + stringList.add("Word3"));
        System.out.println("stringList.add(\"Word5\") = " + stringList.add("Word5"));
        System.out.println("stringList.add(index = 4 \"Word6\") = " + stringList.add(4, "Word6"));
        System.out.println("stringList.set(\"Word7\") = " + stringList.set(4, "Word7"));
        System.out.println("stringList.remove(\"Word4\") = " + stringList.remove("Word4"));
        System.out.println("stringList.remove(2) = " + stringList.remove(2));
        stringList.print();
        System.out.println("stringList.add(\"Word1\") = " + stringList.add("Word1"));
        System.out.println("stringList.contains(\"Word4\") = " + stringList.contains("Word4"));
        System.out.println("stringList.indexOf(\"Word1\") = " + stringList.indexOf("Word1"));
        stringList.print();
        System.out.println("stringList.lastIndexOf(\"Word3\") = " + stringList.lastIndexOf("Word3"));
        System.out.println("stringList.get(1) = " + stringList.get(1));
        stringList.print();
        System.out.println("stringList.size() = " + stringList.size());

        stringList.print();
        StringList otherStringList = new StringListImpl(5);
        otherStringList.add("Word1");
        otherStringList.add("Word3");
        otherStringList.add("Word7");
        otherStringList.add("Word1");

        otherStringList.print();
        stringList.print();
        System.out.println("stringList.equals(otherStringList) = " + stringList.equals(otherStringList));

        System.out.println("stringList.toArray() = " + Arrays.toString(stringList.toArray()));
        stringList.print();
        System.out.println("otherStringList.toArray() = " + Arrays.toString(otherStringList.toArray()));
        stringList.clear();
        System.out.println("stringList.isEmpty() = " + stringList.isEmpty());

    }
}
