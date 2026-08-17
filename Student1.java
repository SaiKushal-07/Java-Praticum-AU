class Student1{
    String name;
    int rollNumber;
    float CGPA;

    public static void main(String[] args){
        Student1 s1 = new Student1();
        Student1 s2 = new Student1();
        s1.name = "raj";
        s1.rollNumber = 101;
        s1.CGPA = 8.5f;
        s2.name = "rani";
        s2.rollNumber = 102;
        s2.CGPA = 9.0f;

        System.out.println("Name: " + s1.name);
        System.out.println("Roll Number: " + s1.rollNumber);
        System.out.println("CGPA: " + s1.CGPA);

        System.out.println();

        System.out.println("Name: " + s2.name);
        System.out.println("Roll Number: " + s2.rollNumber);
        System.out.println("CGPA: " + s2.CGPA);
    }
}