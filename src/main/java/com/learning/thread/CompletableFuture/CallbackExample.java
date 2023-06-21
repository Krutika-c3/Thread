package com.learning.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CallbackExample {

    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    delay(2);
                    return "Tech Recipes";
                })
                .thenApply(s -> "Hello, " + s)
                .thenRun(() -> {
            System.out.println("completableFuture finished. ");
        });

        System.out.println("From main");

        // so that main thread waits for the future thread to get executed
        completableFuture.join();

        CompletableFuture<Void> completableFuture2 = CompletableFuture.supplyAsync(
                () -> {
                    delay(2);
                    return "Tech Recipes";
                })
                .thenApply(s -> "Hello, " + s)
                .thenAccept(s -> System.out.println("Result : " + s)
        );

        completableFuture2.join();

    }


}