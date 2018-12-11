package ua.bondarenkojek.lessons.threads1;


public class Main {
    public static void main(String[] args) {
        CustomThread thread1 = new CustomThread(6000, "MyFirstCustomThread");
        CustomThread thread2 = new CustomThread(1000, "MySecondCustomThread");
        thread1.start();
        thread2.start();
        System.out.println("Main finished");
    }

}
