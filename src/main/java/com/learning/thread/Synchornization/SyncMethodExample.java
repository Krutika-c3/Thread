package com.learning.thread.Synchornization;

class BookTheaterSeatSyncMethod {
    int total_seats = 10;

    synchronized void bookSeat(int seats) {
        if (total_seats >= seats) {
            System.out.println(Thread.currentThread().getName() + ", " + seats + " seat/s booked successfully");
            total_seats = total_seats - seats;
            System.out.println("Available seats : " + total_seats);
        } else {
            System.out.println(Thread.currentThread().getName() + ", " + "sorry seats cannot be booked !");
            System.out.println("Available seats : " + total_seats);
        }
    }
}

public class SyncMethodExample implements Runnable{
    static BookTheaterSeatSyncMethod bookTheaterSeat;
    int seats;

    @Override
    public void run() {
        bookTheaterSeat.bookSeat(seats);
    }

    public static void main(String[] args) {
        bookTheaterSeat = new BookTheaterSeatSyncMethod();

        SyncMethodExample deepakBookMovie = new SyncMethodExample();
        deepakBookMovie.seats = 7;
        Thread deepak = new Thread(deepakBookMovie);
        deepak.setName("deepak");
        deepak.start();

        SyncMethodExample reenaBookMovie = new SyncMethodExample();
        reenaBookMovie.seats = 6;
        Thread reena = new Thread(reenaBookMovie);
        reena.setName("reena");
        reena.start();

    }

}
