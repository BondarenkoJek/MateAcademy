package ua.bondarenkojek.homework.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Romb {
    public static void main(String[] args) {
        int size = 0;

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    System.out.println("Size = ");
                    size = Integer.parseInt(reader.readLine());

                    if (size < 0) {
                        System.err.println("Invalid size, try again!");
                        continue;
                    }

                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            drawRomb(size);
    }

    public static void drawRomb(int size) {
        int center = size/2;
        int stars = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                    if (j < center - stars || j > center + stars )
                        System.out.print(" ");
                     else
                        System.out.print("*");
                }

            System.out.println();

            if (i < center) {
                stars++;
            }
            else {
                stars--;
            }
        }
    }
}
