import java.util.Scanner;

public class BankAccount {
    String accountHolderName;
    long accountNumber;
    String accountType;
    double accountBalance;

    BankAccount(String name, long accNo, String type, double balance){ // Constructor to initialize the account details
        accountHolderName = name;
        accountNumber = accNo;
        accountType = type;
        accountBalance = balance;
    }

    void display(){ // Method to display account details
        System.out.println("--- Account Details ---");
        System.out.println("Account Holder Name : " + accountHolderName);
        System.out.println("Account Number      : " + accountNumber);
        System.out.println("Account Type        : " + accountType);
        System.out.println("Account Balance     : " + accountBalance);
        System.out.println("-----------------------");
    }

    void deposit(double amount){ // Method to deposit money into the account
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Must be greater than 0.");
            return;
        }
        
        accountBalance += amount;
        System.out.println("Amount deposited: " + amount);
        System.out.println("New Account Balance: " + accountBalance);
    }

    void withdraw(double amount){ // Method to withdraw money from the account
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Must be greater than 0");
            return;
        }
        
        if(accountBalance >= amount){
            accountBalance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("New Account Balance: " + accountBalance);
        } else {
            System.out.println("Insufficient balance! Current balance is " + accountBalance);
        }
    }
    
    void checkBalance() { // Method to check account balance
        System.out.println("Current Balance is: " + accountBalance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 1. CREATE ACCOUNT ===");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();
        sc.nextLine(); 

        System.out.print("Enter Account Type: ");
        String type = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount myAccount = new BankAccount(name, accNo, type, balance);
        System.out.println("Account created successfully!");

        int choice = 0;

        while (choice != 5) {
            System.out.println("=== BANK MENU ===");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    myAccount.display();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depAmount = sc.nextDouble();
                    myAccount.deposit(depAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withAmount = sc.nextDouble();
                    myAccount.withdraw(withAmount);
                    break;
                case 4:
                    myAccount.checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}