import java.util.Scanner;

public class task1 {

    // Addition method
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction method
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication method
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division method
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== JAVA CALCULATOR =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (choice) {
                    case 1:
                        System.out.println("Result = " + add(num1, num2));
                        break;

                    case 2:
                        System.out.println("Result = " + subtract(num1, num2));
                        break;

                    case 3:
                        System.out.println("Result = " + multiply(num1, num2));
                        break;

                    case 4:
                        System.out.println("Result = " + divide(num1, num2));
                        break;
                }

            } else if (choice == 5) {
                System.out.println("Thank you for using the calculator!");
            } else {
                System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}