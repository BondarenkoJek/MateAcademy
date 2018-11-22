package ua.bondarenkojek.lessons.core;


public class Sort {

    public static int[] bubbleSort(int[] a) {
        int[] sortArr = a;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                int temp;

                if(a[j] > a[j + 1] ) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return sortArr;
    }


    public static int[] insertSort(int[] a){

        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int location = i - 1;
            while (location >= 0 && a[location] > temp) {
                a[location + 1] = a[location];
                location--;
            }
            a[location + 1] = temp;
        }

        return a;
    }

}
