package ua.bondarenkojek.homework.patterns.adapter;

public class DataImpl implements Data {
    @Override
    public void create() {
        System.out.println("Creating data");
    }

    @Override
    public void read() {
        System.out.println("Reading data");
    }

    @Override
    public void update() {
        System.out.println("Updating data");
    }

    @Override
    public void delete() {
        System.out.println("Deleting data");
    }
}
