package backend;

/**
 * Represents a task. A <code>Task<code> object has
 * a <code>description<code> String member that is the name of the task
 * a <code>isDone<code> boolean member that represents whether the task is completed or not
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for a Task object
     * <p>
     * <code>boolean  isDone</code> is set to false by default
     * because we assume the task is not completed at the time of adding to the list
     * @param description name of the task
     */
    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return (isDone
                ? "[X] " + this.description
                : "[ ] " + this.description);
    }

    /**
     * Marks a task as done
     * <p>
     * Even if the task is already done, this method will not throw an exception
     */
    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }
}
