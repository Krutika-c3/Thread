package com.learning.thread.Synchornization;

class BookTheaterSeatSyncBlock {
    int total_seats = 10;

    void bookSeat(int seats) {
        System.out.println("hi " + Thread.currentThread().getName());
        System.out.println("hi " + Thread.currentThread().getName());
        System.out.println("hi " + Thread.currentThread().getName());
        System.out.println("hi " + Thread.currentThread().getName());
        System.out.println("hi " + Thread.currentThread().getName());
        synchronized (this) {
            if (total_seats >= seats) {
                System.out.println(Thread.currentThread().getName() + ", " + seats + " seat/s booked successfully");
                total_seats = total_seats - seats;
                System.out.println("Available seats : " + total_seats);
            } else {
                System.out.println(Thread.currentThread().getName() + ", " + "sorry seats cannot be booked !");
                System.out.println("Available seats : " + total_seats);
            }
        }
        System.out.println("hi " + Thread.currentThread().getName());
        System.out.println("hi " + Thread.currentThread().getName());
        System.out.println("hi " + Thread.currentThread().getName());
        System.out.println("hi " + Thread.currentThread().getName());
        System.out.println("hi " + Thread.currentThread().getName());
    }
}

public class SyncBlockExample implements Runnable{
    static BookTheaterSeatSyncBlock bookTheaterSeat;
    int seats;

    @Override
    public void run() {
        bookTheaterSeat.bookSeat(seats);
    }

    public static void main(String[] args) {
        bookTheaterSeat = new BookTheaterSeatSyncBlock();

        SyncBlockExample deepakBookMovie = new SyncBlockExample();
        deepakBookMovie.seats = 7;
        Thread deepak = new Thread(deepakBookMovie);
        deepak.setName("deepak");
        deepak.start();

        SyncBlockExample reenaBookMovie = new SyncBlockExample();
        reenaBookMovie.seats = 6;
        Thread reena = new Thread(reenaBookMovie);
        reena.setName("reena");
        reena.start();

    }

}
