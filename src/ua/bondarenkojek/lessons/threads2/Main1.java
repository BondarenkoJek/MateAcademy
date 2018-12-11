package ua.bondarenkojek.lessons.threads2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        };

        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getName() + " started");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " finished");
            return "Some String";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(runnable);
        Future<String> future = executorService.submit(callable);
        executorService.shutdown();

        System.out.println(future.get());
    }
}
