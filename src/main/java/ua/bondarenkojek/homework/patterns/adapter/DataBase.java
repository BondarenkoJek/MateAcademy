package ua.bondarenkojek.homework.patterns.adapter;

public class DataBase {
    public void select(Data data) {
        data.read();
    }

    public void insert(Data data){
        data.create();
    }

    public void update(Data data){
        data.update();
    }

    public void delete(Data data){
        data.delete();
    }
}
