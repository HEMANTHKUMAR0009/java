import java.util.Random;
import java.util.Scanner;

public class randomElements {
    private int[] array;
    private final int SIZE = 5;
    private Scanner sc;

    public randomElements() {
        array = new int[SIZE];
        sc = new Scanner(System.in);
    }

    public void readArray() {
        System.out.println("Enter 5 unique numbers:");

        for (int i = 0; i < SIZE; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            int value = sc.nextInt();

            if (contains(value)) {
                System.out.println("This number is already taken. Please enter a different one.");
                i--;
            } else {
                array[i] = value;
            }
        }
    }

    private boolean contains(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int sumOfElements() {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public void displayTakenNumbers() {
        System.out.print("Taken numbers: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
        }
        System.out.println();
    }

    public void searchRandomElement() {
        Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        int randomValue = array[randomIndex];

        int sumWithRandom = randomValue;

        System.out.println("Random chosen element: " + randomValue);
        System.out.println("Sum of the random element: " + sumWithRandom);
        System.out.println("The number " + randomValue + " is present in the array.");
    }

    public static void main(String[] args) {
        randomElements ua = new randomElements();
        ua.readArray();
        ua.displayTakenNumbers();
        ua.searchRandomElement();
    }
}
