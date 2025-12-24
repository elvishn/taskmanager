//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    TaskManager manager = new TaskManager();
    manager.addTask("Learn English", "Listening");
    manager.addTask("Codding", "Write CRUD");
    manager.addTask("Sport", "Running");
    ArrayList<Task> tasks = manager.getAllTask();
    for (Task i: tasks) {i.toPrint();}
    manager.findTaskById(2).toPrint();
    manager.deleteTask(2);
    ArrayList<Task> tasks2 = manager.getAllTask();
    for (Task i: tasks2) {i.toPrint();}
}
