package ua.bondarenkojek.homework.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TradingShop {
    private static final long MILLISECONDS_FROM_DAY = (long) 8.64e+7;
    private List<Fruit> fruitsDB;
    private double moneyBalance;

    public TradingShop() {
        fruitsDB = new ArrayList<>();
    }

    public void addFruits(List<Fruit> fruits, String pathToJsonFile) {
        fruitsDB.addAll(fruits);

        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(file, fruits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String pathToJsonFile) {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(file, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String pathToJsonFile) {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();

        try {
            TradingShop shop = mapper.readValue(file, TradingShop.class);
            fruitsDB = shop.getFruitsDB();
            moneyBalance = shop.getMoneyBalance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        return fruitsDB.stream().filter((Fruit fruit) -> {
            Date fruitDate = fruit.getDate();
            int shelfLife = fruit.getShelfLife();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fruitDate);
            calendar.add(Calendar.DATE, shelfLife);
            return calendar.getTime().getTime() < date.getTime();
        }).collect(Collectors.toList());
    }

    public List<Fruit> getSpoiledFruits(Date date, Fruit.FruitType type) {
        return getSpoiledFruits(date).stream().filter(fruit -> type == fruit.getType()).collect(Collectors.toList());
    }

    public List<Fruit> getAvailableFruits(Date date) {
        List<Fruit> tmp = getSpoiledFruits(date);
        return fruitsDB.stream().filter(fruit -> !tmp.contains(fruit)).collect(Collectors.toList());
    }

    public List<Fruit> getAvailableFruits(Date date, Fruit.FruitType type) {
        return getAvailableFruits(date).stream().filter(fruit -> type == fruit.getType()).collect(Collectors.toList());
    }

    public List<Fruit> getAddedFruits(Date date) {
        return fruitsDB.stream()
                .filter(fruit -> fruit.getDate().getTime() / MILLISECONDS_FROM_DAY == date.getTime() / MILLISECONDS_FROM_DAY)
                .collect(Collectors.toList());
    }

    public List<Fruit> getAddedFruits(Date date, Fruit.FruitType type) {
        return getAddedFruits(date).stream().filter(fruit -> type == fruit.getType()).collect(Collectors.toList());
    }

    public void sell(String pathToJsonFile) {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
        List<Client> clients = null;

        try {
            clients = Arrays.asList(mapper.readValue(file, Client[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (clients == null || fruitsDB.isEmpty())
            return;

        for (Client client : clients) {
            int count = client.getCount();

            for (Fruit fruit : fruitsDB) {
                if (client.getFruitType() == fruit.getType() && count > 0)
                    count--;
                else break;
            }
            if (count == 0)
                pay(client.getFruitType(), client.getCount());
        }
    }

    private void pay(Fruit.FruitType type, int count) {
        for (int i = 0; i < fruitsDB.size(); i++) {
            if (count <= 0)
                break;

            if (fruitsDB.get(i).getType() == type) {
                moneyBalance += fruitsDB.get(i).getPrice();
                fruitsDB.remove(i);
                i--;
                count--;
            }
        }
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public List<Fruit> getFruitsDB() {
        return fruitsDB;
    }
}
