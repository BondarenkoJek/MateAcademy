package ua.bondarenkojek.homework.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company {
    private List<TradingShop> shops;
    private double companyBalance;

    public Company() {
        shops = new ArrayList<>();
    }

    public void save(String pathToJsonFile) {
        File file = new File(pathToJsonFile);
        ObjectMapper mapper = new ObjectMapper();
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
            Company company = mapper.readValue(file, Company.class);
            shops = company.getShops();
            companyBalance = company.getCompanyBalance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getCompanyBalance() {
        companyBalance = 0.0;
        shops.forEach(shop -> companyBalance += shop.getMoneyBalance());
        return companyBalance;
    }

    public List<Fruit> getSpoiledFruits(Date date) {
        List<Fruit> fruits = new ArrayList<>();
        shops.forEach(shop -> fruits.addAll(shop.getSpoiledFruits(date)));
        return fruits;
    }

    public List<Fruit> getAvailableFruits(Date date) {
        List<Fruit> fruits = new ArrayList<>();
        shops.forEach(shop -> fruits.addAll(shop.getAvailableFruits(date)));
        return fruits;
    }

    public List<Fruit> getAddedFruits(Date date) {
        List<Fruit> fruits = new ArrayList<>();
        shops.forEach(shop -> fruits.addAll(shop.getAddedFruits(date)));
        return fruits;
    }

    public List<Fruit> getSpoiledFruits(Date date, Fruit.FruitType type) {
        List<Fruit> fruits = new ArrayList<>();
        shops.forEach(shop -> fruits.addAll(shop.getSpoiledFruits(date, type)));
        return fruits;
    }

    public List<Fruit> getAvailableFruits(Date date, Fruit.FruitType type) {
        List<Fruit> fruits = new ArrayList<>();
        shops.forEach(shop -> fruits.addAll(shop.getAvailableFruits(date, type)));
        return fruits;
    }

    public List<Fruit> getAddedFruits(Date date, Fruit.FruitType type) {
        List<Fruit> fruits = new ArrayList<>();
        shops.forEach(shop -> fruits.addAll(shop.getAddedFruits(date, type)));
        return fruits;
    }

    public List<TradingShop> getShops() {
        return shops;
    }
}
