package ua.bondarenkojek.lessons.oop;


public class Buldoser extends Machine {
    @Override
    public void drive() {
        super.drive();
        System.out.println("Buldoser drive");
    }

    @Override
    public void doWork() {
        System.out.println("Buldoser row");
    }
}
