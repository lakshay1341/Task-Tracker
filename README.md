### Task Tracker

```markdown
# Task Tracker

Task Tracker is a simple command line interface (CLI) application to track and manage your tasks. This project helps you practice your programming skills, including working with the filesystem, handling user inputs, and building a simple CLI application.

## Features

- Add, update, and delete tasks
- Mark tasks as in progress or done
- List all tasks
- List tasks by status (done, todo, in-progress)

## Requirements

- Java 8 or higher
- Gson library

## Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/lakshay1341/Task-Tracker.git
   cd Task-Tracker
   ```

2. **Download the Gson library:**

   Download the Gson library from [here](https://github.com/google/gson) and place the JAR file in your project directory.

3. **Compile the Java files:**

   ```sh
   javac -cp .:gson-2.8.6.jar *.java
   ```

## Usage

Run the application in interactive mode:

```sh
java -cp .:gson-2.8.6.jar TaskCLI
```

### Commands

- **Add a new task:**

  ```sh
  add "Buy groceries"
  ```

- **Update a task:**

  ```sh
  update 1 "Buy groceries and cook dinner"
  ```

- **Delete a task:**

  ```sh
  delete 1
  ```

- **Mark a task as in progress:**

  ```sh
  mark-in-progress 1
  ```

- **Mark a task as done:**

  ```sh
  mark-done 1
  ```

- **List all tasks:**

  ```sh
  list
  ```

- **List tasks by status:**

  ```sh
  list done
  list todo
  list in-progress
  ```

### Example

```sh
> add "Buy groceries"
Task added successfully (ID: 1)
> list
Task{id=1, description='Buy groceries', status='todo', createdAt=2024-09-16T20:12:01, updatedAt=2024-09-16T20:12:01}
> mark-in-progress 1
Task marked as in-progress (ID: 1)
> list in-progress
Task{id=1, description='Buy groceries', status='in-progress', createdAt=2024-09-16T20:12:01, updatedAt=2024-09-16T20:12:01}
> exit
Exiting Task Tracker CLI.
```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- https://roadmap.sh/projects/task-tracker
- [Gson](https://github.com/google/gson) for JSON parsing
- Java for providing a robust programming language
---
