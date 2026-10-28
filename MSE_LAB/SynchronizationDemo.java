class BankAccount {
    int accountNumber;
    String holderName;
    double balance;

    BankAccount(int no, String name, double balance) {
        accountNumber = no;
        holderName = name;
        this.balance = balance;
    }

    synchronized void deposit(String user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;
        System.out.println(user + " deposited Rs." + amount
            + ", Balance: Rs." + balance);
    }

    synchronized void withdraw(String user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (balance >= amount) {
            balance -= amount;
            System.out.println(user + " withdrew Rs." + amount
                + ", Balance: Rs." + balance);
        } else {
            System.out.println(user + ": Insufficient Balance.");
        }
    }

    synchronized void displayBalance() {
        System.out.println("Final Balance: Rs." + balance);
    }
}

class UserTransaction extends Thread {
    BankAccount account;
    String type;
    double amount;

    UserTransaction(BankAccount a, String user,
                    String type, double amount) {
        super(user);
        account = a;
        this.type = type;
        this.amount = amount;
    }

    public void run() {
        if (type.equalsIgnoreCase("deposit"))
            account.deposit(getName(), amount);
        else
            account.withdraw(getName(), amount);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1001, "Ravi", 10000);

        UserTransaction t1 =
            new UserTransaction(account, "User1", "deposit", 2000);
        UserTransaction t2 =
            new UserTransaction(account, "User2", "withdraw", 3000);
        UserTransaction t3 =
            new UserTransaction(account, "User3", "deposit", 1000);
        UserTransaction t4 =
            new UserTransaction(account, "User4", "withdraw", 2000);

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

        account.displayBalance();
    }
}