package ua.bondarenkojek.homework.core;


public class Matrix {
    public static void main(String[] args) {

        //Creating matrix
        int[][] matrix = new int[5][5];

        //Filing the matrix with test data
        int data = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = data++;
            }
        }

        //Test
        //Printing source matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }


        System.out.println();
        //Mirror image matrix
        matrix = mirrorImage(matrix);
        //Printing new matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }




    }


    public static int[][] mirrorImage(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (i == j)
                    break;

                int tmp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = tmp;
            }
        }
        return arr;
    }

}
