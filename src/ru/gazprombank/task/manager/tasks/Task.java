package ru.gazprombank.task.manager.tasks;

import java.time.Instant;

public class Task {
    private final String title;
    private final String description;
    private  TaskStatus status;
    private final Instant createdAt;

    protected Task(int id, String title, String description) {
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = Instant.now();
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

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void toPrint() {
        System.out.println(
                getTitle() + " " +
                getStatus() + " " +
                getDescription() + " " +
                getCreatedAt() + " ");

    }
}
