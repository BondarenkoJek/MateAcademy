package ua.bondarenkojek.lessons.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("N = ");

        int n;

        while (true)
        try {
                n = Integer.parseInt(reader.readLine());
                System.out.println(fac(n));
                break;

        } catch (IOException e) {
            System.err.println("Invalid number, try again!");
        }


    }

    static int fac(int n) {
        return n == 1 ? 1 : fac(n-1) * n;
    }

}
