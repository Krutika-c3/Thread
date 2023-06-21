package com.learning.thread.FutureAndCallable;

import java.util.concurrent.*;

public class AnonymousCallableExample {

    public static void main(String[] args) {
        Callable<String> task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "task1 is completed.";
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(task1);

        try {
            System.out.println(future.get(5,TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
