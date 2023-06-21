package com.learning.thread.Synchornization;

class BookTheaterSeatStaticSyncMethod {
    static int total_seats = 20;

    static synchronized void bookSeat(int seats) {
        if (total_seats >= seats) {
            System.out.println(Thread.currentThread().getName() + ", " + seats + " seat/s booked successfully");
            total_seats = total_seats - seats;
            System.out.println("Available seats : " + total_seats);
        } else {
            System.out.println(Thread.currentThread().getName() + ", " + "sorry " + seats + " seat/s cannot be booked !");
            System.out.println("Available seats : " + total_seats);
        }
    }
}

public class StaticSyncMethodExample implements Runnable {
    static BookTheaterSeatStaticSyncMethod bookTheaterSeat;
    static BookTheaterSeatStaticSyncMethod bookTheaterSeat2;
    int seats;

    public static void main(String[] args) {
        bookTheaterSeat = new BookTheaterSeatStaticSyncMethod();

        StaticSyncMethodExample deepakBookMovie = new StaticSyncMethodExample();
        deepakBookMovie.seats = 7;
        Thread deepak = new Thread(deepakBookMovie);
        deepak.setName("deepak");
        deepak.start();

        StaticSyncMethodExample reenaBookMovie = new StaticSyncMethodExample();
        reenaBookMovie.seats = 6;
        Thread reena = new Thread(reenaBookMovie);
        reena.setName("reena");
        reena.start();

        bookTheaterSeat2 = new BookTheaterSeatStaticSyncMethod();

        StaticSyncMethodExample ritaBookMovie = new StaticSyncMethodExample();
        ritaBookMovie.seats = 2;
        Thread rita = new Thread(ritaBookMovie);
        rita.setName("rita");
        rita.start();

        StaticSyncMethodExample clayBookMovie = new StaticSyncMethodExample();
        clayBookMovie.seats = 6;
        Thread clay = new Thread(clayBookMovie);
        clay.setName("clay");
        clay.start();
    }

    @Override
    public void run() {
        bookTheaterSeat.bookSeat(seats);
    }

}

