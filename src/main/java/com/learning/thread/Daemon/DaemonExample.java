package com.learning.thread.Daemon;

class DaemonThread implements Runnable{
    @Override
    public void run() {
        if(Thread.currentThread().isDaemon()){
            System.out.println("daemon thread");
        }
        else {
            System.out.println("child thread");
        }
    }
}

public class DaemonExample {
    public static void main(String[] args) {
        System.out.println("main thread");
        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();
    }
}
