package ru.gazprombank.task.manager.tasks;

import java.util.Map;
import java.util.Scanner;

public class ConsoleUI {
    private final TaskManager manager;
    boolean running = true;
    Scanner sc = new Scanner(System.in);

    public ConsoleUI(TaskManager manager) {
        this.manager = manager;
    }

    public void start() {
        System.out.println("Choose command: ");
        printHelp();

        while (running) {
            String command = sc.nextLine().trim();
            if (command.isEmpty()) {
                continue;}
            if (command.equalsIgnoreCase("help")) {
                printHelp();
                continue;
            }

            else if (command.equalsIgnoreCase("tasklist")) {
                manager.printTasks();
                continue;
            }

            else if (command.equalsIgnoreCase("add")) {
                System.out.println("Write your task:");
                add();
                continue;
            }

            else if (command.equalsIgnoreCase("delete")) {
                System.out.println("Write task id:");
                delete();
                continue;
            }

            else if (command.equalsIgnoreCase("exit")) {
                System.out.println("You are closed program. Goodbye!");
                running = false;
            }

            else if (command.equalsIgnoreCase("status")) {
                System.out.println("Write id and status (in a new line)");
                status();
                continue;
            }

            else if (command.equalsIgnoreCase("filter")) {
                System.out.println("Write status for filter");
                String filter = sc.nextLine();
                filter(filter);
                continue;
            }

            else if (command.equalsIgnoreCase("search")) {
                System.out.println("Write word or phrase for search");
                String word = sc.nextLine();
                search(word);
                continue;
            }

            else {System.out.println("Choose correct command!");
            continue;}
        }
    }

    public void printHelp() {
        System.out.println("/help: command description");
        System.out.println("/TaskList: List with all the tasks");
        System.out.println("/Exit: Close program");
        System.out.println("/Add: Add a new task. Write your task in format TASK, DESCRIPTION");
        System.out.println("/Delete: Delete task by id. Write task id");
        System.out.println("/Status: Change status TODO, IN_PROGRESS, DONE by id");
        System.out.println("/Filter: Choose status TODO, IN_PROGRESS, DONE for task list");
        System.out.println("/Search: Search task by title or description");


    }

    public void add() {
        String s = sc.nextLine();
        String[] lst = s.split(",");
        if (lst.length == 2) {
            manager.addTask(lst[0], lst[1]);
            System.out.println("ADD NEW TASK: " + lst[0]);
        }
        else {System.out.println("Write correct task!");}
    }

    public void delete() {
        int id = sc.nextInt();
        Map<Integer, Task> taski = manager.getAllTask();
        if (taski.get(id) != null) {
            manager.getAllTask().remove(id);
            System.out.println("Task " + id + " was delete!");
        }
        else {System.out.println("Task is not found!");}
    }

    public void status() {
        int id = Integer.parseInt(sc.nextLine());
        String stat = sc.nextLine().toUpperCase();
        Task task = manager.getAllTask().get(id);
        manager.updateTaskStatus(id, stat);
    }

    public void filter(String status) {
        Map <Integer, Task> filterTask = manager.getTaskByStatus(status.trim());
        manager.printTasks(filterTask);
    }

    public void search(String word) {
        Map <Integer, Task> searchList = manager.searchTasks(word.trim());
        manager.printTasks(searchList);
    }
}
