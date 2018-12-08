package ua.bondarenkojek.homework.thread;

public class Main {
    public static void main(String[] args) {
//        FirstThread started
//        SecondThread started
//        main method finished
//        SecondThread finished
//        FirstThread finished
        Thread thread1 = new MyThread("FirstThread", 5000);
        Thread thread2 = new MyThread("SecondThread", 3000);
        thread1.start();
        thread2.start();
        System.out.println("main method finished");
    }
}
