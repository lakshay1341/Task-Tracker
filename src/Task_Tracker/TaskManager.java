package Task_Tracker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.time.LocalDateTime;

public class TaskManager {
    private List<Task> tasks;
    private static final String FILE_PATH = "tasks.json";
    private Gson gson;

    public TaskManager() {
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        tasks = loadTasks();
    }

    private List<Task> loadTasks() {
        try {
            if (Files.exists(Paths.get(FILE_PATH))) {
                String json = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
                return gson.fromJson(json, new TypeToken<List<Task>>(){}.getType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void saveTasks() {
        try {
            String json = gson.toJson(tasks);
            Files.write(Paths.get(FILE_PATH), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTask(String description) {
        int id = tasks.size() + 1;
        Task task = new Task(id, description);
        tasks.add(task);
        saveTasks();
        System.out.println("Task added successfully (ID: " + id + ")");
    }

    public void updateTask(int id, String description) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(description);
                task.setUpdatedAt(LocalDateTime.now());
                saveTasks();
                System.out.println("Task updated successfully (ID: " + id + ")");
                return;
            }
        }
        System.out.println("Task not found (ID: " + id + ")");
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        saveTasks();
        System.out.println("Task deleted successfully (ID: " + id + ")");
    }

    public void markTask(int id, String status) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(status);
                task.setUpdatedAt(LocalDateTime.now());
                saveTasks();
                System.out.println("Task marked as " + status + " (ID: " + id + ")");
                return;
            }
        }
        System.out.println("Task not found (ID: " + id + ")");
    }

    public void listTasks(String status) {
        for (Task task : tasks) {
            if (status == null || task.getStatus().equals(status)) {
                System.out.println(task);
            }
        }
    }
}
