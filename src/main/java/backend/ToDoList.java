package backend;

import backend.Task.Task;
import backend.Task.ToDoTask;
import backend.Task.DeadlineTask;
import backend.Task.EventTask;

import java.util.ArrayList;
import static frontend.Format.HORIZONTAL_LINE;

/**
 * Represents a list that serves as the database for the tasks.
 * Prints responses in response to commands as well.
 */
public class ToDoList {
    ArrayList<Task> toDoList = new ArrayList();

    /**
     * Creates a new ToDoTask and adds it to the toDoList.
     * Prints message to inform user that task has been added.
     *
     * @param description name of the task
     */
    public void createToDoTask(String description){
        ToDoTask toDo = new ToDoTask(description);
        toDoList.add(toDo);
        System.out.println(HORIZONTAL_LINE + "\n"
                + "I have added the following ToDo to your list: "+ description + "\n"
                + HORIZONTAL_LINE);
    }

    /**
     * Creates a new DeadlineTask and adds it to the toDoList.
     * Prints message to inform user that task has been added.
     *
     * @param description name of the task
     * @param toBeCompletedBy the time that the task must be completed by
     */
    public void createDeadlineTask(String description, String toBeCompletedBy){
        Task deadline = new DeadlineTask(description, toBeCompletedBy);
        toDoList.add(deadline);
        System.out.println(HORIZONTAL_LINE + "\n"
                + "I have added the following Deadline to your list: "+ description + "\n"
                + HORIZONTAL_LINE);
    }

    /**
     * Creates a new EventTask and adds it to the toDoList.
     * Prints message to inform user that task has been added.
     *
     * @param description name of the task
     * @param startTime the time that the event starts
     * @param startTime the time that the event ends
     */
    public void createEventTask(String description, String startTime, String endTime){
        Task event = new EventTask(description, startTime, endTime);
        toDoList.add(event);
        System.out.println(HORIZONTAL_LINE + "\n"
                + "I have added the following Event to your list: "+ description + "\n"
                + HORIZONTAL_LINE);
    }

    /**
     * Prints the index and string representation of every task in the toDoList.
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
    public void markTaskAsDone(int index) {
        try {
            Task task = toDoList.get(index - 1);
            task.markAsDone();
            System.out.println(HORIZONTAL_LINE + "\n");
            System.out.println("Well done, I have marked " + task + " as done.");
            System.out.println(HORIZONTAL_LINE + "\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(HORIZONTAL_LINE + "\n");
            System.out.println("I do not have this task in my list.");
            System.out.println(HORIZONTAL_LINE + "\n");
        }
    }

    /**
     * Marks tasks in the list as done.
     * If the task does not exist, informs user that the task does not exist.
     *
     * @param index the index of the task in the <code>ArrayList toDoList</code>
     */
    public void unmarkTaskAsDone (int index) {
        try {
            Task task = toDoList.get(index - 1);
            task.unmarkAsDone();
            System.out.println(HORIZONTAL_LINE + "\n");
            System.out.println("Understood, I have unmarked " + task + " as done.");
            System.out.println(HORIZONTAL_LINE + "\n");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(HORIZONTAL_LINE + "\n");
            System.out.println("I do not have this task in my list.");
            System.out.println(HORIZONTAL_LINE + "\n");
            }
        }

    /**
     * Removes tasks in the list as done.
     * If the task does not exist, informs user that the task does not exist.
     *
     * @param index the index of the task in the <code>ArrayList toDoList</code>
     */
    public void removeTask (int index) {
        if (toDoList.remove(index - 1) == null) {
            System.out.println(HORIZONTAL_LINE + "\n");
            System.out.println("I do not have this task in my list.");
            System.out.println(HORIZONTAL_LINE + "\n");
        } else {
            Task task = toDoList.remove(index - 1);
            System.out.println(HORIZONTAL_LINE + "\n");
            System.out.println("Understood, I have unmarked " + task + " as done.");
            System.out.println(HORIZONTAL_LINE + "\n");
        }

    }
}
