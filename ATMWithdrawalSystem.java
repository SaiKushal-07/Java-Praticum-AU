import java.util.Scanner;


class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}


class Account {
    String accountHolderName;
    double accountBalance;

    
    Account(String name, double balance) {
        accountHolderName = name;
        accountBalance = balance;
    }

    
    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > accountBalance) {
            throw new InsufficientBalanceException(
                "Insufficient balance! Withdrawal cannot be processed."
            );
        } else {
            accountBalance = accountBalance - amount;

            System.out.println("\nWithdrawal successful.");
            System.out.println("Withdrawn Amount: " + amount);
            System.out.println("Remaining Balance: " + accountBalance);
        }
    }
}


public class ATMWithdrawalSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your account balance: ");
        double balance = sc.nextDouble();

        
        Account account = new Account(name, balance);

        System.out.println("Available Balance: " + account.accountBalance);

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
        }
        catch (InsufficientBalanceException e) {
            System.out.println("\nError: " + e.getMessage());
            System.out.println("Transaction failed.");
            System.out.println("Available Balance: " + account.accountBalance);
        }

        sc.close();
    }
}