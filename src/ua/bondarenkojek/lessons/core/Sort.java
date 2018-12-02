package ua.bondarenkojek.lessons.core;

public class Sort {

    public static int[] bubbleSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                int temp;

                if(array[j] > array[j + 1] ) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertSort(int[] array){

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int location = i - 1;
            while (location >= 0 && array[location] > temp) {
                array[location + 1] = array[location];
                location--;
            }
            array[location + 1] = temp;
        }
        return array;
    }
}
