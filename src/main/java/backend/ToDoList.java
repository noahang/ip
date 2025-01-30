package backend;

import java.util.HashMap;
import static frontend.Format.HORIZONTAL_LINE;
import java.lang.IllegalArgumentException;

/**
 * Creates a new Task and adds it to the toDoList
 * Updates numOfTasks
 * Sets index of this new Task accordingly in the toDoList
 */
public class ToDoList {
    HashMap<Integer,Task> toDoList = new HashMap<>();

    /**
     * Creates a new Task and adds it to the toDoList
     * The Key is the index of the task
     * The Value is the task
     * Prints message to inform user that task has been added
     */
    public void createTask(String taskName){
        Task task = new Task(taskName);
        toDoList.put(toDoList.size() + 1, task);
        System.out.println(HORIZONTAL_LINE + "\n"
                + "I have added the following task to your list: "+ taskName + "\n"
                + HORIZONTAL_LINE);
    }

    /**
     * Prints the index and string representation of every task in the toDoList
     */
    public void showList(){
        System.out.println(HORIZONTAL_LINE + "\n");
        toDoList.forEach((key,value) ->
                System.out.println(key.toString() + ". " + value.toString() + "\n"));
        System.out.println(HORIZONTAL_LINE + "\n");
    }

    public void markTaskAsDone(int index){
        if (toDoList.get(index) == null) {
            System.out.println("I do not have this task in my list.");
        } else {
            Task task = toDoList.get(index);
            task.markAsDone();
            System.out.println("Well done, I have marked " + task.toString() + "as done.");
        }
    }
}
