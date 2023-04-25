package com.learning.thread.Priority;

public class ChildThread implements Runnable {

    @Override
    public void run() {
        System.out.println("child thread");
        System.out.println("Priority of child thread : " + Thread.currentThread().getPriority());
    }
}