class TicketBooking {
    void book(String passenger) {
        System.out.println("Passenger: " + passenger
            + ", Status: Confirmed, Thread: "
            + Thread.currentThread().getName());
    }
}

class BookingThread extends Thread {
    TicketBooking booking;
    String passenger;

    BookingThread(TicketBooking b, String p) {
        super("Booking-" + p);
        booking = b;
        passenger = p;
    }

    public void run() {
        booking.book(passenger);
    }
}

class BookingRunnable implements Runnable {
    TicketBooking booking;
    String passenger;

    BookingRunnable(TicketBooking b, String p) {
        booking = b;
        passenger = p;
    }

    public void run() {
        booking.book(passenger);
    }
}

public class MultithreadingDemo {
    public static void main(String[] args) {
        TicketBooking b = new TicketBooking();

        Thread t1 = new BookingThread(b, "Rahul");
        Thread t2 = new Thread(
            new BookingRunnable(b, "Priya"), "Booking-Priya");

        Thread t3 = new BookingThread(b, "Aman");
        Thread t4 = new Thread(
            new BookingRunnable(b, "Neha"), "Booking-Neha");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All bookings processed.");
    }
}