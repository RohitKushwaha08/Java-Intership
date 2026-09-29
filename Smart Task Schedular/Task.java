import java.io.Serializable;

public class Task implements Comparable<Task>, Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String priority;
    private String deadline;

    public Task(String title, String priority, String deadline) {
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public String getDeadline() {
        return deadline;
    }

    private int priorityValue() {
        switch (priority.toLowerCase()) {
            case "high":
                return 1;
            case "medium":
                return 2;
            case "low":
                return 3;
            default:
                return 4;
        }
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(
                this.priorityValue(),
                other.priorityValue()
        );
    }

    @Override
    public String toString() {
        return title
                + " | Priority: "
                + priority
                + " | Deadline: "
                + deadline;
    }
}