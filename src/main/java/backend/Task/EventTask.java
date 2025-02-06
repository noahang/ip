package backend.task;
import backend.IllegalStartAndEndDateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an event task. A <code>EventTask<code> object has
 * a <code>description<code> String startTime that is the time that the event starts and
 * a <code>description<code> String endTime that is the time that the event ends
 */
public class EventTask extends Task {

    protected LocalDate startTime;
    protected LocalDate endTime;

    /**
     * Constructor for an Event object
     *
     * @param description name of the task
     * @param startTime time that the task starts
     * @param endTime time that the task ends
     *
     * @throws DateTimeParseException if string is in an invalid format
     * @throws IllegalArgumentException if startTime is after endTime
     */
    public EventTask(String description, String startTime, String endTime)
            throws DateTimeParseException, IllegalStartAndEndDateException {
        super(description);
        this.startTime = LocalDate.parse(startTime);
        this.endTime = LocalDate.parse(endTime);
        if (this.startTime.isAfter(this.endTime)) {
            throw new IllegalStartAndEndDateException(this.startTime, this.endTime);
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()
                + " (start: " + this.startTime.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
                + ", end: " + this.endTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
