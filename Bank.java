import java.util.Scanner;

abstract class BankAccount {
    private final String accountNumber;
    private final String holderName;
    private double balance;

    protected BankAccount(String accountNumber, String holderName, double balance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }
        if (holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Holder name cannot be empty.");
        }
        if (balance < 0 || Double.isNaN(balance) || Double.isInfinite(balance)) {
            throw new IllegalArgumentException("Initial balance must be a valid non-negative amount.");
        }

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        validateAmount(amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        validateAmount(amount);
        if (amount > balance) {
            throw new IllegalArgumentException("Withdrawal exceeds the available balance.");
        }
        balance -= amount;
    }

    public abstract double calculateInterest();

    protected double getBalance() {
        return balance;
    }

    public void displayDetails() {
        System.out.printf(
                "%s Account%nAccount Number: %s%nHolder Name: %s%nBalance: $%.2f%nInterest: $%.2f%n",
                getClass().getSimpleName(), accountNumber, holderName, balance, calculateInterest());
    }

    private static void validateAmount(double amount) {
        if (amount <= 0 || Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("Amount must be a valid positive value.");
        }
    }
}

class SavingsAccount extends BankAccount {
    private static final double ANNUAL_INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * ANNUAL_INTEREST_RATE;
    }
}

class CurrentAccount extends BankAccount {
    private static final double ANNUAL_INTEREST_RATE = 0.02;
    private static final double INTEREST_FREE_BALANCE = 10_000.00;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return Math.max(0, getBalance() - INTEREST_FREE_BALANCE) * ANNUAL_INTEREST_RATE;
    }
}

public class Bank {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter savings account details");
            BankAccount savings = readAccount(scanner, true);

            System.out.println("\nEnter current account details");
            BankAccount current = readAccount(scanner, false);

            System.out.println("\nSavings account transactions");
            savings.deposit(readAmount(scanner, "Enter deposit amount: "));
            savings.withdraw(readAmount(scanner, "Enter withdrawal amount: "));

            System.out.println("\nCurrent account transactions");
            current.deposit(readAmount(scanner, "Enter deposit amount: "));
            current.withdraw(readAmount(scanner, "Enter withdrawal amount: "));

            System.out.println("\nAccount Details");
            savings.displayDetails();
            System.out.println();
            current.displayDetails();
        }
    }

    private static BankAccount readAccount(Scanner scanner, boolean savings) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String holderName = scanner.nextLine();
        double balance = readAmount(scanner, "Enter opening balance: ");

        if (savings) {
            return new SavingsAccount(accountNumber, holderName, balance);
        }
        return new CurrentAccount(accountNumber, holderName, balance);
    }

    private static double readAmount(Scanner scanner, String prompt) {
        System.out.print(prompt);
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }
}
