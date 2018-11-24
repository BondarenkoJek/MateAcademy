package ua.bondarenkojek.homework.core.sort;


public class QuickSort {

    private static int[] array;

    public static int[] sort(int[] arr) {
        array = arr;
        doSort(0, array.length - 1);
        return array;
    }

    private static void doSort(int first, int last) {
        if (first >= last)
            return;

        int i = first, j = last;
        int mainPoint = i + (j - i) / 2;
        while (i < j) {
            while (i < mainPoint && (array[i] <= array[mainPoint])) {
                i++;
            }
            while (j > mainPoint && (array[mainPoint] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == mainPoint)
                    mainPoint = j;
                else if (j == mainPoint)
                    mainPoint = i;
            }
        }
        doSort(first, mainPoint);
        doSort(mainPoint+1, last);
    }

}
