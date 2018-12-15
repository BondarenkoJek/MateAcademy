package ua.bondarenkojek.lessons.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JsonUtility {
    public static void printUserToFile(User user, String path) {
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();

        try(PrintWriter writer = new PrintWriter(file)) {
            String content = mapper.writeValueAsString(user);
            writer.write(content);
        } catch (JsonProcessingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
