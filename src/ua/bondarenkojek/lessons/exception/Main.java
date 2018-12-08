package ua.bondarenkojek.lessons.exception;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        print();
        try {
            getFile();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    private static void print() throws NullPointerException {
        throw new NullPointerException();
    }

    private static void getFile() throws CustomException {
        try {
            new FileReader("");
        } catch (FileNotFoundException e) {
            throw new CustomException("Cannot open file", e);
        }
    }
}
