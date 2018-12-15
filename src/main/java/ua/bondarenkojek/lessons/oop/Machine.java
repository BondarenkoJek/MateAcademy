package ua.bondarenkojek.lessons.oop;

public abstract class Machine {

    private boolean wasStarted = false;

    public void start() {
        System.out.println("Start");
        wasStarted = true;
    }
    public void stop() {
        wasStarted = false;
    }

    public void drive() {
        System.out.println("I am driven");
    }

    public abstract void doWork();
}
