package backend;

import backend.exceptions.IllegalStartAndEndDateException;
import backend.task.Task;
import backend.task.ToDoTask;
import backend.task.DeadlineTask;
import backend.task.EventTask;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Represents a list that serves as the database for the tasks.
 * Prints responses in response to commands as well.
 * Index starts from O, but will be printed as starting from 1 in showList().
 */
public class ToDoList {

    public static final String HORIZONTAL_LINE =
            "____________________________________________________________";
    ArrayList<Task> toDoList = new ArrayList<>();

    /**
     * Creates a new ToDoTask and adds it to the toDoList.
     * Prints message to inform user that task has been added.
     *
     * @param description name of the task
     */
    public void createToDoTask(String description) {
        ToDoTask toDo = new ToDoTask(description);
        toDoList.add(toDo);
    }

    /**
     * Creates a new DeadlineTask and adds it to the toDoList.
     * Prints message to inform user that task has been added.
     *
     * @param description name of the task
     * @param toBeCompletedBy the time that the task must be completed by
     */
    public void createDeadlineTask(String description, String toBeCompletedBy)
            throws DateTimeParseException {
        Task deadline = new DeadlineTask(description, toBeCompletedBy);
        toDoList.add(deadline);
    }

    /**
     * Creates a new EventTask and adds it to the toDoList.
     * Prints message to inform user that task has been added.
     *
     * @param description name of the task
     * @param startTime the time that the event starts
     * @param endTime the time that the event ends
     */
    public void createEventTask(String description, String startTime, String endTime)
            throws DateTimeParseException, IllegalStartAndEndDateException {
        Task event = new EventTask(description, startTime, endTime);
        toDoList.add(event);
        System.out.println(HORIZONTAL_LINE + "\n"
                + "I have added the following Event to your list: "+ description + "\n"
                + HORIZONTAL_LINE);
    }

    /**
     * Prints the index and string representation of every task in the toDoList.
     * Index starts from 0 in ArrayList, but will be printed out as starting from 1.
     */
    public void showList() {
        System.out.println(HORIZONTAL_LINE + "\n");
        toDoList.forEach((task) ->
                System.out.println(toDoList.indexOf(task) + 1 + ". " + task.toString() + "\n"));
        System.out.println(HORIZONTAL_LINE + "\n");
    }

    /**
     * Marks tasks in the list as done.
     * If the task does not exist, informs user that the task does not exist.
     *
     * @param index the index of the task in the <code>ArrayList toDoList</code>
     */
    public void markTaskAsDone(int index) throws IndexOutOfBoundsException {
        Task task = toDoList.get(index);
        task.markAsDone();
        System.out.println(HORIZONTAL_LINE + "\n");
        System.out.println("Well done, I have marked " + task + " as done.");
        System.out.println(HORIZONTAL_LINE + "\n");
    }

    /**
     * Marks tasks in the list as done.
     * If the task does not exist, informs user that the task does not exist.
     *
     * @param index the index of the task in the <code>ArrayList toDoList</code>
     */
    public void unmarkTaskAsDone (int index) throws IndexOutOfBoundsException {
        Task task = toDoList.get(index);
        task.unmarkAsDone();
        System.out.println(HORIZONTAL_LINE + "\n");
        System.out.println("Understood, I have unmarked " + task + " as done.");
        System.out.println(HORIZONTAL_LINE + "\n");
    }

    /**
     * Delete a task in the list.
     * If the task does not exist, informs user that the task does not exist.
     *
     * @param index the index of the task in the <code>ArrayList toDoList</code>
     */
    public void deleteTask(int index) throws IndexOutOfBoundsException {
        Task task = toDoList.remove(index);
        System.out.println(HORIZONTAL_LINE + "\n");
        System.out.println("Very well, I have deleted " + task + " .");
        System.out.println(HORIZONTAL_LINE + "\n");
    }

    public Task getTask(int index) {
        return toDoList.get(index);
    }

    public int getLength() {
        return this.toDoList.size();
    }

    @Override public String toString() {
        StringBuilder temp = new StringBuilder();
        for (Task task : toDoList) {
            temp.append(task.toString()).append("\n");
        }
        return temp.toString();
    }
}
