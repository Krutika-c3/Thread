package com.learning.thread.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// creating a separate class
class Task3 implements Runnable {
    @Override
    public void run() {
        System.out.println("TASK 3 - Current running thread : " + Thread.currentThread().getName());
    }
}

public class OneWorkerThreadMultipleTasks {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // anonymous class
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("TASK 1 - Current running thread : " + Thread.currentThread().getName());
            }
        };

        // lambda expression
        Runnable task2 = () -> System.out.println("TASK 2 - Current running thread : " + Thread.currentThread().getName());

        executorService.submit(task1);
        executorService.submit(task2);

        Task3 task3 = new Task3();
        executorService.submit(task3);

        executorService.shutdown();
    }
}
