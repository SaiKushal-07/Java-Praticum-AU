class Student {
    int studentId;
    String studentName, department;

    Student(int id, String name, String dept) {
        studentId = id;
        studentName = name;
        department = dept;
    }

    void displayStudentDetails() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Department: " + department);
    }
}

class UndergraduateStudent extends Student {
    int semester;
    double cgpa;

    UndergraduateStudent(int id, String name, String dept, int sem, double cgpa) {
        super(id, name, dept);
        this.semester = sem;
        this.cgpa = cgpa;
    }

    void displayUGDetails() {
        displayStudentDetails();
        System.out.println("Semester: " + semester);
        System.out.println("CGPA: " + cgpa);
    }
}

class PostgraduateStudent extends Student {
    String specialization, researchTopic;

    PostgraduateStudent(int id, String name, String dept, String spec, String topic) {
        super(id, name, dept);
        specialization = spec;
        researchTopic = topic;
    }

    void displayPGDetails() {
        displayStudentDetails();
        System.out.println("Specialization: " + specialization);
        System.out.println("Research Topic: " + researchTopic);
    }
}

public class StudentManagement {
    public static void main(String[] args) {

        UndergraduateStudent ug =
            new UndergraduateStudent(101, "Ravi", "CSE", 5, 8.75);

        PostgraduateStudent pg =
            new PostgraduateStudent(201, "Anita", "ECE",
                                    "AI", "Computer Vision");

        System.out.println("UNDERGRADUATE");
        ug.displayUGDetails();

        System.out.println("\nPOSTGRADUATE");
        pg.displayPGDetails();
    }
}