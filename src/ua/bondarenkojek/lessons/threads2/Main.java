package ua.bondarenkojek.lessons.threads2;

public class Main {
    private static volatile int count;

    public static void main(String[] args) {

        Thread thread1 = new Thread( () -> {
                while (count < 100) {
                    incrementAndPrint();
            }
        });

        Thread thread2 = new Thread( ()-> {
                while (count < 100) {
                    incrementAndPrint();
                }
        });

        thread1.start();
        thread2.start();
    }

    private synchronized static void incrementAndPrint() {
        System.out.println(Thread.currentThread().getName() + " count = " + count++);
    }
}
