package com.learning.thread.Methods;

class TestThread implements Runnable {
    public void run() {
        System.out.println("TestThread new thread name : " + Thread.currentThread().getName());
    }
}

public class BasicAndNamingMethods {
    public static void main(String[] args) {
        System.out.println("Naming thread methods");

        System.out.println("-----------------------------------");

        System.out.println("Main thread name : " + Thread.currentThread().getName());
        Thread.currentThread().setName("main thread");
        System.out.println("Main new thread name : " + Thread.currentThread().getName());

        System.out.println("-----------------------------------");

        TestThread testThread = new TestThread();
        Thread thread = new Thread(testThread);
        System.out.println("TestThread thread name : " + thread.getName());
        thread.setName("TestThread thread");
        thread.start();

        System.out.println("Is TestThread alive : " + thread.isAlive());
    }
}
