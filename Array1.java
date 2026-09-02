import java.util.Scanner;

public class Array1 {
    private int[] array;
    private int size;

    public Array1(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public void readArray(Scanner scanner) {
        System.out.println("Enter " + size + " values:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
    }

    public void displayArray() {
        System.out.println("Array values:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        Array1 array1 = new Array1(size);
        array1.readArray(scanner);
        array1.displayArray();

        scanner.close();
    }
}
