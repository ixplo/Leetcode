package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static final int NUMBER = 10000000;
    private static List<Integer> arrayList = new ArrayList<>();
    private static List<Integer> linkedList = new LinkedList<>();
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            arrayList.add(i);
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            linkedList.add(i);
        }
        stop = System.currentTimeMillis();
        System.out.println(stop - start);
    }


}
