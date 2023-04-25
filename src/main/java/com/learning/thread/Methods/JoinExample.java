package com.learning.thread.Methods;

class ThreadJ implements Runnable {

    @Override
    public void run() {
        try {
            // to make child thread wait for main thread
            JoinExample.mainThread.join();

            for (int i = 1; i <= 5; i++) {
                System.out.println("child thread : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class JoinExample {

    static Thread mainThread;

    public static void main(String[] args) throws InterruptedException {
        mainThread = Thread.currentThread();
        ThreadJ threadJ = new ThreadJ();
        Thread thread = new Thread(threadJ);
        thread.start();

        // to make main thread wait for child thread
        // thread.join();
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("main thread : " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
