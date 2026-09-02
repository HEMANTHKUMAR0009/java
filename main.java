import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bankacc account = new bankacc();

        account.readDetails(scanner);

        System.out.print("Enter deposit amount: ");
        account.deposit(scanner.nextDouble());

        System.out.print("Enter withdrawal amount: ");
        account.withdraw(scanner.nextDouble());

        System.out.println("\nAccount Summary");
        account.displayDetails();

        scanner.close();
    }
}
