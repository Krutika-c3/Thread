package com.learning.thread.Synchornization;

class BookTheaterSeatNoSync {
    int total_seats = 10;

    void bookSeat(int seats) {
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

//  MOVIE BOOKING APP WITHOUT SYNC
public class WithoutSyncExample implements Runnable{
    static BookTheaterSeatNoSync bookTheaterSeat;
    int seats;

    @Override
    public void run() {
        bookTheaterSeat.bookSeat(seats);
    }

    public static void main(String[] args) {
        bookTheaterSeat = new BookTheaterSeatNoSync();

        WithoutSyncExample deepakBookMovie = new WithoutSyncExample();
        deepakBookMovie.seats = 7;
        Thread deepak = new Thread(deepakBookMovie);
        deepak.setName("deepak");
        deepak.start();

        WithoutSyncExample reenaBookMovie = new WithoutSyncExample();
        reenaBookMovie.seats = 6;
        Thread reena = new Thread(reenaBookMovie);
        reena.setName("reena");
        reena.start();

    }

}
