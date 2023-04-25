package com.learning.thread.CreateThread;

/*
    BETTER WAY TO CREATE A THREAD
    - because we'll be able to extend the class which is required in business context
 */
public class CreateThreadFromRunnableInterface implements Runnable {

    public static void main(String[] args) {
        CreateThreadFromRunnableInterface createThreadFromRunnableInterface = new CreateThreadFromRunnableInterface();
        Thread thread = new Thread(createThreadFromRunnableInterface);
        thread.start();
    }

    public void run() {
        System.out.println("Hello World from CreateThreadFromRunnableInterface");
    }
}
