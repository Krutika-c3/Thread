package com.learning.thread.ThreadAndTasks;

/*
    In this program total 3 threads (non-daemon) are created!
    1. thread for main application - JVM creates it
    2. thread1
    3. thread3
*/
class MultipleThreadOneTask implements Runnable {
    public void run() {
        System.out.println("Hello World from MultipleThreadOneTask");
    }
}

public class MultipleThreadOneTaskMain {
    public static void main(String[] args) {
        MultipleThreadOneTask task1 = new MultipleThreadOneTask();
        Thread thread1 = new Thread(task1);
        thread1.start();

        MultipleThreadOneTask task2 = new MultipleThreadOneTask();
        Thread thread2 = new Thread(task2);
        thread2.start();
    }
}
