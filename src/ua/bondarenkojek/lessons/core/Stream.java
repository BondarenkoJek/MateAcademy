package ua.bondarenkojek.lessons.core;

import java.io.*;

public class Stream {
    public static void main(String[] args) {
        File file = new File("tmp.txt");

        try(FileWriter stream = new FileWriter(file)) {

            stream.write("Hello World\n");
            stream.write("Hello World");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(file)))) {

            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
