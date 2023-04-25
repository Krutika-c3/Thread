package com.learning.thread.CreateThread;

public class CreateThreadFromThreadClass extends Thread {

    public static void main(String[] args) {
        CreateThreadFromThreadClass createThreadFromThreadClass = new CreateThreadFromThreadClass();
        createThreadFromThreadClass.start();
    }

    @Override
    public void run() {
        System.out.println("Hello World from CreateThreadFromThreadClass");
    }
}
