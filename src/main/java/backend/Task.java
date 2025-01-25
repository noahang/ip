package backend;

public class Task {
    String taskName;
    String status;
    Task(String taskName) {
        this.taskName = taskName;
    }


    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return this.status;
    }
}
