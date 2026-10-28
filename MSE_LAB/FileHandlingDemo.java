import java.io.*;
import java.util.*;

class LibraryTransaction {
    String id, book, user, issueDate, returnDate;

    LibraryTransaction(String id, String book, String user,
                       String issue, String ret) {
        this.id = id;
        this.book = book;
        this.user = user;
        issueDate = issue;
        returnDate = ret;
    }

    public String toString() {
        return id + " | " + book + " | " + user
            + " | " + issueDate + " | " + returnDate;
    }
}

public class FileHandlingDemo {
    static File file = new File("library_transactions.txt");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Record Transaction  2.View Records  3.Exit");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    System.out.print("Book ID: ");
                    String id = sc.nextLine();

                    System.out.print("Book Name: ");
                    String book = sc.nextLine();

                    System.out.print("Student Name: ");
                    String user = sc.nextLine();

                    System.out.print("Issue Date: ");
                    String issue = sc.nextLine();

                    System.out.print("Return Date: ");
                    String ret = sc.nextLine();

                    LibraryTransaction t =
                        new LibraryTransaction(id, book, user, issue, ret);

                    try (FileWriter fw = new FileWriter(file, true)) {
                        fw.write(t + System.lineSeparator());
                        System.out.println("Transaction recorded successfully.");
                    } catch (IOException e) {
                        System.out.println("File writing error.");
                    }
                    break;
                }

                case 2:
                    if (!file.exists() || file.length() == 0) {
                        System.out.println("No transaction records found.");
                    } else {
                        try (BufferedReader br = new BufferedReader(
                                new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null)
                                System.out.println(line);
                        } catch (IOException e) {
                            System.out.println("File reading error.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting Library Management System.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}