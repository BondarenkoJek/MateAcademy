package ua.bondarenkojek.lessons.oop;

public class Bus extends Machine {
    @Override
    public void drive() {
        super.drive();
        System.out.println("Bus drive");
    }

    @Override
    public void doWork() {
        System.out.println("Bus carry");
    }
}
