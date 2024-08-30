package Task_Tracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task_Manager {
    private static final String FILE_PATH = "tasks.json";
    private static final Gson gson = new Gson();

    public static void saveTasks(List<Task> tasks) throws IOException {
        String json = gson.toJson(tasks);
        Files.write(Paths.get(FILE_PATH), json.getBytes());
    }

    public static List<Task> loadTasks() throws IOException {
        List<Task> tasks = new ArrayList<>();
        if (Files.exists(Paths.get(FILE_PATH))) {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            Type taskListType = new TypeToken<ArrayList<Task>>() {}.getType();
            tasks = gson.fromJson(content, taskListType);
        }
        return tasks;
    }
}
