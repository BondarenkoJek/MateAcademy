package ua.bondarenkojek.homework.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        Fruit apple = new Fruit();
        apple.setType(Fruit.FruitType.APPLE);
        apple.setShelfLife(100);
        apple.setPrice(1.50);
        apple.setDate(new Date());

        Fruit banana = new Fruit();
        banana.setType(Fruit.FruitType.BANANA);
        banana.setShelfLife(10);
        banana.setPrice(2.50);
        banana.setDate(new Date());

        fruits.add(apple);
        fruits.add(banana);

        String fruitsDB = "src/main/java/ua/bondarenkojek/homework/json/fruitsDB.json";
        String supply1 = "src/main/java/ua/bondarenkojek/homework/json/supply1.json";
        String supply2 = "src/main/java/ua/bondarenkojek/homework/json/supply2.json";

        TradingShop tradingShop = new TradingShop();

        tradingShop.addFruits(fruits, supply1);

        Fruit pear = new Fruit();
        pear.setType(Fruit.FruitType.PEAR);
        pear.setShelfLife(15);
        pear.setPrice(1.50);
        pear.setDate(new Date());

        fruits.add(pear);

        tradingShop.addFruits(fruits, supply2);

        tradingShop.save(fruitsDB);

        tradingShop.load(fruitsDB);
    }
}
