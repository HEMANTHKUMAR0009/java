import java.util.Scanner;

public class Student {
    private String name;
    private String rollNumber;
    private String course;
    private int age;
    private String email;

    public void readDetails(Scanner scanner) {
        System.out.print("Enter student name: ");
        name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        rollNumber = scanner.nextLine();

        System.out.print("Enter course: ");
        course = scanner.nextLine();

        System.out.print("Enter age: ");
        age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter email: ");
        email = scanner.nextLine();
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

    public static void main(String[] args) {
        runStudentProgram();
    }

    public static void main2(String[] args) {
        runStudentProgram();
    }

    private static void runStudentProgram() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        student.readDetails(scanner);
        student.displayDetails();

        scanner.close();
    }
}
