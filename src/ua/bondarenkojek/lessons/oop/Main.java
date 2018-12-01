package ua.bondarenkojek.lessons.oop;



import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Machine> machines = new ArrayList<>();

        machines.add(new Exkavator());
        machines.add(new Bus());
        machines.add(new Buldoser());

        machines.forEach(machine -> {
            machine.start();
            machine.doWork();
        });

        new Object().hashCode();

    }
}