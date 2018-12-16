package ua.bondarenkojek.homework.json;

import lombok.Data;

@Data
public class Client {
    private String name;
    private Fruit.FruitType fruitType;
    private int count;
}
