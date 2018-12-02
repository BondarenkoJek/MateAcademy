package ua.bondarenkojek.homework.core;


import java.io.*;

public class Files {
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

        //Mirror image matrix
        matrix = Matrix.mirrorImage(matrix);

        //Creating file reflected_matrix.txt
        File file = new File("reflected_matrix.txt");

        //Writing matrix to file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    writer.write(matrix[i][j] + "\t");
                }
                writer.write("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
