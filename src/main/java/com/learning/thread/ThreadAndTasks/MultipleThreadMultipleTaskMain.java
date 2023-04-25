package com.learning.thread.ThreadAndTasks;

class MultipleThreadMultipleTask1 implements Runnable {
    public void run() {
        System.out.println("Hello World from MultipleThreadMultipleTask1");
    }
}

class MultipleThreadMultipleTask2 implements Runnable {
    public void run() {
        System.out.println("Hello World from MultipleThreadMultipleTask2");
    }
}

public class MultipleThreadMultipleTaskMain {
    public static void main(String[] args) {
        MultipleThreadMultipleTask1 task1 = new MultipleThreadMultipleTask1();
        Thread thread1 = new Thread(task1);
        thread1.start();

        MultipleThreadMultipleTask2 task2 = new MultipleThreadMultipleTask2();
        Thread thread2 = new Thread(task2);
        thread2.start();
    }
}