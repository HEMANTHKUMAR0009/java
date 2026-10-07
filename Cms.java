import java.util.Scanner;

class Person {
    private final String name;
    private final int age;
    private final String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

class CmsStudent extends Person {
    private final String rollNumber;
    private final String course;

    public CmsStudent(String name, int age, String address, String rollNumber, String course) {
        super(name, age, address);
        this.rollNumber = rollNumber;
        this.course = course;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student Details");
        super.displayDetails();
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
}

class Faculty extends Person {
    private final String employeeId;
    private final String subject;

    public Faculty(String name, int age, String address, String employeeId, String subject) {
        super(name, age, address);
        this.employeeId = employeeId;
        this.subject = subject;
    }

    @Override
    public void displayDetails() {
        System.out.println("Faculty Details");
        super.displayDetails();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Subject: " + subject);
    }
}

public class Cms {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter student details");
            CmsStudent student = readStudent(scanner);

            System.out.println("\nEnter faculty details");
            Faculty faculty = readFaculty(scanner);

            System.out.println("\nCollege Management System");
            student.displayDetails();
            System.out.println();
            faculty.displayDetails();
        }
    }

    private static CmsStudent readStudent(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Roll number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Course: ");
        String course = scanner.nextLine();

        return new CmsStudent(name, age, address, rollNumber, course);
    }

    private static Faculty readFaculty(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Employee ID: ");
        String employeeId = scanner.nextLine();
        System.out.print("Subject: ");
        String subject = scanner.nextLine();

        return new Faculty(name, age, address, employeeId, subject);
    }
}
