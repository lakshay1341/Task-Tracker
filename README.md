---
https://roadmap.sh/projects/task-tracker

# Task Tracker CLI

## Overview
Task Tracker CLI is a command-line interface application designed to help you manage your tasks efficiently. This project allows you to add, update, delete, and list tasks, storing them in a JSON file for persistence.

## Features
- **Add Tasks**: Create new tasks with a unique ID and description.
- **Update Tasks**: Modify the description and status of existing tasks.
- **Delete Tasks**: Remove tasks by their ID.
- **List Tasks**: Display all tasks with their details.

## Technologies Used
- **Java**: Core language for building the application.
- **Gson**: Library for JSON serialization and deserialization.
- **Java NIO**: For file handling operations.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) installed
- Gson library JAR file

### Installation
1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/task-tracker-cli.git
   ```
2. **Navigate to the project directory**:
   ```sh
   cd task-tracker-cli
   ```
3. **Add the Gson library**:
   - Download the Gson library JAR file from [here](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.9/gson-2.8.9.jar).
   - Place the JAR file in the project directory.

4. **Compile the project**:
   ```sh
   javac -cp gson-2.8.9.jar:. *.java
   ```
5. **Run the application**:
   ```sh
   java -cp gson-2.8.9.jar:. TaskCLI
   ```

## Usage

### Add a Task
```sh
java -cp gson-2.8.9.jar:. TaskCLI add "Your task description"
```

### Update a Task
```sh
java -cp gson-2.8.9.jar:. TaskCLI update 1 "Updated task description"
```

### Delete a Task
```sh
java -cp gson-2.8.9.jar:. TaskCLI delete 1
```

### List All Tasks
```sh
java -cp gson-2.8.9.jar:. TaskCLI list
```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
