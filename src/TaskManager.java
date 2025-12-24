import java.util.ArrayList;

public class TaskManager {
    static ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String title, String description) {
        Task new_task = new Task(title, description);
        tasks.add(new_task);
    }

    public ArrayList<Task> getAllTask() { return tasks;}

    public Task findTaskById(int id) {
        for (Task i: tasks) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void deleteTask(int id) {
        for (Task i: tasks) {
            if (i.getId() == id) {
                tasks.remove(i);
                break;
            }
        }
    }
}
