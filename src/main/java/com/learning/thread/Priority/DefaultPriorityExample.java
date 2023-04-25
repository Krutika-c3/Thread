package com.learning.thread.Priority;

public class DefaultPriorityExample {

    public static void main(String[] args) {
        System.out.println("main thread");
        System.out.println("Priority of main thread : " + Thread.currentThread().getPriority());
        // whatever is the priority of the main thread, child thread will also have the same priority
        ChildThread childThread = new ChildThread();
        Thread thread = new Thread(childThread);
        thread.start();
    }
}
