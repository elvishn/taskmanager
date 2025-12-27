package ru.gazprombank.task.manager.tasks;

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
            String command = sc.next();
            if (command.equalsIgnoreCase("help")) {
                printHelp();
                continue;
            }

            else if (command.equalsIgnoreCase("tasklist")) {
                manager.printTasks();
                continue;
            }

            else if (command.equalsIgnoreCase("exit")) {
                System.out.println("You are closed program. Goodbye!");
                running = false;
                ;
            }
            else {System.out.println("Choose correct command!");
            continue;}
        }
    }

    public void printHelp() {
        System.out.println("/help: command description");
        System.out.println("/TaskList: List with all the tasks");
        System.out.println("/Exit: Close program");
    }
}
