import java.util.*;

class Student {
    int id, semester;
    String name, department;

    Student(int id, String name, String dept, int sem) {
        this.id = id;
        this.name = name;
        department = dept;
        semester = sem;
    }

    void display() {
        System.out.println(id + " " + name + " "
            + department + " " + semester);
    }
}

public class ArrayListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println(
                "\n1.Add  2.Remove  3.Search  4.Display  5.Exit");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Semester: ");
                    int sem = Integer.parseInt(sc.nextLine());

                    students.add(new Student(id, name, dept, sem));
                    System.out.println("Student added successfully.");
                    break;
                }

                case 2: {
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    boolean removed =
                        students.removeIf(s -> s.id == id);

                    System.out.println(removed
                        ? "Student removed successfully."
                        : "Student record not found.");
                    break;
                }

                case 3: {
                    System.out.print("Search by 1.ID or 2.Name: ");
                    int type = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter ID or Name: ");
                    String key = sc.nextLine();

                    boolean found = false;

                    for (Student s : students) {
                        if ((type == 1 && s.id == Integer.parseInt(key))
                            || (type == 2 && s.name.equalsIgnoreCase(key))) {
                            s.display();
                            found = true;
                        }
                    }

                    if (!found)
                        System.out.println("Student record not found.");
                    break;
                }

                case 4:
                    if (students.isEmpty())
                        System.out.println("No student records available.");
                    else
                        for (Student s : students)
                            s.display();
                    break;

                case 5:
                    System.out.println("Exiting Student Management System.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}