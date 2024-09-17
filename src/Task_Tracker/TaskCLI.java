package Task_Tracker;

import java.util.Scanner;

public class TaskCLI {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Task Tracker CLI");
        System.out.println("Type 'help' for a list of commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] commandArgs = input.split(" ", 2);

            if (commandArgs.length < 1) {
                System.out.println("Usage: <command> [<args>]");
                continue;
            }

            String command = commandArgs[0];
            switch (command) {
                case "add":
                    if (commandArgs.length < 2) {
                        System.out.println("Usage: add <description>");
                    } else {
                        taskManager.addTask(commandArgs[1]);
                    }
                    break;
                case "update":
                    if (commandArgs.length < 2) {
                        System.out.println("Usage: update <id> <description>");
                    } else {
                        String[] updateArgs = commandArgs[1].split(" ", 2);
                        if (updateArgs.length < 2) {
                            System.out.println("Usage: update <id> <description>");
                        } else {
                            taskManager.updateTask(Integer.parseInt(updateArgs[0]), updateArgs[1]);
                        }
                    }
                    break;
                case "delete":
                    if (commandArgs.length < 2) {
                        System.out.println("Usage: delete <id>");
                    } else {
                        taskManager.deleteTask(Integer.parseInt(commandArgs[1]));
                    }
                    break;
                case "mark-in-progress":
                    if (commandArgs.length < 2) {
                        System.out.println("Usage: mark-in-progress <id>");
                    } else {
                        taskManager.markTask(Integer.parseInt(commandArgs[1]), "in-progress");
                    }
                    break;
                case "mark-done":
                    if (commandArgs.length < 2) {
                        System.out.println("Usage: mark-done <id>");
                    } else {
                        taskManager.markTask(Integer.parseInt(commandArgs[1]), "done");
                    }
                    break;
                case "list":
                    if (commandArgs.length < 2) {
                        taskManager.listTasks(null);
                    } else {
                        taskManager.listTasks(commandArgs[1]);
                    }
                    break;
                case "help":
                    System.out.println("Available commands:");
                    System.out.println("1. add <description>");
                    System.out.println("2. update <id> <description>");
                    System.out.println("3. delete <id>");
                    System.out.println("4. mark-in-progress <id>");
                    System.out.println("5. mark-done <id>");
                    System.out.println("6. list [status]");
                    System.out.println("7. help");
                    System.out.println("8. exit");
                    break;
                case "exit":
                    System.out.println("Exiting Task Tracker CLI.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
        }
    }
}
