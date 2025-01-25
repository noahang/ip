package backend;

import java.util.HashMap;
import static frontend.Format.HORIZONTAL_LINE;

public class ToDoList {
    HashMap<Integer,Task> toDoList = new HashMap<>();
    int numOfTasks = 0;

    /**
     * Creates a new Task and adds it to the toDoList
     * Updates numOfTasks
     * Sets index of this new Task accordingly in the toDoList
     */
    public void createTask(String taskName){
        Task task = new Task(taskName);
        numOfTasks++;
        toDoList.put(numOfTasks, task);
        System.out.println(HORIZONTAL_LINE + "\n"
                + "I have added the following task to your list: "+ taskName + "\n"
                + HORIZONTAL_LINE);
    }

    /**
     * Prints every task in the toDoList
     */
    public void showList(){
        System.out.println(HORIZONTAL_LINE + "\n");
        toDoList.forEach((key,value) ->
                System.out.println(key.toString() + ". " + value.getTaskName() + "\n"));
        System.out.println(HORIZONTAL_LINE + "\n");
    }
}
