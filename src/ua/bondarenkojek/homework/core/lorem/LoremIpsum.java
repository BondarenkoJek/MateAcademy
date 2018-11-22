package ua.bondarenkojek.homework.core.lorem;


import java.io.*;

public class LoremIpsum {
    public static void main(String[] args) {
        File inFile = new File("src/ua/bondarenkojek/homework/core/lorem/input.txt");
        File outFile = new File("src/ua/bondarenkojek/homework/core/lorem/filtered_lorem_ipsum.txt");

        String inText = "";

        try(BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(inFile)))) {

            while (reader.ready()) {
               inText+=reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        inText = inText.replaceAll("[^a-zA-Z]", " ");
        String[] words = inText.split(" ");


        try(FileWriter stream = new FileWriter(outFile)) {

            for (String word : words) {
                if (word.length() > 3)
                stream.write(word + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
