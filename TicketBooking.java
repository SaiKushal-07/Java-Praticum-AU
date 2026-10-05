public class TicketBooking {
    String passengerName;
    String bookingStatus;

    public TicketBooking(String passengerName) {
        this.passengerName = passengerName;
        this.bookingStatus = "Pending";
    }

    public void displayBookingDetails(String threadName) {
        System.out.println("Passenger: " + passengerName + " | Status: " + bookingStatus + " | Thread: " + threadName);
    }
}

class BookingThread extends Thread {
    TicketBooking booking;

    public BookingThread(TicketBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        booking.bookingStatus = "Confirmed";
        booking.displayBookingDetails(Thread.currentThread().getName());
    }
}

class BookingRunnable implements Runnable {
    TicketBooking booking;

    public BookingRunnable(TicketBooking booking) {
        this.booking = booking;
    }

    @Override
    public void run() {
        booking.bookingStatus = "Confirmed";
        booking.displayBookingDetails(Thread.currentThread().getName());
    }
}

class TicketBookingSystem {
    public static void main(String[] args) {
        TicketBooking booking1 = new TicketBooking("Rahul");
        TicketBooking booking2 = new TicketBooking("Priya");
        TicketBooking booking3 = new TicketBooking("Aman");
        TicketBooking booking4 = new TicketBooking("Neha");

        BookingThread thread1 = new BookingThread(booking1);
        BookingThread thread2 = new BookingThread(booking2);

        Thread thread3 = new Thread(new BookingRunnable(booking3));
        Thread thread4 = new Thread(new BookingRunnable(booking4));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("All passenger booking requests have been processed successfully.");
    } 
}
