package ua.bondarenkojek.homework.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Fruit {
    private FruitType type;
    private int shelfLife;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;
    private Double price;

    public enum FruitType {
        STRAWBERRY,
        RASPBERRY,
        BLACKBERRY,
        PEAR,
        APPLE,
        PEACH,
        APRICOT,
        PLUM,
        PINEAPPLE,
        BANANA;
    }
}
