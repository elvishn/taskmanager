import java.time.Instant;

public class Task {
    private static int counter = 0;
    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private final Instant createdAt;

    public Task(String title, String description) {
        this.id = ++counter;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = Instant.now();

    }

    public void setTitle(String s) {
        title = s;
    }

    public void setDescription(String d) {
        description = d;
    }

    public void setStatus(TaskStatus st) {
        status = st;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void toPrint() {
        System.out.println(getId() + " " +
                getTitle() + " " +
                getStatus() + " " +
                getDescription() + " " +
                getCreatedAt() + " ");

    }
}
