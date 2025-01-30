package backend;

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Represents a task. A <code>Task<code> object has
     * a <code>description<code> String member that is the name of the task
     * a <code>isDone<code> boolean member that represents whether the task is completed or not
     */
    Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    
    public String getTaskName() {
        return description;
    }

}
