import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task6 extends JFrame {

    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public Task6() {

        setTitle("To-Do List App");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        JLabel titleLabel = new JLabel(
                "My To-Do List",
                SwingConstants.CENTER
        );
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(taskList);

        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.PAGE_START);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add Task
        addButton.addActionListener(e -> {

            String task = taskField.getText().trim();

            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a task!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        // Delete Task
        deleteButton.addActionListener(e -> {

            int selectedIndex = taskList.getSelectedIndex();

            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Please select a task to delete!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        // Press Enter to add task
        taskField.addActionListener(e -> addButton.doClick());

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Task6();
        });
    }
}