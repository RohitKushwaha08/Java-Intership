import java.util.ArrayList;
import java.util.Scanner;

// Parent class
class Account {
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        transactionHistory = new ArrayList<>();

        transactionHistory.add(
            "Account created with balance: Rs. " + initialBalance
        );
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            String transaction =
                "Deposited: Rs. " + amount;

            transactionHistory.add(transaction);

            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;

            String transaction =
                "Withdrawn: Rs. " + amount;

            transactionHistory.add(transaction);

            System.out.println("Withdrawal successful!");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    // Display transaction history
    public void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");

        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Child class demonstrating inheritance
class SavingsAccount extends Account {

    public SavingsAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }

    // Method overriding
    @Override
    public void displayBalance() {
        System.out.println(
            accountHolder + "'s Savings Account Balance: Rs. " + balance
        );
    }
}

// Main class
public class Task5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BANK ACCOUNT SIMULATION ===");

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        SavingsAccount account =
                new SavingsAccount(name, initialBalance);

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();

                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();

                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    account.showTransactionHistory();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using the Bank Account Simulation!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }
}