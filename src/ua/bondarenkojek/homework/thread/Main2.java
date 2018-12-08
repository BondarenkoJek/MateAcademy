package ua.bondarenkojek.homework.thread;

public class Main2 {
    public static void main(String[] args) {
//        join 500
//        FirstThread started
//        thread1 join exit
//        SecondThread started
//        main method finished
//        SecondThread finished
//        FirstThread finished

//        join 5000
//        FirstThread started
//        FirstThread finished
//        thread1 join exit
//        main method finished
//        SecondThread started
//        SecondThread finished
        Thread thread1 = new MyThread("FirstThread", 5000);
        Thread thread2 = new MyThread("SecondThread", 3000);
        thread1.start();
        try {
//            thread1.join(500);
            thread1.join(5000);
            System.out.println("thread1 join exit");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        System.out.println("main method finished");
    }
}
