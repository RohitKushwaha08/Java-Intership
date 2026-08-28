import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Display student details
    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------");
    }
}


public class task2 {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // Add Student
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks);

        students.add(student);

        System.out.println("Student added successfully!");
    }


    // View Students
    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {

            System.out.println("\n--- Student Records ---");

            for (Student student : students) {
                student.displayStudent();
            }
        }
    }


    // Update Student
    public static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        for (Student student : students) {

            if (student.getId() == id) {

                System.out.print("Enter New Name: ");
                String newName = scanner.nextLine();

                System.out.print("Enter New Marks: ");
                double newMarks = scanner.nextDouble();

                student.setName(newName);
                student.setMarks(newMarks);

                System.out.println("Student updated successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }


    // Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                System.out.println("Student deleted successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }


    // Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT RECORD MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}