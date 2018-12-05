package ua.bondarenkojek.homework.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        testAddToTail(arrayList);
        testAddToTail(linkedList);

        testAddToHead(arrayList);
        testAddToHead(linkedList);
    }

    private static void testAddToHead(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_00; i++) {
            list.add(0, i);
        }
        long finish = System.currentTimeMillis();

        System.out.println(list.getClass().getSimpleName() + " add to head test time - " + (finish - start));
    }

    private static void testAddToTail(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_00; i++) {
            list.add(i);
        }
        long finish = System.currentTimeMillis();

        System.out.println(list.getClass().getSimpleName() + " add to tail test time - " + (finish - start));
    }
}
