package com.learning.thread.Methods;

class InteruptThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            //interrupted method changes the interrupted status
            System.out.println("interrupted : " + Thread.interrupted());
            //System.out.println("isInterrupted : " + Thread.currentThread().isInterrupted());
            try {
                System.out.println(i);
                Thread.sleep(1000);
                System.out.println("updated interrupted : " + Thread.interrupted());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class InteruptExample {
    public static void main(String[] args) {
        InteruptThread interuptThread = new InteruptThread();
        Thread thread = new Thread(interuptThread);
        thread.start();
        thread.interrupt();
        //whenever thread goes in sleep mode - thread will be interrupted
    }
}
