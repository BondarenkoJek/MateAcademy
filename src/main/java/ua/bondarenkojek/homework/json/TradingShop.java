package ua.bondarenkojek.homework.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TradingShop {
    private List<Fruit> fruitsDB;

    public TradingShop() {
        fruitsDB = new ArrayList<>();
    }

    public void addFruits(List<Fruit> fruits, String pathToJsonFile) {
        fruitsDB.addAll(fruits);

        File file = new File(pathToJsonFile); 
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(file, fruits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String pathToJsonFile) {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(file, fruitsDB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String pathToJsonFile) {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();

        try {
            fruitsDB = Arrays.asList(mapper.readValue(file, Fruit[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
