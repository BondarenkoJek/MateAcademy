package ua.bondarenkojek.homework.thread;

public class MyThread extends Thread {
    private String name;
    private long threadSleep;

    public MyThread(String name, long threadSleep) {
        super(name);
        this.name = name;
        this.threadSleep = threadSleep;
    }

    @Override
    public void run() {
        System.out.println(name + " started");
        try {
            Thread.sleep(threadSleep);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException was occurred in " + name);
        }
        System.out.println(name + " finished");
    }
}
