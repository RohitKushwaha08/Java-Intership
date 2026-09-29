import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class SmartTaskGUI extends Application {

    private static final String FILE_NAME = "tasks.txt";

    private TextField titleField;
    private ComboBox<String> priorityBox;
    private TextField deadlineField;
    private ListView<String> taskList;

    private PriorityQueue<Task> taskQueue =
            new PriorityQueue<>();

    private ObservableList<String> displayTasks =
            FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {

        // Load saved tasks
        taskQueue = loadTasks();

        Label heading =
                new Label("SMART TASK SCHEDULAR");

        heading.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        titleField = new TextField();
        titleField.setPromptText("Enter task title");

        priorityBox = new ComboBox<>();
        priorityBox.getItems().addAll(
                "High",
                "Medium",
                "Low"
        );
        priorityBox.setValue("Medium");

        deadlineField = new TextField();
        deadlineField.setPromptText("DD-MM-YYYY");

        taskList = new ListView<>();
        taskList.setItems(displayTasks);

        Button addButton =
                new Button("Add Task");

        Button editButton =
                new Button("Edit Task");

        Button deleteButton =
                new Button("Delete Task");

        Button completeButton =
                new Button("Complete Task");

        Button saveButton =
                new Button("Save Tasks");

        // ADD
        addButton.setOnAction(e -> addTask());

        // EDIT
        editButton.setOnAction(e -> editTask());

        // DELETE
        deleteButton.setOnAction(e -> deleteTask());

        // COMPLETE
        completeButton.setOnAction(e -> completeTask());

        // SAVE
        saveButton.setOnAction(e -> saveTasks());

        /*
         * When the user clicks a task,
         * load its information into the fields.
         */
        taskList.setOnMouseClicked(e -> loadSelectedTask());

        GridPane form = new GridPane();

        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Task Title:"), 0, 0);
        form.add(titleField, 1, 0);

        form.add(new Label("Priority:"), 0, 1);
        form.add(priorityBox, 1, 1);

        form.add(new Label("Deadline:"), 0, 2);
        form.add(deadlineField, 1, 2);

        HBox buttons = new HBox(10);

        buttons.getChildren().addAll(
                addButton,
                editButton,
                deleteButton,
                completeButton,
                saveButton
        );

        VBox root = new VBox(15);

        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                heading,
                form,
                buttons,
                new Label("Tasks by Priority:"),
                taskList
        );

        refreshTaskList();

        Scene scene =
                new Scene(root, 850, 550);

        stage.setTitle("Smart Task Schedular");

        stage.setScene(scene);

        stage.show();

        stage.setOnCloseRequest(e -> saveTasks());
    }

    // ADD TASK
    private void addTask() {

        String title =
                titleField.getText().trim();

        String priority =
                priorityBox.getValue();

        String deadline =
                deadlineField.getText().trim();

        if (title.isEmpty() ||
                deadline.isEmpty()) {

            showMessage(
                    "Please enter task title and deadline."
            );

            return;
        }

        Task task =
                new Task(
                        title,
                        priority,
                        deadline
                );

        taskQueue.add(task);

        saveTasks();

        refreshTaskList();

        clearFields();

        showMessage(
                "Task added successfully!"
        );
    }

    // LOAD SELECTED TASK
    private void loadSelectedTask() {

        int selected =
                taskList
                        .getSelectionModel()
                        .getSelectedIndex();

        if (selected < 0) {
            return;
        }

        ArrayList<Task> sortedTasks =
                new ArrayList<>(taskQueue);

        sortedTasks.sort(null);

        if (selected >= sortedTasks.size()) {
            return;
        }

        Task task =
                sortedTasks.get(selected);

        titleField.setText(
                task.getTitle()
        );

        priorityBox.setValue(
                task.getPriority()
        );

        deadlineField.setText(
                task.getDeadline()
        );
    }

    // EDIT TASK
    private void editTask() {

        int selected =
                taskList
                        .getSelectionModel()
                        .getSelectedIndex();

        if (selected < 0) {

            showMessage(
                    "Select a task first."
            );

            return;
        }

        String title =
                titleField.getText().trim();

        String priority =
                priorityBox.getValue();

        String deadline =
                deadlineField.getText().trim();

        if (title.isEmpty() ||
                deadline.isEmpty()) {

            showMessage(
                    "Please enter title and deadline."
            );

            return;
        }

        ArrayList<Task> sortedTasks =
                new ArrayList<>(taskQueue);

        sortedTasks.sort(null);

        Task oldTask =
                sortedTasks.get(selected);

        taskQueue.remove(oldTask);

        taskQueue.add(
                new Task(
                        title,
                        priority,
                        deadline
                )
        );

        saveTasks();

        refreshTaskList();

        clearFields();

        showMessage(
                "Task updated successfully!"
        );
    }

    // DELETE TASK
    private void deleteTask() {

        int selected =
                taskList
                        .getSelectionModel()
                        .getSelectedIndex();

        if (selected < 0) {

            showMessage(
                    "Select a task first."
            );

            return;
        }

        ArrayList<Task> sortedTasks =
                new ArrayList<>(taskQueue);

        sortedTasks.sort(null);

        Task task =
                sortedTasks.get(selected);

        taskQueue.remove(task);

        saveTasks();

        refreshTaskList();

        clearFields();

        showMessage(
                "Task deleted successfully!"
        );
    }

    // COMPLETE TASK
    private void completeTask() {

        if (taskQueue.isEmpty()) {

            showMessage(
                    "No tasks available."
            );

            return;
        }

        Task task =
                taskQueue.poll();

        saveTasks();

        refreshTaskList();

        clearFields();

        showMessage(
                "Completed Task:\n\n" + task
        );
    }

    // REFRESH LIST
    private void refreshTaskList() {

        displayTasks.clear();

        ArrayList<Task> sortedTasks =
                new ArrayList<>(taskQueue);

        sortedTasks.sort(null);

        for (Task task : sortedTasks) {

            displayTasks.add(
                    task.toString()
            );
        }
    }

    // SAVE
    private void saveTasks() {

        try (
                PrintWriter writer =
                        new PrintWriter(
                                new FileWriter(FILE_NAME)
                        )
        ) {

            ArrayList<Task> sortedTasks =
                    new ArrayList<>(taskQueue);

            sortedTasks.sort(null);

            for (Task task : sortedTasks) {

                writer.println(
                        task.getTitle()
                                .replace("|", "/")
                                + "|"
                                + task.getPriority()
                                + "|"
                                + task.getDeadline()
                );
            }

        } catch (IOException e) {

            showMessage(
                    "Error saving tasks:\n"
                            + e.getMessage()
            );
        }
    }

    // LOAD
    private PriorityQueue<Task> loadTasks() {

        PriorityQueue<Task> queue =
                new PriorityQueue<>();

        File file =
                new File(FILE_NAME);

        if (!file.exists()) {
            return queue;
        }

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(file)
                        )
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split("\\|");

                if (data.length == 3) {

                    queue.add(
                            new Task(
                                    data[0],
                                    data[1],
                                    data[2]
                            )
                    );
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading tasks: "
                            + e.getMessage()
            );
        }

        return queue;
    }

    // CLEAR
    private void clearFields() {

        titleField.clear();

        deadlineField.clear();

        priorityBox.setValue("Medium");

        taskList.getSelectionModel().clearSelection();
    }

    // MESSAGE
    private void showMessage(String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(
                "Smart Task Schedular"
        );

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void main(String[] args) {

        launch(args);
    }
}