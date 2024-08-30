package Task_Tracker;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Task_CLI {
    private static List<Task> tasks;
    private static int nextId = 1;

    public static void main(String[] args) {
        try {
            tasks = Task_Manager.loadTasks();
            if (!tasks.isEmpty()) {
                nextId = tasks.get(tasks.size() - 1).getId() + 1;
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ", 2);
            switch (parts[0]) {
                case "add":
                    addTask(parts[1]);
                    break;
                case "update":
                    updateTask(parts[1]);
                    break;
                case "delete":
                    deleteTask(parts[1]);
                    break;
                case "list":
                    listTasks();
                    break;
                case "exit":
                    saveAndExit();
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private static void addTask(String description) {
        Task task = new Task(nextId++, description);
        tasks.add(task);
        System.out.println("Task added successfully (ID: " + task.getId() + ")");
    }

    private static void updateTask(String input) {
        String[] parts = input.split(" ", 2);
        int id = Integer.parseInt(parts[0]);
        String description = parts[1];
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(description);
                task.setUpdatedAt(LocalDateTime.now());
                System.out.println("Task updated successfully");
                return;
            }
        }
        System.out.println("Task not found");
    }

    private static void deleteTask(String input) {
        int id = Integer.parseInt(input);
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted successfully");
    }

    private static void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void saveAndExit() {
        try {
            Task_Manager.saveTasks(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}
