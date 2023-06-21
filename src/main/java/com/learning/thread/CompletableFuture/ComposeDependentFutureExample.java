package com.learning.thread.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ComposeDependentFutureExample {

    public static void delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<String> getUserDetails(){
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("getUserDetails() - " + Thread.currentThread().getName());
            delay(2);
            return "UserDetails";
        });
    }

    public static CompletableFuture<String> getWishList(String user){
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("getWishList()  - "+ Thread.currentThread().getName() + " - " + user);
            delay(3);
            return "User's WishList";
        });
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //thenCompose
        CompletableFuture<String> future =   getUserDetails()
                .thenCompose( s -> getWishList(s));
        System.out.println("Doing something");
        delay(4);
        System.out.println(future.join());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken " + (endTime - startTime)/1000);
    }

}