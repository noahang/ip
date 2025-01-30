package backend.Task;

import backend.Task.Task;

/**
 * Represents an event task. A <code>EventTask<code> object has a
 * <code>description<code> String startTime that is the time that the event starts
 * <code>description<code> String endTime that is the time that the event ends
 */
public class EventTask extends Task {

    protected String startTime;
    protected String endTime;

    /**
     * Constructor for an Event object
     * <p>
     * @param description name of the task
     * @param startTime time that the task starts
     * @param endTime time that the task ends
     */
    public EventTask(String description, String startTime, String endTime) {
        super(description);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (start: " + this.startTime + ", end: " + this.endTime + ")";
    }
}
