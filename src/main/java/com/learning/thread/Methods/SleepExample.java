package com.learning.thread.Methods;

class CountSleep implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + " : " + Thread.currentThread().getName());
        }
    }
}

public class SleepExample {
    public static void main(String[] args) {
        CountSleep countSleep = new CountSleep();
        Thread thread = new Thread(countSleep);
        thread.start();

        CountSleep countSleep2 = new CountSleep();
        Thread thread2 = new Thread(countSleep2);
        thread2.start();
    }
}
