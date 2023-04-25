package com.learning.thread.Priority;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;

public class SetPriorityExample {

    public static void main(String[] args) {
        System.out.println("main thread");
        System.out.println("Old priority of main thread : " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(MAX_PRIORITY);
        System.out.println("New priority of main thread : " + Thread.currentThread().getPriority());
        // BY DEFAULT : whatever is the priority of the main thread, child thread will also have the same priority
        ChildThread childThread = new ChildThread();
        Thread thread = new Thread(childThread);
        // Here we're changing the priority of the child thread
        thread.setPriority(MIN_PRIORITY);
        thread.start();
    }
}
