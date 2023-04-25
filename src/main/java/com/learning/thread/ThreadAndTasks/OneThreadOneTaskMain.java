package com.learning.thread.ThreadAndTasks;

class OneThreadOneTask implements Runnable {
    public void run() {
        System.out.println("Hello World from OneThreadOneTask");
    }
}

public class OneThreadOneTaskMain {
    public static void main(String[] args) {
        OneThreadOneTask oneThreadOneTask = new OneThreadOneTask();
        Thread thread = new Thread(oneThreadOneTask);
        thread.start();
    }
}