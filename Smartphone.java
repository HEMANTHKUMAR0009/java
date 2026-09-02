import java.util.Scanner;

public class Smartphone {
    private String brand;
    private String model;
    private int storageCapacity;

    public void readModelDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter brand: ");
        brand = scanner.nextLine();

        System.out.print("Enter model: ");
        model = scanner.nextLine();

        System.out.print("Enter storage capacity (in GB): ");
        storageCapacity = scanner.nextInt();

        scanner.close();
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Storage Capacity: " + storageCapacity + " GB");
    }

    public static void main(String[] args) {
        Smartphone phone = new Smartphone();
        phone.readModelDetails();
        phone.displayDetails();
    }
}
