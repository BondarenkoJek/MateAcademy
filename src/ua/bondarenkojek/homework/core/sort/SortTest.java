package ua.bondarenkojek.homework.core.sort;

import ua.bondarenkojek.lessons.core.Sort;

public class SortTest {
    public static void main(String[] args) {
        int[] testArray;
        long start;
        long finish;

        testArray = createTestArr();
        start = System.currentTimeMillis();
        Sort.bubbleSort(testArray);
        finish = System.currentTimeMillis();
        //Bubble sort time = more 10 minutes
        System.out.println("Bubble sort time = " + (finish - start));

        testArray = createTestArr();
        start = System.currentTimeMillis();
        Sort.insertSort(testArray);
        finish = System.currentTimeMillis();
        //InsertSort time = 131130
        System.out.println("Insert sort time = " + (finish - start));

        testArray = createTestArr();
        start = System.currentTimeMillis();
        QuickSort.sort(testArray);
        finish = System.currentTimeMillis();
        //QuickSort time = 219
        System.out.println("Quick sort time = " + (finish - start));
    }

    private static int[] createTestArr() {
        int[] array = new int[1_000_000];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length);
        }
        return array;
    }
}
