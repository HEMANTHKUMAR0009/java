import java.util.Scanner;

public class bankacc {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    public void readDetails(Scanner scanner) {
        System.out.print("Enter account holder name: ");
        accountHolderName = scanner.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = scanner.nextInt();

        System.out.print("Enter initial balance: ");
        balance = scanner.nextDouble();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public void displayDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        bankacc account = new bankacc();

        account.readDetails(scanner);

        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Enter withdrawal amount: ");
        double withdrawAmount = scanner.nextDouble();
        account.withdraw(withdrawAmount);

        System.out.println("\nAccount Summary");
        account.displayDetails();

        scanner.close();
    }
}
