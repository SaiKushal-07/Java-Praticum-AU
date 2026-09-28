import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class Account {
    String accountHolderName;
    double accountBalance;

    public Account(String accountHolderName, double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > accountBalance) {
            throw new InsufficientBalanceException("Insufficient funds available in the account.");
        } else {
            accountBalance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Rahul", 10000.0);

        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Remaining Balance: " + account.accountBalance);
        
        scanner.close();
    }
}