package ua.bondarenkojek.lessons.core;

public class Array {
    public static void main(String[] args) {
        int[][] matrix = new int[4][5];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random()*200) - 100;
            }
        }

        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if(matrix[i][j] < 0)
                System.out.print(matrix[i][j] + "\t\t");
                else System.out.print("*\t\t");

                if (matrix[i][j] > max)
                    max = matrix[i][j];
            }
            System.out.println("\n");
        }

        System.out.println("\nMax = " + max);
    }
}
