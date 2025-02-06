import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import backend.Task.IllegalStartAndEndDateException;
import backend.ToDoList;
import backend.Storage;
/**
 * Class that acts as the User Interface.
 *<p>
 *     Using the chatbot:
 *     - To view the list, use the following command:
 *     list
 *
 *      - To add a To Do to the list, use the following format:
 *     deadline/description
 *
 *      - To add a Deadline to the list, use the following format:
 *     deadline/description/time to be completed by
 *
 *      - To add an Event to the list, use the following format:
 *      event/description/start time/end time
 *
 *      - To mark a task as done, use the following format:
 *      mark/task index
 *
 *      - To unmark a task as done, use the following format:
 *      unmark/task index
 *
 *      - To delete a task, use the following format:
 *      delete/task index
 *
 *      - To close the chatbot, use the following command:
 *      bye
 *</p>
 */
public class SirDuke {

    public static final String HORIZONTAL_LINE =
            "____________________________________________________________";

    private Storage storage;
    private ToDoList taskList;

    /**
     * Prints exit message and exits.
     */
    public static void sayBye() {
        System.out.println(HORIZONTAL_LINE + "\n"
                + "Godspeed.\n"
                + HORIZONTAL_LINE);
        System.exit(0);
    }

    /**
     * Prints welcome message and allows the SirDuke chatbot to start receiving commands.
     * Reads user input from console and interprets them as commands.
     * Executes commands accordingly.
     * Updates and saves to listFile only if a command is SUCCESSFULLY EXECUTED.
     *
     * @param listFile the file for the contents of the ToDoList to be written into
     */
    public static void start(File listFile) {

        ToDoList taskList = new ToDoList();

        boolean isCommandSuccessful = true;

        System.out.println(HORIZONTAL_LINE + "\n"
                + "It's a pleasure to meet you. My name is Sir Duke Ellington.\n"
                + "What can I do you for?\n"
                + HORIZONTAL_LINE);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String command = scanner.nextLine();
            String regex = "/";
            String[] parsedCommand = command.split(regex);
            switch (parsedCommand[0]) { //first word of the command
                case "bye":
                    SirDuke.sayBye();
                    break;
                case "list":
                    taskList.showList();
                    break;
                case "mark":
                    try {
                        int index = Integer.parseInt(parsedCommand[1]) - 1;
                        taskList.markTaskAsDone(index);
                    } catch (ArrayIndexOutOfBoundsException e) { //no index provided after "mark"
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index." +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (NumberFormatException e) { //index provided after "mark" is not a number
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index. " +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "unmark":
                    try {
                        int index = Integer.parseInt(parsedCommand[1]) - 1;
                        taskList.unmarkTaskAsDone(index);
                    } catch (ArrayIndexOutOfBoundsException e) { //no index provided after "mark"
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (NumberFormatException e) { //index provided after "mark" is not a number
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index. " +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "todo":
                    try {
                        taskList.createToDoTask(parsedCommand[1]);
                    } catch (ArrayIndexOutOfBoundsException e) { //incomplete deadline description
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("Your todo description is incomplete. " +
                                "Use the following format: todo/description");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "deadline":
                    try {
                        taskList.createDeadlineTask(parsedCommand[1], parsedCommand[2]);
                    } catch (ArrayIndexOutOfBoundsException e) { //incomplete deadline description
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("Your deadline description is incomplete. " +
                                "Use the following format: deadline/description/timeToBeCompletedBy");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (DateTimeParseException e) {
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("Your date does not follow a format I understand." +
                                "Use the following format: yyyy-mm-dd");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "event":
                    try {
                        taskList.createEventTask(parsedCommand[1], parsedCommand[2], parsedCommand[3]);
                    } catch (ArrayIndexOutOfBoundsException e) { //incomplete deadline description
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("Your event description is incomplete. " +
                                " Use the following format: event/description/startTime/endTime");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (DateTimeParseException e) {
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("One or more of your dates do not follow a format I understand." +
                                " Use the following format: yyyy-mm-dd");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (IllegalStartAndEndDateException e) {
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println(e.toString());
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                case "delete":
                    try {
                        int index = Integer.parseInt(parsedCommand[1]) - 1;
                        taskList.deleteTask(index);
                    } catch (ArrayIndexOutOfBoundsException e) { //no index provided after "mark"
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index." +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    } catch (NumberFormatException e) { //index provided after "mark" is not a number
                        System.out.println(HORIZONTAL_LINE + "\n");
                        System.out.println("You have not provided me with a valid task index. " +
                                "Try the same command with an integer instead.");
                        System.out.println(HORIZONTAL_LINE + "\n");
                    }
                    break;
                default:
                    System.out.println(HORIZONTAL_LINE + "\n");
                    System.out.println("I'm afraid I don't understand what you mean.");
                    System.out.println(HORIZONTAL_LINE + "\n");
                    isCommandSuccessful = false; //so that we do not write to the listFile
                    break;
            } if (isCommandSuccessful) {
                try {
                    FileWriter fw = new FileWriter(listFile);
                    fw.write(taskList.toString());
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {


    }
}


