package com.learning.thread.Synchornization.interThreadCommunication;

class TotalEarnings implements Runnable{

    int total = 0;
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            total = total + 100;
        }
    }
}
public class WithoutITCExample {
    public static void main(String[] args) {
        TotalEarnings totalEarnings = new TotalEarnings();
        Thread thread = new Thread(totalEarnings);
        thread.start();

        System.out.println("Total Earnings : " + totalEarnings.total + " Rs");
    }
}
