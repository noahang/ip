package backend.Task;

import backend.Task.Task;

/**
 * Represents a task with a deadline. A <code>DeadlineTask<code> object has a
 * <code>description<code> String toBeCompletedBy that is the time that the task must be completed by
 */
public class DeadlineTask extends Task {

    protected String toBeCompletedBy;

    /**
     * @param description name of the task
     * @param toBeCompletedBy the time that the task must be completed by
     */
    public DeadlineTask(String description, String toBeCompletedBy) {
        super(description);
        this.toBeCompletedBy = toBeCompletedBy;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.toBeCompletedBy + ")";
    }
}
