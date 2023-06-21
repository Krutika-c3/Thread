package com.learning.thread.FutureAndCallable;

import java.util.concurrent.*;

class CallableClass implements Callable<Integer> {

    Integer number;

    public CallableClass(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <=number ; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

public class CallableClassExample {
    public static void main(String[] args) {
        CallableClass task2 = new CallableClass(10);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(task2);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
