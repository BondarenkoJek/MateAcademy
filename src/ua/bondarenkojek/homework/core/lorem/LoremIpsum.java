package ua.bondarenkojek.homework.core.lorem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.Arrays;

public class LoremIpsum {
    public static void main(String[] args) {
        File inFile = new File("src/ua/bondarenkojek/homework/core/lorem/input.txt");
        File outFile = new File("src/ua/bondarenkojek/homework/core/lorem/filtered_lorem_ipsum.txt");

//        String inText = "";
//
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)))) {
//
//            while (reader.ready()) {
//                inText += reader.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        inText = inText.replaceAll("[^a-zA-Z]", " ");
//        String[] words = inText.split(" ");
//
//        try (FileWriter stream = new FileWriter(outFile)) {
//
//            for (String word : words) {
//                if (word.length() > 3)
//                    stream.write(word + "\n");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            Files.lines(Paths.get("src/ua/bondarenkojek/homework/core/lorem/input.txt"))
                    .flatMap(s -> Arrays.stream(s.replaceAll("[^a-zA-Z]", " ").split(" ")))
                    .filter(w -> w.length() > 3)
                    .forEach(w -> {
                        try {
                            Files.write(Paths.get("src/ua/bondarenkojek/homework/core/lorem/filtered_lorem_ipsum.txt"), w.getBytes(), new OpenOption() {});
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
