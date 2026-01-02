package ru.gazprombank.task.manager.tasks;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private final Map<Integer, Task> tasks = new HashMap();
    private int counter = 0;

    public void addTask(String title, String description) {
        this.counter += 1;
        Task newTask = new Task(counter, title, description);
        tasks.put(counter, newTask);
    }

    public Map<Integer, Task> getAllTask() {
        return tasks;
    }

    public Task findTaskById(int id) {
        return tasks.get(id);
    }

    public void printTasks(Map <Integer, Task> myMap) {
        for(Integer i: myMap.keySet()) {
            System.out.print(i + " ");
            myMap.get(i).toPrint();
        }
    }

    public void printTasks() {
        for(Integer i: tasks.keySet()) {
            System.out.print(i + " ");
            tasks.get(i).toPrint();
        }
    }

    public void deleteTask(int id) {
        for (Integer i : tasks.keySet()) {
            if (i == id) {
                tasks.remove(i);
                break;
            }
        }
    }

    public void updateTaskStatus(int id, String status) {
        Task task = tasks.get(id);
        try {
            TaskStatus verifiedStatus = TaskStatus.valueOf(status.toUpperCase());
            if (task != null) {
                task.setStatus(verifiedStatus);
                System.out.println("Task " + id + " change status. New status is " + verifiedStatus);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Status isn't found. Try again.");
        }
    }

    public Map<Integer, Task> getTaskByStatus(String status) {
        Map<Integer, Task> tasksByStatus = new HashMap<>();
        try {
            TaskStatus verifiedStatus = TaskStatus.valueOf(status.toUpperCase());
            for(Integer i : tasks.keySet()) {
                Task x = tasks.get(i);
                if (x.getStatus() == verifiedStatus) {
                    tasksByStatus.put(i, x);
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Status isn't found. Try again.");
        }
        return tasksByStatus;
    }

    public Map<Integer, Task> searchTasks(String keyword) {
        Map<Integer, Task> searchResult = new HashMap<>();
        for(Integer i : tasks.keySet()) {
            Task x = tasks.get(i);
            if (x.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    x.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                searchResult.put(i, x);
            }
        }
        return searchResult;
    }
}
