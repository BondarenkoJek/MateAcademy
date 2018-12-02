package ua.bondarenkojek.homework.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 0;

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    System.out.println("N = ");
                    n = Integer.parseInt(reader.readLine());

                    if (n < 0) {
                        System.err.println("Invalid number, try again!");
                        continue;
                    }
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("Result = " + fib(n));
    }

    public static int fib(int n) {
        return n <=1 ? n : fib(n - 1) + fib(n - 2);
    }
}
