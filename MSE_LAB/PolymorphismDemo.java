class Payment {
    void makePayment(double amount) {
        System.out.println("Payment: Rs." + amount);
    }

    void makePayment(double amount, String id) {
        System.out.println("Payment: Rs." + amount
            + ", Transaction ID: " + id);
    }
}

class CreditCardPayment extends Payment {
    void makePayment(double amount) {
        System.out.println("Credit Card: Rs." + amount);
    }
}

class UPIPayment extends Payment {
    void makePayment(double amount) {
        System.out.println("UPI: Rs." + amount);
    }
}

class NetBankingPayment extends Payment {
    void makePayment(double amount) {
        System.out.println("Net Banking: Rs." + amount);
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Payment p = new CreditCardPayment();
        p.makePayment(5000);
        p.makePayment(2500, "TXN1001");

        p = new UPIPayment();
        p.makePayment(1200.50);

        p = new NetBankingPayment();
        p.makePayment(8500);
    }
}