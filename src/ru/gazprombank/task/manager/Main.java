import ru.gazprombank.task.manager.tasks.Task;
import ru.gazprombank.task.manager.tasks.TaskManager;

import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    TaskManager manager = new TaskManager();
    manager.addTask("Learn English", "Listening");
    manager.addTask("Codding", "Write CRUD");
    manager.addTask("Sport", "Running");
    manager.printTasks();

    manager.findTaskById(2).toPrint();
    manager.deleteTask(2);
    Map<Integer, Task> tasks2 = manager.getAllTask();

}
