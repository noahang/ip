package backend.Task;

import backend.Task.Task;

/**
 * Represents a task without a start date or a deadline.
 */
public class ToDoTask extends Task {

    /**
     * Constructor for a Task object
     */
    public ToDoTask(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
