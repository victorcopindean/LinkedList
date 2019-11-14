package com.company;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        LinkedList<Number> numberList = new LinkedList<>();

        ArrayList<Double> doubleList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();

        LinkedList<String> stringList = new LinkedList<>();

        stringList.add("a");
        stringList.add("b");
        stringList.add("c");


        intList.add(1);
        intList.add(2);

        doubleList.add(2.5);
        doubleList.add(2.6);

        numberList.addAll(doubleList);
        numberList.addAll(intList);


    }

}