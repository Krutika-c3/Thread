package com.learning.thread.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OneWorkerThreadPoolTwoThreadMultipleTasks {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {
            System.out.println("TASK 1 - Task started : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("TASK 1 - Task ended : " + Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            System.out.println("TASK 2 - Task started : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("TASK 2 - Task ended : " + Thread.currentThread().getName());
        };

        Runnable task3 = () -> {
            System.out.println("TASK 3 - Task started : " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("TASK 3 - Task ended : " + Thread.currentThread().getName());
        };

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();
    }
}
