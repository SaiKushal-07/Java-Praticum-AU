import java.util.*;

public class HashtableDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable<Integer, String> books = new Hashtable<>();

        while (true) {
            System.out.println(
                "\n1.Add  2.Search  3.Remove  4.Display  5.Exit");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    System.out.print("Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Book Title: ");
                    String title = sc.nextLine();

                    books.put(id, title);
                    System.out.println("Book added successfully.");
                    break;
                }

                case 2: {
                    System.out.print("Enter Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    if (books.containsKey(id))
                        System.out.println(books.get(id));
                    else
                        System.out.println("Book not found.");
                    break;
                }

                case 3: {
                    System.out.print("Enter Book ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    if (books.containsKey(id)) {
                        books.remove(id);
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }

                case 4:
                    if (books.isEmpty())
                        System.out.println("No books available.");
                    else
                        for (Map.Entry<Integer, String> e
                                : books.entrySet())
                            System.out.println(
                                e.getKey() + " : " + e.getValue());
                    break;

                case 5:
                    System.out.println("Exiting Book Lookup System.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}