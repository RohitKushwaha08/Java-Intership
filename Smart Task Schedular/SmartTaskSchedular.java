import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SmartTaskSchedular {

    private static final String FILE_NAME = "tasks.dat";

    public static void main(String[] args) {

        PriorityQueue<Task> taskQueue = loadTasks();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("       SMART TASK SCHEDULAR");
            System.out.println("=================================");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Highest Priority Task");
            System.out.println("4. Edit Task");
            System.out.println("5. Delete Task");
            System.out.println("6. Save Tasks");
            System.out.println("7. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addTask(taskQueue, scanner);
                    saveTasks(taskQueue);
                    break;

                case 2:
                    viewTasks(taskQueue);
                    break;

                case 3:
                    completeTask(taskQueue);
                    saveTasks(taskQueue);
                    break;

                case 4:
                    editTask(taskQueue, scanner);
                    saveTasks(taskQueue);
                    break;

                case 5:
                    deleteTask(taskQueue, scanner);
                    saveTasks(taskQueue);
                    break;

                case 6:
                    saveTasks(taskQueue);
                    break;

                case 7:
                    saveTasks(taskQueue);
                    System.out.println(
                            "Thank you for using Smart Task Schedular!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 7);

        scanner.close();
    }

    // Add Task
    public static void addTask(
            PriorityQueue<Task> taskQueue,
            Scanner scanner) {

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print(
                "Enter priority (High/Medium/Low): "
        );
        String priority = scanner.nextLine();

        System.out.print("Enter deadline: ");
        String deadline = scanner.nextLine();

        taskQueue.add(
                new Task(title, priority, deadline)
        );

        System.out.println("Task added successfully!");
    }

    // View Tasks
    public static void viewTasks(
            PriorityQueue<Task> taskQueue) {

        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        ArrayList<Task> tasks =
                new ArrayList<>(taskQueue);

        tasks.sort(null);

        System.out.println("\n========== YOUR TASKS ==========");

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + tasks.get(i)
            );
        }
    }

    // Complete highest priority task
    public static void completeTask(
            PriorityQueue<Task> taskQueue) {

        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        Task completedTask = taskQueue.poll();

        System.out.println("\nCompleted Task:");
        System.out.println(completedTask);
    }

    // Edit Task
    public static void editTask(
            PriorityQueue<Task> taskQueue,
            Scanner scanner) {

        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        ArrayList<Task> tasks =
                new ArrayList<>(taskQueue);

        tasks.sort(null);

        viewTasks(taskQueue);

        System.out.print("\nEnter task number to edit: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Task oldTask = tasks.get(number - 1);

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();

        System.out.print(
                "Enter new priority (High/Medium/Low): "
        );
        String priority = scanner.nextLine();

        System.out.print("Enter new deadline: ");
        String deadline = scanner.nextLine();

        taskQueue.remove(oldTask);

        taskQueue.add(
                new Task(title, priority, deadline)
        );

        System.out.println("Task updated successfully!");
    }

    // Delete Task
    public static void deleteTask(
            PriorityQueue<Task> taskQueue,
            Scanner scanner) {

        if (taskQueue.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        ArrayList<Task> tasks =
                new ArrayList<>(taskQueue);

        tasks.sort(null);

        viewTasks(taskQueue);

        System.out.print("\nEnter task number to delete: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        Task taskToDelete = tasks.get(number - 1);

        taskQueue.remove(taskToDelete);

        System.out.println("Task deleted successfully!");
    }

    // Save Tasks
    public static void saveTasks(
            PriorityQueue<Task> taskQueue) {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            output.writeObject(taskQueue);

            System.out.println("Tasks saved successfully!");

        } catch (IOException e) {

            System.out.println(
                    "Error saving tasks: " + e.getMessage()
            );
        }
    }

    // Load Tasks
    @SuppressWarnings("unchecked")
    public static PriorityQueue<Task> loadTasks() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new PriorityQueue<>();
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            return (PriorityQueue<Task>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println(
                    "Could not load saved tasks."
            );

            return new PriorityQueue<>();
        }
    }
}