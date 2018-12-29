package ua.bondarenkojek.homework.patterns;

import ua.bondarenkojek.homework.patterns.adapter.Data;
import ua.bondarenkojek.homework.patterns.adapter.DataBase;
import ua.bondarenkojek.homework.patterns.adapter.DataImpl;
import ua.bondarenkojek.homework.patterns.adapter.Text;
import ua.bondarenkojek.homework.patterns.adapter.TextData;
import ua.bondarenkojek.homework.patterns.prototype.Prototype;

public class Main {
    public static void main(String[] args) {
//test prototype pattern
        Prototype origin = new Prototype(1, "First");
        Prototype copy = origin.copy();

        System.out.println(origin);
        System.out.println(copy);

//test adapter pattern
        DataBase dataBase = new DataBase();
        Data data = new DataImpl();
        Text text = new Text();
        Data textData = new TextData(text);

        dataBase.select(data);
        dataBase.select(textData);
        dataBase.insert(data);
        dataBase.insert(textData);
        dataBase.update(data);
        dataBase.update(textData);
        dataBase.delete(data);
        dataBase.delete(textData);
    }
}
