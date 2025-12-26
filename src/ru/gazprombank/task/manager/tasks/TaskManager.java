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

    public void printTasks() {
        for (Integer i: tasks.keySet()) {
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
}
