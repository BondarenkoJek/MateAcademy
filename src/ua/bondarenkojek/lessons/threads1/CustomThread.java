package ua.bondarenkojek.lessons.threads1;

public class CustomThread extends Thread {
    long sleep;
    String name;

    public CustomThread(long sleep, String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " started");

        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException was occurred in " + name);
        }
        System.out.println(name + " finished");
    }
}
