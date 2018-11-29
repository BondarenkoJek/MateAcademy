package ua.bondarenkojek.lessons.oop;


public class Exkavator extends Machine {
    @Override
    public void drive() {
        super.drive();
        System.out.println("Exkavator drive");
    }

    @Override
    public void doWork() {
        System.out.println("Excavator dig");
    }
}
